package com.application.lms.apirequest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MemberRequest {

    private int id;
    private String name;
    private String password;
    private int age;
    private String gender;
    private long num;
    private String userRole;
}
