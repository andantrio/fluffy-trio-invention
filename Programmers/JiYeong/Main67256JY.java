package JiYeong;

import java.util.Arrays;
import java.util.List;

public class Main67256JY {
    public static void main(String[] args) {
//        int[] numbers = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
//        String hand = "left";
//        System.out.println(solution(numbers, hand));

        int[] numbers2 = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand2 = "right";
        System.out.println(solution(numbers2, hand2));
    }
    public static String solution(int[] numbers, String hand) {

        final String LEFT = "L";
        final String RIGHT = "R";
        int[] lefts = {1, 4, 7};
        int[] rights = {3, 6, 9};
        List<Integer> center = Arrays.asList(0, 8, 5, 2);

        StringBuilder sb = new StringBuilder();

        int leftEnd = -1;
        int rightEnd = -1;

        for (int number : numbers) {
            if (number!=0 && number%3 == 0) {
                sb.append(RIGHT);
                rightEnd = number;
            } else if ((number-1)%3 == 0) {
                sb.append(LEFT);
                leftEnd = number;
            } else {
                int leftTemp = 0;
                int rightTemp = 0;

                //오른손
                if (rightEnd!=0 && rightEnd%3 == 0) {
                    rightTemp = center.indexOf(number) - center.indexOf(rightEnd-1);
                    if (rightTemp >= 0) rightTemp++;
                    else rightTemp--;
                } else {
                    if (rightEnd == -1) {
                        rightTemp = center.indexOf(number);
                        rightTemp++;
                    } else {
                        rightTemp = center.indexOf(number) - center.indexOf(rightEnd);
                    }
                }

                //왼손
                if (leftEnd!=0 && (leftEnd-1)%3 == 0) {
                    leftTemp = center.indexOf(number) - center.indexOf(leftEnd+1);
                    if (leftTemp >= 0) leftTemp++;
                    else leftTemp--;
                } else {
                    if (leftEnd == -1) {
                        leftTemp = center.indexOf(number);
                        leftTemp++;
                    } else {
                        leftTemp = center.indexOf(number) - center.indexOf(leftEnd);
                    }
                }

                //비교
                if (rightTemp < 0) rightTemp = rightTemp * -1;
                if (leftTemp < 0) leftTemp = leftTemp * -1;

                if (leftTemp > rightTemp) {
                    sb.append(RIGHT);
                    rightEnd = number;
                } else if (leftTemp < rightTemp) {
                    sb.append(LEFT);
                    leftEnd = number;
                } else {
                    if ("right".equals(hand)) {
                        sb.append(RIGHT);
                        rightEnd = number;
                    } else {
                        sb.append(LEFT);
                        leftEnd = number;
                    }
                }
            }
        }

        return sb.toString();
    }
}
