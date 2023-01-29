package DoHyung;

public class Solution131705DH {
    public int solution(int[] number) {
        int answer = 0;

        for (int i=0;i<number.length;i++) {
            for (int j=0;j<number.length;j++) {
                if (i==j) {
                    continue;
                }
                for (int k=0;k<number.length;k++) {
                    if (i==k || j==k) {
                        continue;
                    }

                    if (number[i]+number[j]+number[k] == 0) {
                        answer++;
                    }
                }
            }
        }

        return answer/6;
    }
}