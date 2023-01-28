package Jisu;

public class Solution133499JS {
    public int solution(String[] babbling) {
        int answer = 0;
//        String dupRegex = "(aya|ye|woo|ma)\\1+";
//        String regex = "^(aya|ye|woo|ma)+$";

        for(String babble:babbling){
            if(babble.matches("^(aya(?!aya)|ye(?!ye)|woo(?!woo)|ma(?!ma))+$")){
                answer++;
            }
//            boolean isDup = babble.matches(dupRegex);
//            if(isDup) continue;
//            boolean isMatch = babble.matches(regex);
//            if (isMatch) answer+=1;
        }
        return answer;
    }

}
