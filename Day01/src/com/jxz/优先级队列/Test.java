package com.jxz.优先级队列;

import java.util.Comparator;

public class Test {

    @org.junit.Test
    public void test01 () {
        PriorityQueue<Person> queue = new PriorityQueue<>(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getBoneBreak() - o2.getBoneBreak();
            }
        });
        queue.enQueue(new Person("jack",2));
        queue.enQueue(new Person("rose",10));
        queue.enQueue(new Person("jake",5));
        queue.enQueue(new Person("james",15));
        while (!queue.isEmpty()) {
            System.out.println(queue.deQueue());
        }
    }
}
