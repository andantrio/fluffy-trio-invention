package DoHyung;

import java.util.*;

class Solution17680DH {
    public int solution(int cacheSize, String[] cities) {
        if (cacheSize==0) {
            return cities.length*5;
        }

        int answer = 0;

        Queue<String> cache = new LinkedList<String>();

        for (int i=0;i<cities.length;i++) {
            cities[i] = cities[i].toLowerCase();
            if (cache.contains(cities[i])) {
                answer++;

                cache.remove(cities[i]);
                cache.add(cities[i]);
            } else {
                answer += 5;

                if (cache.size() == cacheSize) {
                    cache.poll();
                    cache.add(cities[i]);
                } else {
                    cache.add(cities[i]);
                }
            }
        }

        return answer;
    }
}