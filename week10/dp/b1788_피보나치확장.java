package week10.dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class b1788_피보나치확장 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int absN = Math.abs(n);
        int[] dp = new int[absN+1];
        dp[0] = 0;
        if(n != 0)
            dp[1] = 1;
        for(int i=2;i <= absN;i++){
            dp[i] = (dp[i-2] + dp[i-1]) % 1000000000;
        }
        int result = dp[absN];
        if(n < 0 && (absN % 2 == 0)){
            result = -result;
        }
        if(result > 0) bw.write("1\n");
        else if(result == 0) bw.write("0\n");
        else bw.write("-1\n");
        bw.write(String.valueOf(Math.abs(result)));
        bw.flush();
    }
}
