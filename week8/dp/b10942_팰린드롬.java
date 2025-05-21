package week8.dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class b10942_팰린드롬 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1;i<=n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        // i에서 시작하는 j 길이가 팰린드롬인지 저장
        boolean[][] dp = new boolean[n+1][n+1];
        for(int i=1;i<=n;i++){
            dp[i][i] = true;
        }
        for(int i=1;i<=n-1;i++){
            if(arr[i] == arr[i+1]) {
                dp[i][i + 1] = true;
            }
        }
        for(int len=3;len<=n;len++){
            for(int start=1;start<=n-len+1;start++){
                int end = start + len - 1;
                if(arr[start] == arr[end] && dp[start+1][end-1]){
                    dp[start][end] = true;
                }
            }
        }
        int m = Integer.parseInt(br.readLine());
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(dp[a][b]){
                bw.write("1\n");
            }
            else{
                bw.write("0\n");
            }
        }
        bw.flush();
    }
}
