package com.application.lms.entity;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "lms_members")
public class Member implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private int memberId;

    @Column(name = "username")
    private String name;

    @Column(name = "password")
    private String password;
    
    @Column(name = "age")
    private int age;

    @Column(name = "gender")
    private String gender;

    @Column(name = "phone_number")
    private long number;
    
    @Nonnull
    @Column(name = "memberstatus")
    private String memberStatus;
    
    @Column(name = "user_role")
    private String userRole;

    @OneToMany(mappedBy = "memberId")
    private List<IssueBooks> issueBooks;

    public Member(int memberId, String name, int age, String gender, long number) {
        this.memberId = memberId;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.number = number;
    }

    public Member(int memberId,String name, int age, String gender, long number, String meberStatus) {
        this.memberId = memberId;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.number = number;
        this.memberStatus = meberStatus;
    }
    
      public Member(String name, String password, int age, String gender, long number, String userRole, String meberStatus) {
        this.name = name;
        this.password = password;
        this.age = age;
        this.gender = gender;
        this.number = number;
        this.userRole = userRole;
        this.memberStatus = meberStatus;
    }
}
