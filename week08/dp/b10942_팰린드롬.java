package week08.dp;

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
        // i~j가 팰린드롬인지 여부 저장
        boolean[][] dp = new boolean[n+1][n+1];
        //길이가 1인 팰린드롬
        for(int i=1;i<=n;i++){
            dp[i][i] = true;
        }
        //길이가 2인 팰린드롬
        for(int i=1;i<=n-1;i++){
            if(arr[i] == arr[i+1]) {
                dp[i][i + 1] = true;
            }
        }
        //길이가 3 이상인 팰린드롬
        for(int len=3;len<=n;len++){
            for(int start=1;start<=n-len+1;start++){
                int end = start + len - 1;
                // i+1~j-1까지가 팰린드롬이고 i와 j의 값이 같다면 팰린드롬
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
