import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution0602DH {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int T = Integer.parseInt(bufferedReader.readLine().trim());

        for (int TItr = 0; TItr < T; TItr++) {
            int n = Integer.parseInt(bufferedReader.readLine().trim());

            String[] arrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> arr = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                int arrItem = Integer.parseInt(arrTemp[i]);
                arr.add(arrItem);
            }

            String result = Result.balancedSums(arr);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedReader.close();
        bufferedWriter.close();
    }

    class Result {

        /*
         * Complete the 'balancedSums' function below.
         *
         * The function is expected to return a STRING.
         * The function accepts INTEGER_ARRAY arr as parameter.
         */

        public static String balancedSums(List<Integer> arr) {
            if (arr.size() == 1) {
                return "YES";
            }

            int leftSum = 0;
            int rightSum = 0;
            for (int i=0;i<arr.size();i++) {
                rightSum += arr.get(i);
            }

            for (int i=0;i<arr.size();i++) {
                rightSum -= arr.get(i);
                if (leftSum == rightSum) {
                    return "YES";
                }
                leftSum += arr.get(i);
            }

            return "NO";
        }

    }

}
