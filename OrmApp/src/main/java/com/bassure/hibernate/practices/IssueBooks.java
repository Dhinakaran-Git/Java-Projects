package com.bassure.hibernate.practices;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
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
@Entity
@Table(name = "lms_IssueBooks")
public class IssueBooks {

    @Id
    @Column(name = "IssueBook_id")
    private int issueBookId;
    
    @Column(name = "In_Date")
    private LocalDate inDate;
    
    @Column(name = "Out_Date")
    private LocalDate outDate;
    
    @Column(name = "Member_id")
    private int memberId;
    
    @Column(name = "BookCopies_id")
    private int bookCopiesId;
    
    @Column(name = "Is_returned")
    private boolean isReturned;
}
