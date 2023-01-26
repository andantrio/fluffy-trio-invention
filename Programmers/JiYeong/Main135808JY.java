package JiYeong;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main135808JY {
    public static void main(String[] args) {
        int k = 4;
        int m = 3;
        int[] score = {4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2};
        System.out.println(solution(k, m, score));
    }

    //K점이 최상품의 사과, 1점은 최하품
    //한 상자에 사과를 m개씩 담음
    //사과 한상자 가격: 가장 낮은 점수 * m
    //가능한 많은 사과를 팔았을 때 얻을 수 있는 최대 이익
    public static int solution(int k, int m, int[] score) {
        int answer = 0;
        List<Integer> list = new ArrayList<>(Arrays.stream(score).boxed().collect(Collectors.toList()));
        Collections.sort(list, Collections.reverseOrder());

        int sIndex = 0;
        int eIndex = m-1;

        while (eIndex < score.length) {
            int temp = m * list.get(eIndex);
            answer += temp;
            eIndex += m;
        }

        return answer;
    }
}
