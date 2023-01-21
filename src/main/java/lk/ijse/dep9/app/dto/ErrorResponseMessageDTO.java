package lk.ijse.dep9.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponseMessageDTO implements Serializable {
    private String message;
    private String status;



}
