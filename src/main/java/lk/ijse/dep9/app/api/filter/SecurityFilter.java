package lk.ijse.dep9.app.api.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class SecurityFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        if (req.getServletPath().matches("api/v1/users/?") && req.getMethod().equals("Post")) {
            chain.doFilter(req,res);
        }else if(req.getServletPath().matches("/api/v1/auth/.+")) {
            chain.doFilter(req,res);
        }else {

            String authorization = req.getHeader("Authorization");
            if (authorization != null) {
                String token = authorization.substring("Basic".length() + 1);
                String credentials = new String(Base64.getDecoder().decode(token));
                String userName = credentials.split(":")[0];
                String password = credentials.split(":")[1];

                System.out.println(userName + password);
            }


            HashMap<String, Object> errAttributes = new LinkedHashMap<>();
            errAttributes.put("status", HttpStatus.UNAUTHORIZED.value());
            errAttributes.put("error", HttpStatus.UNAUTHORIZED.getReasonPhrase());
            errAttributes.put("message","Invalid login credentials!");
            errAttributes.put("timeStamp", new Date().toString());
            res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            ObjectMapper objectMapper = new ObjectMapper();
            res.setContentType("application/json");
            objectMapper.writeValue(res.getWriter(),errAttributes);



        }
    }
}
