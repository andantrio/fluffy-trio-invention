package Jisu;

import java.util.Arrays;

public class Solution42747JS {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int answer = 0;
        for (int i=0; i<=citations[citations.length-1]; i++){
            int count = 0, idx=0;
            while(idx<citations.length) {
                if (citations[idx] >= i) count += 1;
                idx +=1;
            }
            if (count >= i) answer = Math.max(i, answer);
        }
        return answer;
    }
}
