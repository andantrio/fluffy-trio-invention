package Jisu;


public class Solution134240JS {
    public String solution(int[] food) {
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<food.length; i++){
            int quotient = food[i]/2;
            for(int j=0; j<quotient; j++) sb.append(i);
        }
        StringBuilder answer = new StringBuilder(sb.toString());
        answer.append("0");
        answer.append(sb.reverse());
        return answer.toString();
    }
}

