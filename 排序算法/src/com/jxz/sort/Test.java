package com.jxz.sort;

public class Test {
    public static void main(String[] args) {
        String str = "aaa";
        Test t = new Test();
        try {
            Thread.currentThread().sleep(60 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(t.getClass().getClassLoader().getClass().getClassLoader());
        System.out.println(str.getClass().getClassLoader()/*.getClass().getName()*/);
        System.out.println(str.getClass().getClassLoader()/*.getClass().getClassLoader().getClass().getName()*/);
    }
}
