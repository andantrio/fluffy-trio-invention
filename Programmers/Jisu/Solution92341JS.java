package Jisu;

import java.time.Duration;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Solution92341JS {
    public static int[] solution(int[] fees, String[] records) {
        Map<String, String> carHistory = new HashMap<>();
        Map<String, Integer> returnMap = new TreeMap<>();
        double defaultTime = fees[0];
        int defaultFee = fees[1];
        int timeUnit = fees[2];
        int priceUnit = fees[3];
        for(String record: records) {
            String[] recordArr = record.split(" ");
            String time = recordArr[0], carNum = recordArr[1], type = recordArr[2];
            if(type.equals("IN"))carHistory.put(carNum, time);
            else {
                String useTime = carHistory.get(carNum);
                LocalTime startTime = LocalTime.parse(useTime);
                LocalTime endTime = LocalTime.parse(time);
                int usedMin = Long.valueOf(Duration.between(startTime, endTime).toMinutes()).intValue();
                returnMap.put(carNum, returnMap.getOrDefault(carNum, 0)+usedMin);
                carHistory.remove(carNum);
            }
        }
        if (!carHistory.isEmpty()) {
            for (String key : carHistory.keySet()){
                String useTime = carHistory.get(key);
                LocalTime startTime = LocalTime.parse(useTime);
                LocalTime endTime = LocalTime.parse("23:59");
                int usedMin = Long.valueOf(Duration.between(startTime, endTime).toMinutes()).intValue();
                returnMap.put(key, returnMap.getOrDefault(key, 0)+usedMin);
            }
        }
        int[] answer = new int[returnMap.size()];
        int idx=0;
        for (String key : returnMap.keySet()) {
            int usedMin = returnMap.get(key);
            if(usedMin<=defaultTime) answer[idx] = defaultFee;
            else{
                answer[idx] = (int) (defaultFee + Math.ceil((usedMin-defaultTime)/timeUnit) * priceUnit);
            }
            idx++;
        }
        return answer;
    }
}
