package week10.dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class b2758_로또 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for(int tc=0;tc<T;tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            long[][] dp = new long[N+1][M+1];
            // 초기화. i개의 수로 1개짜리 수열을 만드는 경우의 수 = i개
            for(int i=1;i<=M;i++){
                dp[1][i] = i;
            }
            // j개의 수로 i개를 선택해 수열을 만드는 경우의 수.
            // j 전까지의 수로 만든 경우의 수 (누적합) + j를 선택한 경우의 수 (j//2 의 수로 i-1 길이 수열을 만드는 경우의 수)
            for(int i=2;i<=N;i++){
                for(int j=1;j<=M;j++){
                    dp[i][j] = dp[i][j-1] + dp[i-1][j/2];
                }
            }
            bw.write(dp[N][M] + "\n");
        }
        bw.flush();
    }
}
