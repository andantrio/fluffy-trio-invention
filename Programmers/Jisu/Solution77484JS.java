package Jisu;


public class Solution77484JS {
    public int[] solution(int[] lottos, int[] win_nums) {
        int max, min, zeroCount = 0, matchCount = 0;
        for(int i=0; i<lottos.length; i++){
            if (lottos[i] == 0) zeroCount+=1;
            else {
                for (int j=0; j<win_nums.length; j++){
                    if(lottos[i]==win_nums[j]) {
                        matchCount+=1;
                        break;
                    }
                }
            }
        }
        if (zeroCount==lottos.length){
            max = 1;
            min = 6;
        } else{
            if (matchCount > 0) {
                min = 6-matchCount+1;
                max = 6-matchCount+1-zeroCount;
            }
            else {
                min = 6;
                max = 6;
            }
        }
        return new int[]{max, min};
    }
}

