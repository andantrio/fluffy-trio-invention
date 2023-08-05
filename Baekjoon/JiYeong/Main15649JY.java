package JiYeong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main15649JY {
    static int N;
    static int M;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //1~N 까지의 자연수
        M = Integer.parseInt(st.nextToken()); //중복없이 M개를 고른 수열
        visited = new boolean[N+1];
        DFS(new Sequence(new int[M], 0));
    }

    static void DFS(Sequence old) {
        if (old.m == M) {
            StringBuilder sb = new StringBuilder();
            for (int i : old.arr) {
                sb.append(i + " ");
            }
            System.out.println(sb.toString());
        } else {
            int tempM = 0;
            for (int i=1; i< visited.length; i++) {
                if (old.m < M && !visited[i]) {
                    visited[i] = true;
                    Sequence sequence = new Sequence(old.arr.clone(), old.m);
                    sequence.addArr(old.m, i);
                    DFS(sequence);
                    visited[i] = false;
                }
            }
        }
    }

    public static class Sequence {
        private int[] arr;
        private int m;

        public void addArr(int m, int num) {
            this.arr[m] = num;
            this.m += 1;
        }
        public Sequence(int[] arr, int m) {
            this.arr = arr;
            this.m = m;
        }
    }
}
