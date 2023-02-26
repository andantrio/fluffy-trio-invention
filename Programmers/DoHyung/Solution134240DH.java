package DoHyung;

public class Solution134240DH {
    public String solution(int[] food) {
        StringBuilder answer = new StringBuilder();

        for (int i=1;i<food.length;i++) {
            for (int j=1;j<=food[i]/2;j++) {
                answer.append(i);
            }
        }

        String reverse = answer.reverse().toString();

        answer.reverse().append("0"+reverse);

        return answer.toString();
    }
}
