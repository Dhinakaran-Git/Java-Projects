package com.bassure.learning.springmvc.lms.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BookCopies {

    private int bookCopiesId;
    private int bookId;
    private String status;
}
