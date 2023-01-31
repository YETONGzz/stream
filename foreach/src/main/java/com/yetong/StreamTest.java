package com.yetong;

import java.util.*;
import java.util.stream.Collectors;

public class StreamTest {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(7, 6, 9, 3, 8, 2, 1);

        // 遍历输出符合条件的元素
        list.stream().filter(x -> x > 6).forEach(System.out::println);
        // 匹配第一个
        Optional<Integer> findFirst = list.stream().filter(x -> x > 6).findFirst();
        // 匹配任意（适用于并行流）
        Optional<Integer> findAny = list.parallelStream().filter(x -> x > 6).findAny();
        // 是否包含符合特定条件的元素
        boolean anyMatch = list.stream().anyMatch(x -> x > 6);
        System.out.println("匹配第一个值：" + findFirst.get());
        System.out.println("匹配任意一个值：" + findAny.get());
        System.out.println("是否存在大于6的值：" + anyMatch);

        List<Person> personList = new ArrayList<Person>();
        personList.add(new Person("Tom", 8900, 23, "male", "New York"));
        personList.add(new Person("Jack", 7000, 25, "male", "Washington"));
        personList.add(new Person("Lily", 7800, 21, "female", "Washington"));
        personList.add(new Person("Anni", 8200, 24, "female", "New York"));
        personList.add(new Person("Owen", 9500, 25, "male", "New York"));
        personList.add(new Person("Alisa", 7900, 26, "female", "New York"));

        //筛选出薪资大于8000的人的姓名并且收集为list集合
        List<String> fiterList = personList.stream().filter(x -> x.getSalary() > 8000).map(Person::getName)
                .collect(Collectors.toList());
        System.out.print("薪资高于8000美元的员工：" + fiterList);

        List<String> list2 = Arrays.asList("adnm", "admmt", "pot", "xbangd", "weoujgsd");
        //获取集合中长度最大的字符串
        Optional<String> max = list2.stream().max(Comparator.comparing(String::length));
        System.out.println("最长的字符串：" + max.get());

        List<Integer> list3 = Arrays.asList(7, 6, 9, 4, 11, 6);

        // 自然排序
        Optional<Integer> max2 = list3.stream().max(Integer::compareTo);
        // 自定义排序（从大到小排序）
        Optional<Integer> max3 = list3.stream().max((o1, o2) -> o2 - o1);
        System.out.println("自然排序的最大值：" + max2.get());
        System.out.println("自定义排序的最大值：" + max3.get());

        Optional<Person> max4 = personList.stream().max(Comparator.comparing(Person::getSalary));
        System.out.println("员工薪资最大值：" + max4.get().getSalary());

        long count = list3.stream().filter(e -> e > 6).count();

        System.out.println("list中大于6的元素个数：" + count);

        String[] strArr = { "abcd", "bcdd", "defde", "fTr" };
        List<String> strList = Arrays.stream(strArr).map(String::toUpperCase).collect(Collectors.toList());

        List<Integer> intList = Arrays.asList(1, 3, 5, 7, 9, 11);
        List<Integer> intListNew = intList.stream().map(x -> x + 3).collect(Collectors.toList());

        System.out.println("每个元素大写：" + strList);
        System.out.println("每个元素+3：" + intListNew);

        Optional<Person> person = Optional.of(new Person("Tom", 8900, 23, "male", "New York"));

    }

}
