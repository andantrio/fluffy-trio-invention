package Jisu;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main15649JS {
    static int n, m;
    static boolean[] check;
    static int[] answer;
    static StringBuilder sb = new StringBuilder();
    public static void dfs(int depth){
        if (depth==m){
            for(int i:answer){
                sb.append(i+1).append(" ");
            }
            System.out.println(sb.toString());
            sb = new StringBuilder();
            return;
        }
        for(int i=0; i<n; i++){
            if (!check[i]){
                check[i] = true;
                answer[depth] = i;
                dfs(depth+1);
                check[i] = false;
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arg = br.readLine().split(" ");
        n = Integer.parseInt(arg[0]);
        m = Integer.parseInt(arg[1]);
        check = new boolean[n];
        answer = new int[m];
        dfs(0);
    }
}
