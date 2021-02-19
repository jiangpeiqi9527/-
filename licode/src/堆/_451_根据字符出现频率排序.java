package 堆;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class _451_根据字符出现频率排序 {
    public String frequencySort(String s) {
        if (s == null || s.length() == 0) return s;
        Map<Character,Integer> presentFrequency = new HashMap<>();
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            presentFrequency.put(arr[i],presentFrequency.getOrDefault(arr[i],0) + 1);
        }
        PriorityQueue<Character> pq = new PriorityQueue<>(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return presentFrequency.get(o2) - presentFrequency.get(o1);
            }
        });
        for (Character c : presentFrequency.keySet()) {
            pq.offer(c);
        }
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            Character value = pq.poll();
            for (int i = 0; i < presentFrequency.get(value); i++) {
                sb.append(value);
            }
        }
        return sb.toString();
    }
}
