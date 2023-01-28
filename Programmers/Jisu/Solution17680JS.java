package Jisu;

import java.util.LinkedList;
import java.util.Queue;

public class Solution17680JS {
    public int solution(int cacheSize, String[] cities) {
        // cache hit: cache 에 데이터가 있을 경우 / cache miss: cache 에 데이터가 없을 경우
        int answer = 0;
        Queue<String> cache = new LinkedList<>();
        if (cacheSize == 0) return cities.length * 5;

        int size = 1;
        for (String s : cities) {
            String city = s.toLowerCase();
            if (size <= cacheSize) {
                if (cache.contains(city)) {
                    cache.remove(city);
                    cache.add(city);
                    answer += 1;
                } else {
                    cache.add(city);
                    size+=1;
                    answer += 5;
                }
            } else {
                if (cache.contains(city)) {
                    cache.remove(city);
                    cache.add(city);
                    answer += 1;
                } else {
                    cache.poll();
                    cache.add(city);
                    answer += 5;
                }
            }
        }
        return answer;
    }
}
