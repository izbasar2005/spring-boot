package com.example.SpringBoot.beans;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component
@Scope(value = "prototype")
@Getter
@Setter
public class TestA {
    public TestA(){
        System.out.println("I am creating new object of Test A");
        this.name="Some name";
        this.price=2000;
    }
    public TestA(String name){

        this.name=name;
    }

    private String name;
    private int price;
}
