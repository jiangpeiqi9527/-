package com.jxz._01背包;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Knapsack {
    public static void main(String[] args) {
        select((Article article1, Article article2) -> {
            return Double.compare(article2.valueDensity,article1.valueDensity);
        });
        select((article1,article2) -> {
            return article2.value - article1.value;
        });
    }
    static void select (Comparator<Article> comparator) {
        Article[] articles = new Article[] {
                new Article(35, 10), new Article(30, 40),
                new Article(60, 30), new Article(50, 50),
                new Article(40, 35), new Article(10, 40),
                new Article(25, 30)
        };
        Arrays.sort(articles,comparator);
        int capacity = 150, weight = 0, value = 0;
        List<Article> list = new LinkedList<>();
        for (int i = 0; i < articles.length && weight < capacity; i++) {
            int newWeight = weight + articles[i].weight;
            if (newWeight <= capacity) {
                weight = articles[i].weight + weight;
                value = articles[i].value + value;
                list.add(articles[i]);
            }
        }
        System.out.println(list);
        System.out.println(value);
        System.out.println(weight);
    }
}
