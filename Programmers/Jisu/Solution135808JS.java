package Jisu;

import java.util.Arrays;

public class Solution135808JS {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        Arrays.sort(score);

        int minScore =9, count =0;
        for(int i=score.length-1; i>=0; i--){
            int apple = score[i];
            if (count < m) {
                count += 1;
                minScore = Math.min(minScore, apple);
            } else {
                count = 1;
                answer += (minScore * m);
            }
        }
        if(count==m) answer += (minScore * m);
        return answer;
    }
}
