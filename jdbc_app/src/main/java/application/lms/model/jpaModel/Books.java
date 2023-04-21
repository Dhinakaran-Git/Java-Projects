package application.lms.model.jpaModel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "lms_books")
public class Books implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private int bookId;
    
    @Column(name = "title")
    private String title;
    
    @Column(name = "isbn_no")
    private int isbnNo;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "lms_author_book", joinColumns = {
        @JoinColumn(name = "book_id")}, inverseJoinColumns = {
        @JoinColumn(name = "author_id")})
    @Cascade({CascadeType.SAVE_UPDATE, CascadeType.MERGE, CascadeType.PERSIST})
    private List<Author> authors;

    @OneToMany(mappedBy = "book", fetch = FetchType.EAGER)
    private List<BookCopies> bookCopies;

    public Books(int bookId, String title, int isbnNo, List<Author> authors) {
        this.bookId = bookId;
        this.title = title;
        this.isbnNo = isbnNo;
        this.authors = authors;
    }

    @Override
    public String toString() {
        return "Books{" + "bookId=" + bookId + ", title=" + title + ", isbnNo=" + isbnNo + ", authors=" + Arrays.toString(authors.stream().toArray()) + '}';
    }

}
