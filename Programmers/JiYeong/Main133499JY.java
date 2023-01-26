package JiYeong;

import java.util.Arrays;
import java.util.List;

public class Main133499JY {
    public static void main(String[] args) {
        String[] babbling = {"aya", "yee", "u"};
        System.out.println(solution(babbling));
    }

    //"aya", "ye", "woo", "ma" 네 가지 발음
    //네가지 발음밖에 못함
    //발음할 수 있는 단어 개수 return
    public static int solution(String[] babbling) {
        List<String> possibleList = Arrays.asList("aya", "ye", "woo", "ma");
        boolean[] checker = new boolean[babbling.length];
        int answer = 0;
        int index = 0;

        for (String s : babbling) {
            for (int i=0; i<possibleList.size(); i++) {
                s = s.replace(possibleList.get(i), Integer.toString(i));
            }

            char[] temp = s.toCharArray();
            if (s.length() == 1) {
                if (Character.isAlphabetic(s.toCharArray()[0])) {
                    checker[index] = true;
                }
            } else {
                for (int i=0; i<temp.length-1; i++) {
                    if (temp[i] == temp[i+1]) {
                        checker[index] = true;
                        break;
                    }

                    if (Character.isAlphabetic(Character.valueOf(temp[i]))) {
                        checker[index] = true;
                        break;
                    }

                    if (Character.isAlphabetic(Character.valueOf(temp[i+1]))) {
                        checker[index] = true;
                        break;
                    }
                }
            }
            index++;
        }

        for (boolean b : checker) {
            if (!b) {
                answer++;
            }
        }

        return answer;
    }
}
