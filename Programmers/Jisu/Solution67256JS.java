package Jisu;


public class Solution67256JS {
    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        int left = 10;
        int right = 12;

        for(int number:numbers){
            if(number == 0) number = 11;
            if(number == 1 || number == 4 || number == 7) {
                answer.append("L");
                left = number;
            }
            else if(number == 3 || number == 6 || number == 9) {
                answer.append("R");
                right = number;
            }
            else{
                int leftDistance = Math.abs(left-number);
                int rightDistance = Math.abs(right-number);
                if(leftDistance%3 == 0) leftDistance = leftDistance/3;
                else leftDistance = (leftDistance+1)/3 +1;
                if(rightDistance%3 == 0) rightDistance = rightDistance/3;
                else rightDistance = (rightDistance+1)/3 +1;

                if(leftDistance < rightDistance) {
                    answer.append("L");
                    left = number;
                }else if(leftDistance > rightDistance) {
                    answer.append("R");
                    right = number;
                } else {
                    if(hand.equals("right")) {
                        answer.append("R");
                        right = number;
                    } else{
                        answer.append("L");
                        left = number;
                    }
                }
            }

        }
        return answer.toString();
    }
}

