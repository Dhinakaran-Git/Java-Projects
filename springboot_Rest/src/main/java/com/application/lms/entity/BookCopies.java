package com.application.lms.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
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

    @ManyToOne(fetch = FetchType.EAGER,optional = false)
    @Cascade(CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "book_id", insertable = false, updatable = false)
    @JsonBackReference
    private Books book;

    @OneToOne(mappedBy = "bookcopies")
    @JsonIgnore
    private IssueBooks issueBooks;

}
