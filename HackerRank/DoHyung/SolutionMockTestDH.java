import java.util.Collections;
import java.util.List;

public class SolutionMockTestDH {
    class Result {
        /*
         * Complete the 'findMedian' function below.
         *
         * The function is expected to return an INTEGER.
         * The function accepts INTEGER_ARRAY arr as parameter.
         */
        public static int findMedian(List<Integer> arr) {
            Collections.sort(arr);

            return arr.get(arr.size()/2);
        }
    }
}
