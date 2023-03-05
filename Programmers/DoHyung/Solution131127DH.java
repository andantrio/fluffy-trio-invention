package DoHyung;

import java.util.*;

public class Solution131127DH {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        Map<String, Integer> wantMap = new HashMap<>();
        for (int i=0;i<want.length;i++) {
            wantMap.put(want[i], number[i]);
        }

        Map<String, Integer> discountMap = new HashMap<>();
        for (int i=0;i<10;i++) {
            discountMap.put(discount[i],discountMap.getOrDefault(discount[i],0)+1);
        }

        if (isSame(wantMap, discountMap)) {
            answer++;
        }

        for (int i=10;i<discount.length;i++) {
            discountMap.put(discount[i-10],discountMap.get(discount[i-10])-1);
            if (discountMap.get(discount[i-10]) == 0) {
                discountMap.remove(discount[i-10]);
            }
            discountMap.put(discount[i],discountMap.getOrDefault(discount[i],0)+1);

            if (isSame(wantMap, discountMap)) {
                answer++;
            }
        }

        return answer;
    }

    public boolean isSame(Map<String,Integer> wantMap, Map<String,Integer> discountMap) {
        if (wantMap.keySet().size() != discountMap.keySet().size()) {
            return false;
        }

        for (String key:wantMap.keySet()) {
            if (discountMap.getOrDefault(key, -1) != wantMap.get(key)) {
                return false;
            }
        }

        return true;
    }
}
