package com.bassure.hibernate.practices;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.ManyToAny;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "lms_BookCopies")
public class BookCopies {

    @Id
    @Column(name = "BookCopies_id")
    private int bookCopiesId;
    @Column(name = "Book_id")
    private int bookId;
    @Column(name = "Book_Status")
    private String bookStatus;
    
//    @ManyToOne(fetch = FetchType.EAGER)
//    private Book bk;
    
    @OneToMany(mappedBy = "issueBookId")
    private List<IssueBooks> issueBooks;
}
