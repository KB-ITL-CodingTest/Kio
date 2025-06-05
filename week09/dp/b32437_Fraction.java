package week09.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 피보나치 형태로 진행됨.
public class b32437_Fraction {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2;i<=n;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        System.out.print(dp[n]);
    }
}
