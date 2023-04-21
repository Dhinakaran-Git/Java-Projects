package com.application.lms.apirequest;

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
    
    private int bid;

    private String name;

    private List<String> authors;

    private int isbn;
    
}
