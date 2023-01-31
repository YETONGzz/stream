package com.yetong;

import java.util.Optional;

public class OptionalTest {

    public static void main(String[] args){
        OptionalTest optionalTest = new OptionalTest();
        optionalTest.aa();
    }


    public  void aa() {
        Person person = null;
        Optional<Person> optionalPerson = Optional.ofNullable(person);
        optionalPerson.map(Person::getName).ifPresent(System.out::println);

        optionalPerson.orElseGet(this::create);
        System.out.println(optionalPerson.isPresent());
    }

    public Person create(){
        System.out.println("aaa");
        return new Person("Tom", 8900, 23, "male", "New York");
    }
}
