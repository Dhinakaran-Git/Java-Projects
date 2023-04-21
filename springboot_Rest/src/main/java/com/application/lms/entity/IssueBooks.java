package com.application.lms.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
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
@Table(name = "lms_issuebooks")
public class IssueBooks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "issuebook_id")
    private int issueBookId;

    @Column(name = "in_Date")
    private String inDate;

    @Column(name = "out_Date")
    private String outDate;

    @Column(name = "member_id")
    private int memberId;

    @Column(name = "bookcopies_id")
    private int bookCopiesId;

    @Column(name = "is_returned")
    private boolean isReturned;

    @OneToOne()
    @JoinColumn(name = "bookcopies_id", insertable = false, updatable = false)
    private BookCopies bookcopies;
    
    @ManyToOne
    @JoinColumn(name = "member_id", insertable=false, updatable=false)
    @JsonBackReference
    private Member member;
}
