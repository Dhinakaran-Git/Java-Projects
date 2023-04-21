package com.mycompany.webflux;

import java.util.Arrays;
import java.util.stream.Stream;

public class StreamsPractices {

    public static void main1(String[] args) {
        String[] arr = new String[]{"a", "b", "c"};
        Stream<String> streamOfArrayFull = Arrays.stream(arr);
        Stream<String> streamOfArrayPart = Arrays.stream(arr, 1, 3);
        System.out.println("streamOfArrayFull : "+streamOfArrayFull.iterator().next());
        System.out.println("streamOfArrayPart : "+streamOfArrayPart.iterator().next());
    }
    
    public static void main(String[] args) {
        
    }
}
