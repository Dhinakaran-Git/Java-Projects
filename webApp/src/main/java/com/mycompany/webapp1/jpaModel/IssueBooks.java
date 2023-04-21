package com.mycompany.webapp1.jpaModel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "lms_issuebooks")
public class IssueBooks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "issuebook_id")
    private int issueBookId;

    @Column(name = "in_date")
    private String inDate;

    @Column(name = "out_date")
    private String outDate;

    @Column(name = "member_id")
    private int memberId;

    @Column(name = "bookcopies_id")
    private int bookCopiesId;

    @Column(name = "is_returned")
    private boolean isReturned;
    
    @ManyToOne
    @JoinColumn(name = "bookcopies_id", insertable=false, updatable=false)
    private BookCopies bookcopies;
    
    @ManyToOne
    @JoinColumn(name = "member_id", insertable=false, updatable=false)
    private Member member;

    public IssueBooks(int issueBookId, String outDate, int memberId, int bookCopiesId, boolean isReturned) {
        this.issueBookId = issueBookId;
        this.outDate = outDate;
        this.memberId = memberId;
        this.bookCopiesId = bookCopiesId;
        this.isReturned = isReturned;
    }
}
