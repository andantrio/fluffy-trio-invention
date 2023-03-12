package DoHyung;

import java.util.HashMap;
import java.util.Map;

public class Solution67256DH {
    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();

        Map<Integer, int[]> middleMap = new HashMap<>();
        middleMap.put(2, new int[]{1,0});
        middleMap.put(5, new int[]{1,1});
        middleMap.put(8, new int[]{1,2});
        middleMap.put(0, new int[]{1,3});

        int[] left = new int[]{0,3};
        int[] right = new int[]{2,3};

        for (int num:numbers) {
            if (num == 1) {
                answer.append("L");
                left[0] = 0;
                left[1] = 0;
            } else if (num == 4) {
                answer.append("L");
                left[0] = 0;
                left[1] = 1;
            } else if (num == 7) {
                answer.append("L");
                left[0] = 0;
                left[1] = 2;
            } else if (num == 3) {
                answer.append("R");
                right[0] = 2;
                right[1] = 0;
            } else if (num == 6) {
                answer.append("R");
                right[0] = 2;
                right[1] = 1;
            } else if (num == 9) {
                answer.append("R");
                right[0] = 2;
                right[1] = 2;
            } else {
                int[] target = middleMap.get(num);

                int leftDistance = Math.abs(target[0]-left[0])+Math.abs(target[1]-left[1]);
                int rightDistance = Math.abs(target[0]-right[0])+Math.abs(target[1]-right[1]);

                if (leftDistance > rightDistance
                        || (leftDistance == rightDistance && hand.equals("right"))) {
                    answer.append("R");
                    right[0] = target[0];
                    right[1] = target[1];
                } else if (leftDistance < rightDistance
                        || (leftDistance == rightDistance && hand.equals("left"))) {
                    answer.append("L");
                    left[0] = target[0];
                    left[1] = target[1];
                }
            }
        }

        return answer.toString();
    }
}
