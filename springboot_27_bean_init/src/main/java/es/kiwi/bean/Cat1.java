package es.kiwi.bean;

import org.springframework.stereotype.Component;

@Component
public class Cat1 {

    public Cat1() {

    }

    int age;

    public Cat1(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Cat1{" +
                "age=" + age +
                '}';
    }
}
