package com.jxz.串;

public class Main {
    public static void main(String[] args) {
        int index = BruteForce01.indexOf("Hello World","or");
        Asserts.test(index == 7);
    }
}
