package JiYeong;

import java.util.LinkedList;
import java.util.Queue;

public class Main17680JY {
    public static void main(String[] args) throws Exception {
        int cacheSize = 3;
        String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};

        System.out.println(solution(cacheSize, cities));
    }

    public static int solution(int cacheSize, String[] cities) {
        int answer = 0;
        Queue<String> q = new LinkedList<>();

        if (cacheSize == 0) {
            return 5 * cities.length;
        }

        int size = 1;
        for (int i=0; i<cities.length; i++) {
            String city = cities[i].toLowerCase();

            if (size <= cacheSize) {
                if (!q.contains(city)) {
                    q.add(city);
                    size++;
                    answer += 5;

                } else {
                    q.remove(city);
                    q.add(city);
                    answer++;
                }

            } else {
                if (!q.contains(city)) {
                    q.poll();
                    q.add(city);
                    answer += 5;

                } else {
                    q.remove(city);
                    q.add(city);
                    answer++;
                }
            }
        }

        return answer;
    }
}
