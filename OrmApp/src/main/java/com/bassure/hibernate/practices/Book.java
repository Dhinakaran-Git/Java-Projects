package com.bassure.hibernate.practices;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
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
@Table(name = "lms_Books")
public class Book {

    @Id
    @Column(name = "Book_id")
    private int bookid;
    @Column(name = "title")
    private String title;
    @Column(name = "Isbn_no")
    private int isbnNo;
    
    @ManyToMany
        @JoinTable(name = "lms_Author_Book", joinColumns = {
        @JoinColumn(name = "Book_id")}, inverseJoinColumns = {
        @JoinColumn(name = "Author_id")})
    private List<Author> authors;
    
    @OneToMany(mappedBy = "bookCopiesId")
    private List<BookCopies> bookCopies;
}
