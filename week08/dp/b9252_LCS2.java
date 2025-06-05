package week08.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b9252_LCS2 {
    static int[][] dp;
    public static void main(String[] args) throws Exception{
        String s1,s2;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s1 = br.readLine();
        s2 = br.readLine();
        dp = new int[s1.length()+1][s2.length()+1];
        for(int i=1;i<=s1.length();i++){
            for(int j=1;j<=s2.length();j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        System.out.println(dp[s1.length()][s2.length()]);
        int a = s1.length(), b = s2.length();
        StringBuilder sb = new StringBuilder();
        while(a > 0 && b > 0){
            if(s1.charAt(a-1) == s2.charAt(b-1)){
                sb.append(s1.charAt(a-1));
                a--;
                b--;
            }
            else if(dp[a-1][b] > dp[a][b-1]){
                a--;
            }
            else{
                b--;
            }
        }
        System.out.print(sb.reverse());
    }
}
