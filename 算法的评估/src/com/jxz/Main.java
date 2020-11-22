package com.jxz;

import org.junit.Test;

public class Main {
    public static int fib1 (int n) {
        if (n <= 1) return n;
        return fib1(n - 1) + fib1(n - 2);
    }

    public static int fib2 (int n) {
        if (n <= 1) return n;
        int first = 0;
        int second = 1;
        int sum = 0;
        for (int i = 0;i < n - 1;i++) {
            sum = first + second;
            first = second;
            second = sum;
        }
        return second;
    }

    @Test
    public void test01 ( ) {
        int n = 30;
        MyTimeTool.check("fib1", new MyTimeTool.Task() {
            @Override
            public void execute() {
                fib1(n);
            }
        });
        MyTimeTool.check("fib2",() -> {fib2(n);});
    }
}
