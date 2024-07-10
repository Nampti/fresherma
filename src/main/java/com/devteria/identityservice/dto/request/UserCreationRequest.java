package com.devteria.identityservice.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserCreationRequest {
    @Size(min = 3,message = "USERNAME_INVALID")
    String username;

    @Size(min = 8, message = "INVALID_PASSWORD")
    String password;
    @Email(message = "EMAIL_INVALID")
    @Size(min = 5, message = "EMAIL_SIZE_INVALID")
    String email;
    @Size(min = 3,message = "NAME_INVALID")
    String name;
    
    
}
