package com.yetong;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionTest {

    Map<String, Person> map = new HashMap() {{
        put("tom", new Person("Tom", 8900, 23, "male", "New York"));
        put("jack", new Person("Jack", 8900, 23, "male", "New York"));
    }};

    public static void main(String[] args) {
        FunctionTest functionTest = new FunctionTest();
        functionTest.test();
    }

    public void test() {
        Consumer(10, x -> System.out.println(x * 20));
        System.out.println(Supplier(() -> 100));
        Function(map, map -> map.get("tom"));
        Predicate(map, map -> map.get("jack").getName().equals("Jack"));
    }

    /**
     * Consumer  消费型函数式接口 有参数无返回值
     *
     * @param integer
     * @param consumer
     */
    public void Consumer(Integer integer, Consumer<Integer> consumer) {
        System.out.println("Consumer方法执行");
        consumer.accept(integer);
    }

    /**
     * Supplier  提供型函数式接口 无参数有返回值
     *
     * @param supplier
     * @param <T>
     * @return
     */
    public <T> T Supplier(Supplier<T> supplier) {
        System.out.println("Supplier方法执行");
        return supplier.get();
    }

    /**
     * Function 函数型接口 有参数有返回值
     *
     * @param t
     * @param function
     * @param <T>
     * @param <R>
     * @return
     */
    public <T, R> R Function(T t, Function<T, R> function) {
        R apply = function.apply(t);
        System.out.println(apply);
        return apply;
    }

    /**
     * Predicate  断言型函数式接口 有参数有返回值
     *
     * @param t
     * @param predicate
     * @param <T>
     * @return
     */
    public <T> boolean Predicate(T t, Predicate<T> predicate) {
        System.out.println(predicate.test(t));
        return predicate.test(t);
    }
}
