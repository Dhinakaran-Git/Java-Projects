package com.application.lms.apirequest;

import com.application.lms.entity.Author;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BookRequest {

    private String title;
    
    private int isbnNo;
    
    private List<String> authorName;
}
