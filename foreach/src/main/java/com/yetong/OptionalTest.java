package com.yetong;

import java.util.Optional;

public class OptionalTest {

    public static void main(String[] args) throws Exception {
        OptionalTest optionalTest = new OptionalTest();
        optionalTest.aa();
    }




    public  void aa() throws Exception {
        Person person = null;
        Optional<Person> optionalPerson = Optional.ofNullable(person);
        optionalPerson.map(Person::getName).ifPresent(System.out::println);

        Optional<Integer> integer = optionalPerson.map(e -> e.getAge() + 1);

        optionalPerson.orElseGet(this::create);
        System.out.println(optionalPerson.isPresent());

        Optional<Object> empty = Optional.empty();

        // 依据一个非空值创建Optional
        Optional<Person> os1 = Optional.of(person);

        // 可接受null的Optional
        Person student1 = null;
        Optional<Person> os2 = Optional.ofNullable(student1);

        // 利用Optional的ifPresent方法做出如下：当student不为空的时候将name赋值为张三
        Optional.ofNullable(person).ifPresent(p->p.setName("aaa"));

        Optional<Person> os13 = Optional.ofNullable(person);
        // 使用get一定要注意，假如student对象为空，get是会报错的
        // java.util.NoSuchElementException: No value present
        Person student2 = os1.get();

        // 当student为空的时候,返回我们新建的这个对象,有点像三目运算的感觉
        Person student3 = os1.orElse(new Person("Tom", 8900, 23, "male", "New York"));

        // orElseGet就是当student为空的时候，返回通过Supplier供应商函数创建的对象
        Person person1 = os1.orElseGet(() -> new Person("Tom", 8900, 23, "male", "New York"));

        // 有值将其返回否则可以抛出我们指定的异常
        os13.orElseThrow(() -> new Exception());
    }

    public Person create(){
        System.out.println("aaa");
        return new Person("Tom", 8900, 23, "male", "New York");
    }
}
