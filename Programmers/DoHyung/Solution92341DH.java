package DoHyung;

import java.util.*;

public class Solution92341DH {
    public int[] solution(int[] fees, String[] records) {
        Map<String, List<String>> recordMap = new HashMap<String, List<String>>();

        for (String record:records) {
            String[] recordArr = record.split(" ");

            List<String> recordOfCar = recordMap.getOrDefault(recordArr[1], new ArrayList<String>());
            recordOfCar.add(recordArr[0]);

            recordMap.put(recordArr[1], recordOfCar);
        }

        String[] carNumbers = recordMap.keySet().toArray(new String[recordMap.keySet().size()]);
        Arrays.sort(carNumbers);

        int[] answer = new int[carNumbers.length];

        for (int i=0;i<carNumbers.length;i++) {
            List<String> recordsOfCar = recordMap.get(carNumbers[i]);

            int totalTime = 0;
            for (int j=0;j<recordsOfCar.size()-1;j+=2) {
                totalTime += getTime(recordsOfCar.get(j), recordsOfCar.get(j+1));
            }

            if (recordsOfCar.size()%2 == 1) {
                totalTime += getTime(recordsOfCar.get(recordsOfCar.size()-1), "23:59");
            }

            answer[i] = calculateFee(totalTime, fees);
        }

        return answer;
    }

    public int getTime(String enter, String exit) {
        int enterMinutes = Integer.parseInt(enter.split(":")[0])*60 + Integer.parseInt(enter.split(":")[1]);
        int exitMinutes = Integer.parseInt(exit.split(":")[0])*60 + Integer.parseInt(exit.split(":")[1]);

        return exitMinutes - enterMinutes;
    }

    public int calculateFee(int totalTime, int[] fees) {
        // 기본요금
        int fee = fees[1];
        if (totalTime <= fees[0]) {
            return fee;
        }

        //초과 시간 요금
        fee += ((totalTime-fees[0]) / fees[2]) * fees[3];
        if ((totalTime-fees[0]) % fees[2] != 0) {
            fee += fees[3]; // 올림
        }

        return fee;
    }
}
