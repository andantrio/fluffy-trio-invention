package JiYeong;

public class Main134240JY {
    public static void main(String[] args) {
        int[] food = {1, 3, 4, 6};
        System.out.println(solution(food));
    }

    public static String solution(int[] food) {
        StringBuilder sb = new StringBuilder();

        for (int i=1; i<food.length; i++) {
            int temp = food[i]/2;
            for (int j=0; j<temp; j++) {
                sb.append(i);
            }
        }

        String answer = sb.toString();
        String reverse = sb.reverse().toString();

        return answer + 0 + reverse;
    }
}
