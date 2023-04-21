package com.bassure.security.client.modal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserModal {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String matchingPassword;
}
