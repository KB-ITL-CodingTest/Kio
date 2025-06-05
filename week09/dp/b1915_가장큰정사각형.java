package week09.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b1915_가장큰정사각형 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] dp = new int[n+1][m+1];
        for(int i=1;i<=n;i++){
            String row = br.readLine();
            for(int j=1;j<=m;j++){
                if(row.charAt(j-1) == '1'){
                    dp[i][j] = 1;
                }
            }
        }
        int ans = 0;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(dp[i][j] == 1){
                    dp[i][j] = Math.min(dp[i][j-1], Math.min(dp[i-1][j],dp[i-1][j-1])) + 1;
                    ans = Math.max(ans, dp[i][j]);
                }
            }
        }
        System.out.print(ans*ans);
    }
}
