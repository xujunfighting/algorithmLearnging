package com.streamLearning;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Description
 * @Author xujun
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/8/7
 */
public class IteratorTest {
    public static void main(String[] args) {
        Stream.iterate(1, item -> item + 1
        ).limit(10).forEach(System.out::println);
        List<Integer> lists=new ArrayList<>();
        for(int i=1;i<=10;i++){
            lists.add(i);
        }
        Integer reduce = lists.stream().reduce((p1, p2) -> {
            return p1 + p2;
        }).get();
        System.out.println(reduce);
        Integer min = lists.stream().min(Integer::compareTo).get();
        Integer max = lists.parallelStream().max(Integer::compareTo).get();
        List<Integer> collect = lists.stream().sorted((p1, p2) -> {
            if (p1 > p2) {
                return -1;
            } else if (p1 < p2) {
                return 1;
            } else {
                return 0;
            }
        }).collect(Collectors.toList());
        System.out.println(collect);
        System.out.println(max);
        System.out.println(min);
    }
}
