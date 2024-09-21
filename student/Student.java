package com.example.demo.student;

import jakarta.persistence.*;


@Entity
@Table
public class Student {

    @Id
    @SequenceGenerator(
            name="StudentSequence",
            sequenceName = "StudentSequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.AUTO,
            generator = "StudentSequence"
    )
    private Integer id;
    private String name;
    private String direction;
    private Integer age;

    public Student() {
    }

    public Student(Integer id, String name, String direction, Integer age) {
        this.id = id;
        this.name= name;
        this.direction = direction;
        this.age = age;
    }

    public Student(String name, String direction, Integer age) {
        this.name= name;
        this.direction = direction;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", direction='" + direction + '\'' +
                ", age=" + age +
                '}';
    }

}
