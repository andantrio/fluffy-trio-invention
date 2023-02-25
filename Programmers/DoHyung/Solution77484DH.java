package DoHyung;

public class Solution77484DH {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];

        int rightCount = 0;
        int zeroCount = 0;
        for (int i=0;i<lottos.length;i++) {
            if (lottos[i] == 0) {
                zeroCount++;
            } else {
                for (int num:win_nums) {
                    if (num == lottos[i]) {
                        rightCount++;
                    }
                }
            }
        }

        answer[1] = (7-rightCount>6)?6:7-rightCount;
        answer[0] = (7-(rightCount+zeroCount)>6)?6:7-(rightCount+zeroCount);

        return answer;
    }
}
