package com.example.userService.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Schema(description = "User")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDTO {

    @Schema(description = "User name", example = "Alex Bod")
    @NotBlank(message = "Username is required")
    private String userName;

    @Schema(description = "Email", example = "alexbod@mail.ru")
    @Email(message = "Email should be valid")
    @NotBlank(message = "Email is required")
    private String email;

    @Schema(description = "Age", example = "18")
    @NotBlank(message = "Age is required")
    private int age;
}
