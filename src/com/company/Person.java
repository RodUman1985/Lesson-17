package com.company;

import java.io.Serializable;

public class Person implements Serializable {
    public transient String name;// trancient - делает поле не сериализуемым
    public int sex2;
    private  static  final  long serialVersionUID=2;//!!
    public void setAge(int age) {
        this.age = age;
    }

    private int age;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
