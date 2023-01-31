package com.yetong;

import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * lambda表达式 对函数式接口的使用进行简化 ->左边为接口方法的参数 ->右边为接口方法的方法体
 */
public class LambdaTest {

    public static void main(String[] args) {

        new Thread(()-> System.out.println("aaaa")).start();

        //无参数无返回值类型
        Runnable runnable=()-> System.out.println("Runnable 运行");
        runnable.run();//结果：Runnable 运行


        //一个参数无返回值类型
        Consumer<String> consumer=x-> System.out.println(x);
        consumer.accept("Hello Consumer");//结果：Hello Consumer
        Consumer<String> consumer1 = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };


        //两个参数且有返回值
        Comparator<Integer> com=(x, y)->{
            System.out.println("函数式接口");
            return Integer.compare(x,y);
        };
        System.out.println(com.compare(2,4));//结果：-1
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        };


        //两个参数且有返回值 但只有一条语句所以无需大括号和return
        Comparator<Integer> com2= Integer::compare;
        System.out.println(com2.compare(4,2));//结果：1

        Supplier<String> supplier1 = ()-> "aaa";
        supplier1.get();

        Supplier<String> supplier = new Supplier<String>() {
            @Override
            public String get() {
                return null;
            }
        };

    }
}
