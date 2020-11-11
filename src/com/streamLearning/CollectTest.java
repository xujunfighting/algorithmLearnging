package com.streamLearning;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @Description
 * @Author xujun
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/8/6
 */
public class CollectTest {
    public static void main(String[] args) {
//        List<String> stringss = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
//        List<String> collect = stringss.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
//
//        System.out.println(collect);




//        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
////
////        IntSummaryStatistics stats = numbers.stream().mapToInt(x->x).summaryStatistics();
////
////        System.out.println("列表中最大的数 : " + stats.getMax());
////        System.out.println("列表中最小的数 : " + stats.getMin());
////        System.out.println("所有数之和 : " + stats.getSum());
////        System.out.println("平均数 : " + stats.getAverage());



//        List<String> myList =
//                Arrays.asList("a1", "a2", "b1", "c2", "c1");
//        myList
//                .stream()
//                .filter(s -> s.startsWith("c"))
//                .map(String::toUpperCase)
//                .sorted()
//                .forEach(System.out::println);



//        Arrays.asList("a1", "a2", "a3")
//                .stream()
//                .findFirst()
//                .ifPresent(System.out::println);



//        IntStream.range(1, 6)
////                .forEach(System.out::println);


//        double v = Arrays.stream(new int[]{1, 2, 3})
//                .map(n -> 2 * n + 1)
//                .average()
//                .getAsDouble();
       // System.out.println(v);
        //.ifPresent(System.out::println);

//        Stream.of("d2", "a2", "b1", "b3", "c")
//                .filter(s -> {
//                    System.out.println("filter: " + s);
//                    return true;
//                })
//                .forEach(s -> System.out.println("forEach: " + s));

//        Stream.of("d2", "a2", "b1", "b3", "c")
//                .map(s -> {
//                    System.out.println("map: " + s);
//                    return s.toUpperCase();
//                })
//                .filter(s -> {
//                    System.out.println("filter: " + s);
//                    return s.startsWith("A");
//                })
//                .forEach(s -> System.out.println("forEach: " + s));


        Stream.of("d2", "a2", "b1", "b3", "c")
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return s.startsWith("a");
                })
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                })
                .forEach(s -> System.out.println("forEach: " + s));



    }
}
