package JiYeong;

public class Main131705JY {
    public static void main(String[] args) {
        int[] number = {-2, 3, 0, 2, -5};
        System.out.println(solution(number));
    }

    public static int solution(int[] number) {
        int answer = 0;

        for (int i=0; i<number.length; i++) {
            for (int j=0; j<number.length; j++) {
                if (i==j) {
                    continue;
                }

                for (int k=0; k<number.length; k++) {
                    if (i==k || j==k) {
                        continue;
                    }

                    if (number[i] + number[j] + number[k] == 0) {
                        answer++;
                    }
                }
            }
        }

        return answer/6;
    }
}
