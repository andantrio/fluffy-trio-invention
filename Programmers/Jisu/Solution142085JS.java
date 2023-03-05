package Jisu;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution142085JS {
    public int solution(int n, int k, int[] enemy) {
        if (k>=enemy.length) return enemy.length;

        int answer = enemy.length;
        Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i=0; i<enemy.length; i++){
            n-=enemy[i];
            queue.add(enemy[i]);
            if(n<0){
                if(k>0){
                    k-=1;
                    n+=queue.poll();
                } else{
                    answer=i;
                    break;
                }
            }
        }
        return answer;
    }
}

