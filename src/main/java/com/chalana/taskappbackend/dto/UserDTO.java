package com.chalana.taskappbackend.dto;

import com.chalana.taskappbackend.util.ValidationGroups;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(value ="password", allowSetters = true )
public class UserDTO implements Serializable {

    @NotBlank(message = "Full name can't be empty or null")
    @Pattern(regexp = "^[A-Za-z ]+$",message = "Invalid name")
    private String fullName;
    @NotBlank(message = "username can't be empty or null",groups = ValidationGroups.Create.class)
    private String username ;
    @NotBlank(message = "Password can't be empty or null")
    @Length(min = 5, message = "Password should be at least 5 character long")
    private String password;
}
