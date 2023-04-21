package javaapplication1.Lambda;

import java.util.Arrays;
import java.util.List;
import java.util.random.RandomGenerator;

public class LambdaDemo {

    public static void main1(String[] args) {
        int result
                = RandomGenerator.getDefault().ints(600, 100, 1000)
                        .boxed()
//                        .peek(e -> System.out.print(e + " "))
                        .flatMap(e -> Arrays.stream(e.toString().split("")))
                        .mapToInt(Integer::valueOf)
                        .sum();

        System.out.println("");
        System.out.println(result);
    }

    public static void main(String[] args) {
        List<Integer> values = Arrays.asList(10, 12, 18, 15, 13, 9, 7, 5);

        //asending order
//        values.sort((a, b) -> a - b);

        //desending order
//        values.sort((a, b) -> b - a);

        // :: is method Expresstion
        values.forEach(System.out::println);

        //sum of indivial numbers
        int result = values
                .stream()
                .mapToInt(e -> e)
                .map(e -> {
                    int sum = 0;
                    int v = e;
                    while (v > 0) {
                        sum = sum + v % 10;
                        v = v / 10;
                    }
                    return sum;
                }
                )
                .sum();

        System.out.println("sum of indivial numbers Another way : "
                + values
                        .stream()
                        .flatMap(e -> Arrays.stream(e.toString().split("")))
                        .map(e -> Integer.valueOf(e))
                        .mapToInt(e -> e)
                        .sum()
        );

        System.out.println(values);
        System.out.println(result);
    }
}
