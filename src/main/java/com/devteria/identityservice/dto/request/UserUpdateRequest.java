package com.devteria.identityservice.dto.request;

import com.devteria.identityservice.entity.Role;

import lombok.*;
import lombok.experimental.FieldDefaults;



@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserUpdateRequest {
    String password;
    Role role;
   
}
