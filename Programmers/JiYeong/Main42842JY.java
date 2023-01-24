package JiYeong;

public class Main42842JY {
    public static void main(String[] args) throws Exception {
        int brown = 10;
        int yellow = 2;

        int[] answer = solution(brown, yellow);
        System.out.println(answer[0]+", "+answer[1]);
    }

    public static int[] solution(int brown, int yellow) {
        int[] answer = {};
        int width = 0;
        int height = 0;
        int area = brown + yellow;
        boolean flag = false;

        while (flag != true) {
            width++;
            for (height=1; height<=width; height++) {
                if (width * height == area && yellow == (width - 2) * (height - 2)) {
                    flag = true;
                    break;
                }
            }
        }

        answer = new int[]{width, height};
        return answer;
    }
}
