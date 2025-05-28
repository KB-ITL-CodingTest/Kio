package week9.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class b31263_공군 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String line = br.readLine();
        int[] dp = new int[n+1];
        Arrays.fill(dp, n);
        dp[0] = 0;
        for(int i=1;i<=n;i++){
            for(int len = 1;len<=3;len++){
                if(i - len < 0) continue;
                String sub = line.substring(i-len, i);
                if(sub.charAt(0) == '0') continue;
                int num = Integer.parseInt(sub);
                if(num > 641) continue;
                dp[i] = Math.min(dp[i], dp[i-len] + 1);
            }
        }
        System.out.println(dp[n]);
    }
}
