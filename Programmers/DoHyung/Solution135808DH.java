package DoHyung;

import java.util.Arrays;

public class Solution135808DH {
    public int solution(int k, int m, int[] score) {
        int answer = 0;

        Arrays.sort(score);

        for (int i=score.length-m;i>=0;i-=m) {
            answer += score[i]*m;
        }

        return answer;
    }
}
