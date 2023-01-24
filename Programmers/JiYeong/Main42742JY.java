package JiYeong;

import java.util.Arrays;
import java.util.Collections;

public class Main42742JY {
    public static void main(String[] args) throws Exception {
        int[] arr = {3,0,6,1,5};
        System.out.println(solution(arr));
    }

    public static int solution(int[] citations) {
        int answer=0;
        int length = citations.length;

        Integer[] temp = new Integer[length];

        for (int i=0; i<length; i++) {
            temp[i]=citations[i];
        }

        Arrays.sort(temp, Collections.reverseOrder());

        while(answer < length){
            if(temp[answer] <= answer) break;
            answer++;
        }
        return answer;
    }
}
