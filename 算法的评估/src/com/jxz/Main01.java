package com.jxz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        Map<String,Integer> map = new HashMap<>();
        for (int i = 1; i <= num; i++) {
            String str = in.next();
            String[] split = str.split(",");
            Integer temp = Integer.parseInt(split[1]);
            map.put(split[0],temp);
        }
        List<String> list = new ArrayList<>();
        for (String key : map.keySet()) {
            list.add(key);
        }
        String temp = "";
        boolean flag = false;
        for (int i = 0; i < list.size() - 1;i++) {
            for (int j = 0;j < list.size() - 1 - i;j++) {
                if (map.get(list.get(j)) > map.get(list.get(j+1))) {
                    flag = true;
                    temp = list.get(j);
                    list.add(j,list.get(j + 1));
                    list.add(j + 1,temp);
                }
            }
            if (!flag) {
                break;
            }
            flag = false;
        }
        for (String bookname : list) {
            System.out.println(bookname+","+map.get(bookname));
        }
    }
}
