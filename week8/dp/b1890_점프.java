package week8.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b1890_점프 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] board = new int[n][n];
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        long[][] dp = new long[n][n];
        dp[0][0] = 1;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(dp[i][j] == 0 || board[i][j] == 0) continue;
                int stride = board[i][j];
                if(i+stride < n){
                    dp[i+stride][j] += dp[i][j];
                }
                if(j+stride < n){
                    dp[i][j+stride] += dp[i][j];
                }
            }
        }
        System.out.print(dp[n-1][n-1]);
    }
}
