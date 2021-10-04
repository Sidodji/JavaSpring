package com.example.java_spring_1.model;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private  int count;
    private int id;
    private String name;
    private String surname;

    public Person(String name, String surname)
    {
        this.id=count++;
        this.name = name;
        this.surname = surname;
    }
}

