import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution0605DH {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        List<List<Integer>> s = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            String[] sRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> sRowItems = new ArrayList<>();

            for (int j = 0; j < 3; j++) {
                int sItem = Integer.parseInt(sRowTempItems[j]);
                sRowItems.add(sItem);
            }

            s.add(sRowItems);
        }

        int result = Result.formingMagicSquare(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }

    class Result {

        /*
         * Complete the 'formingMagicSquare' function below.
         *
         * The function is expected to return an INTEGER.
         * The function accepts 2D_INTEGER_ARRAY s as parameter.
         */

        public static int formingMagicSquare(List<List<Integer>> s) {
            List<int[][]> magicSquare = new ArrayList<int[][]>();
            magicSquare.add(new int[][]{{2,7,6},{9,5,1},{4,3,8}});
            magicSquare.add(new int[][]{{2,9,4},{7,5,3},{6,1,8}});
            magicSquare.add(new int[][]{{4,3,8},{9,5,1},{2,7,6}});
            magicSquare.add(new int[][]{{4,9,2},{3,5,7},{8,1,6}});
            magicSquare.add(new int[][]{{6,1,8},{7,5,3},{2,9,4}});
            magicSquare.add(new int[][]{{6,7,2},{1,5,9},{8,3,4}});
            magicSquare.add(new int[][]{{8,1,6},{3,5,7},{4,9,2}});
            magicSquare.add(new int[][]{{8,3,4},{1,5,9},{6,7,2}});

            int minCost = Integer.MAX_VALUE;
            for (int[][] square:magicSquare) {
                int cost = 0;
                for (int i=0;i<3;i++) {
                    for (int j=0;j<3;j++) {
                        cost+=Math.abs(square[i][j]-s.get(i).get(j));
                    }
                }
                if (minCost > cost) {
                    minCost = cost;
                }
            }

            return minCost;
        }

    }

}
