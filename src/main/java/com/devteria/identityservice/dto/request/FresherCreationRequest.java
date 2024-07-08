package com.devteria.identityservice.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FresherCreationRequest {
    @Email(message = "EMAIL_INVALID")
    @Size(min = 5, message = "EMAIL_SIZE_INVALID")
    String email;
    @Size(min = 3,message = "NAME_INVALID")
    String name;
    @Size(min = 3,message = "PROGRAMMING_LANGUAGE_INVALID")
    String programmingLanguage;
    
    
}
