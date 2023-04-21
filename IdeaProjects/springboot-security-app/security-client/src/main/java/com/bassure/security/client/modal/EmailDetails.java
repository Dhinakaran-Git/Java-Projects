package com.bassure.security.client.modal;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class EmailDetails {
    private String to;
    private String subject;
    private String message;
}
