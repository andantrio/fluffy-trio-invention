package DoHyung;

public class Solution42842DH {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};

        // 노란색이 홀수면 1줄 혹은 정사각형
        if (yellow%2 != 0) {
            if (yellow == 1 || Math.sqrt(yellow)*Math.sqrt(yellow) != yellow) {
                answer = new int[] {yellow+2,3};
            } else {
                answer = new int[] {(int)Math.sqrt(yellow)+2, (int)Math.sqrt(yellow)+2};
            }

        } else {
            // 노란색이 짝수면 1줄인 경우부터 모두 체크
            int yellowH = 1;

            while (yellowH <= Math.sqrt(yellow)) {
                if (yellow%yellowH == 0
                        && (yellow/yellowH+2)*(yellowH+2) == (brown+yellow)) {
                    answer = new int[] {yellow/yellowH+2, yellowH+2};
                    break;
                }

                yellowH++;
            }
        }

        if (answer[0] < answer[1]) {
            int tmp = answer[0];
            answer[0] = answer[1];
            answer[1] = tmp;
        }

        return answer;
    }
}
