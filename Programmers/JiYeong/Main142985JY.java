package JiYeong;

import java.util.Collections;
import java.util.PriorityQueue;

public class Main142985JY {

    public static void main(String[] args) {
        int n = 2;
        int k = 4;
        int[] enemy = {3, 3, 3, 3};
        System.out.println(solution(n, k, enemy));
    }

    // 병사의 수 n
    // 무적권의 횟수 k
    // 적의 배열
    // 가장 많은 턴 수
    public static int solution(int n, int k, int[] enemy) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        if (k >= enemy.length) {
            return enemy.length;
        }

        for (int i=0; i<enemy.length; i++) {
            queue.add(enemy[i]);
            n -= enemy[i];
            if (n<0) {
                if (k==0) {
                    return queue.size()-1;
                } else {
                    k--;
                    n += queue.peek();
                    queue.poll();
                    queue.add(0);
                }
            }
        }
        return queue.size();
    }

}
