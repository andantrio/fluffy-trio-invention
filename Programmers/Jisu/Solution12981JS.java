package Jisu;

import java.util.ArrayList;
import java.util.List;

public class Solution12981JS {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[]{0,0};

        List<String> wordList = new ArrayList<>();
        wordList.add(words[0]);
        int who = 1, idx = 1;
        for(int i=1; i<words.length; i++){
            who +=1;
            String now = words[i];
            String prev = words[i-1];
            if (prev.charAt(prev.length()-1) != now.charAt(0)){
                return new int[]{who, idx};
            }
            if (wordList.contains(now)){
                return new int[]{who, idx};
            }
            wordList.add(now);
            if(who == n){
                who = 0;
                idx +=1;
            }
        }
        return answer;
    }
}

