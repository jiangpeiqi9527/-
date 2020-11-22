package com.jxz;

import java.util.Scanner;

public class Test01 {
    public static void main(String[] args) {
//        Person jxz = new Person("jxz", 18);
//        System.out.println(jxz);
//        method(jxz).setAge(20);
//        System.out.println(jxz);
        method();
    }
    public static Person method (Person person) {
        return person;
    }
    public static void method () {
        Scanner sc = new Scanner(System.in);
        String total = sc.nextLine();
        String num = sc.nextLine();
        String[] nums = num.split(" ");
        int count = 0;
        int[] inums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            inums[i] = Integer.parseInt(nums[i]);
        }
        for (int i : inums) {
            if (i < 0) {
                count++;
            }
        }
        //for (String str : nums) {
        //    if (str < 0) {
        //        count++;
        //    }
        //}
        System.out.println(count);
    }
}
