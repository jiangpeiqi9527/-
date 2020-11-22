package com.jxz.测试;

import com.jxz.手写LinkedList.MyLinkedList;
import com.jxz.模拟动态数组.MyArrayList;
import com.jxz.集合接口.List;
import org.junit.Test;

public class ListTest {
    @Test
    public void test01() {
        List<Integer> list = new MyLinkedList<>();
        list.add(11);
        list.add(22);
        list.add(33);
        list.add(14);
        list.add(15);
        list.remove(2);
        list.add(1,9527);
        System.out.println(list);
    }
    @Test
    public void test02() {
        List<Integer> list = new MyArrayList<>();
        for (int i = 0; i < 50; i++) {
            list.add(i);
        }
        for (int i = 0; i < 50; i++) {
            list.remove(0);
        }
        System.out.println(list);
    }

}
