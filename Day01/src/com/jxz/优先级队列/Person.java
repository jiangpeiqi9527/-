package com.jxz.优先级队列;

public class Person {
    private String name;
    private int boneBreak;

    public Person(String name, int boneBreak) {
        this.name = name;
        this.boneBreak = boneBreak;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", boneBreak=" + boneBreak +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBoneBreak() {
        return boneBreak;
    }

    public void setBoneBreak(int boneBreak) {
        this.boneBreak = boneBreak;
    }
}
