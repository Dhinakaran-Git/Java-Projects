package com.application.lms.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
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
    
    @OneToOne
    @JoinColumn(name = "bookcopies_id", insertable=false, updatable=false)
    private BookCopies bookcopies;

    public IssueBooks(int issueBookId, String outDate, int memberId, int bookCopiesId, boolean isReturned) {
        this.issueBookId = issueBookId;
        this.outDate = outDate;
        this.memberId = memberId;
        this.bookCopiesId = bookCopiesId;
        this.isReturned = isReturned;
    }
    
}
