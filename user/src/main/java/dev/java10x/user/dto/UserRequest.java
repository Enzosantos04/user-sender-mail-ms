package dev.java10x.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserRequest {
    @NotBlank(message = "name is required")
    private String name;
    @NotBlank(message = "name is required")
    @Email(message = "email is wrong format")
    private String email;
}
