package com.yetong;

import java.util.stream.Stream;

/**
 * stream流的静态操作
 */
public class OneDemo {

    public static void main(String[] args) {
        //将内容转化为stream流
        Stream<Integer> stream = Stream.of(1,2,3,4);

        //转换4个 x从零开始， x乘3+1的数字为stream流
        Stream<Integer> stream2 = Stream.iterate(1, (x) -> x + 3).limit(4);
        stream2.forEach(System.out::println);

        //生成三个随机小数
        Stream<Double> stream3 = Stream.generate(Math::random).limit(3);
        stream3.forEach(System.out::println);
    }


}
