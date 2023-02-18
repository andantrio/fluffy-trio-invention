package JiYeong;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main77484JY {
    public static void main(String[] args) {
        int[] lottos = {1, 1, 1, 1, 1, 1};
        int[] win_nums = {38, 19, 20, 40, 15, 25};
        System.out.println(solution(lottos, win_nums));
    }

    public static int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        List<Integer> list = Arrays.stream(win_nums).boxed().collect(Collectors.toList());
        int sameCnt = 0;
        int zeroCnt = 0;

        for(int i : lottos) {
            if (i == 0) {
                zeroCnt++;
                continue;
            }

            if (list.contains(i)) {
                sameCnt++;
            }
        }

        answer[0] = 7 - sameCnt - zeroCnt;
        if (sameCnt == 0) {
            if (zeroCnt == 0) {
                answer[0] = 6;
            }
            answer[1] = 6;
        } else {
            answer[1] = 7 - sameCnt;
        }

        return answer;
    }
}
