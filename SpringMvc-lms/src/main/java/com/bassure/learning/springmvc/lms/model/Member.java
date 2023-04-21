package com.bassure.learning.springmvc.lms.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Member {

    private int member_id;
    private String name;
    private int age;
    private String gender;
    private long phone_Number;
    private String memberStatus;

}
