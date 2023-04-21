package application.lms.model.jpaModel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.List;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Entity
@Table(name = "lms_bookcopies")
public class BookCopies implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bookcopies_id")
    private int bookCopiesId;

    @Column(name = "book_id")
    private int bookid;

    @Column(name = "book_status")
    private String bookStatus;

    @ManyToOne(fetch = FetchType.EAGER)
    @Cascade(CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "book_id", insertable = false, updatable = false)
    private Books book;

    @OneToMany(mappedBy = "bookcopies")
    private List<IssueBooks> issueBooks;

    public BookCopies(int bookCopiesId, int bookid, String bookStatus) {
        this.bookCopiesId = bookCopiesId;
        this.bookid = bookid;
        this.bookStatus = bookStatus;
    }
}
