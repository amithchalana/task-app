package lk.ijse.dep9.app;


import org.apache.commons.codec.digest.DigestUtils;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@SpringBootApplication
public class AppInitializer {

    public static void main(String[] args) {SpringApplication.run(AppInitializer.class,args);}

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {  // HttpSecurity filter chain built class
       return http.authorizeHttpRequests()
               .mvcMatchers(HttpMethod.POST,"/api/v1/users").permitAll()
                .mvcMatchers("/api/v1/auth/**").permitAll()
               .anyRequest().authenticated()
                .and()
                .csrf().disable()   // use with serverside rendering csrf - cross side request forgery
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.NEVER)
                .and()
                .httpBasic()   //get basic authentication
                .and().build();


       // all request doesnt need to move  through the default filter chain
        // need to create a filter chain proxy
        //HttpSecurity to build the filter chain an set the chain proxi
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new PasswordEncoder() {
            @Override
            public String encode(CharSequence rawPassword) {
                return DigestUtils.sha256Hex(rawPassword+"");
            }

            @Override
            public boolean matches(CharSequence rawPassword, String encodedPassword) {
                return encodedPassword.matches(DigestUtils.sha256Hex(rawPassword+""));
            }
        };
    }

}
