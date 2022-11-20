package DoHyung;

import java.util.*;

public class Solution42747DH {
    public int solution(int[] citations) {
        int answer = 0;

        Arrays.sort(citations);

        for (int i=citations[citations.length-1];i>=0;i--) {
            for (int j=citations.length-1;j>=0;j--) {
                if (j != 0 && citations[j] == citations[j-1]) {
                    continue;
                }

                if (i <= citations[j] && i <= citations.length-j) {
                    return i;
                }
            }
        }

        return answer;
    }
}
