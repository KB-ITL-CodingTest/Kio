package week10.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b11054_가장긴바이토닉부분수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n =  Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] dp_inc = new int[n];
        int[] dp_dec = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=0;i<n;i++){
            dp_inc[i] = 1;
            dp_dec[n-1-i] = 1;
            for(int j=0;j<i;j++){
                if(arr[i]>arr[j]){
                    dp_inc[i]=Math.max(dp_inc[i],dp_inc[j]+1);
                }
                if(arr[n-1-j] < arr[n-1-i]){
                    dp_dec[n-1-i]= Math.max(dp_dec[n-i-1],dp_dec[n-j-1]+1);
                }
            }
        }
        int ans = 1;
        for(int j=0;j<n;j++){
            ans = Math.max(ans,dp_dec[j]+dp_inc[j]-1);
        }
        System.out.println(ans);
    }
}
