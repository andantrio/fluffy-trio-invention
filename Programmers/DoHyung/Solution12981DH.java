package DoHyung;

import java.util.*;

public class Solution12981DH {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[]{0,0};

        String previous = words[0].charAt(0)+"";
        PriorityQueue<String> pq = new PriorityQueue<>();
        for (int i=0;i<words.length;i++) {
            if ((words[i].charAt(0) != previous.charAt(previous.length()-1))
                    || pq.contains(words[i])) {
                int num = ((i+1)%n==0)?n:(i+1)%n;
                int nth = (i+1)/n + (((i+1)%n==num)?1:0);

                answer = new int[]{num,nth};
                break;
            } else {
                pq.add(words[i]);
                previous = words[i];
            }
        }

        return answer;
    }
}
