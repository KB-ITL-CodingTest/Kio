package week3_twoPointer_slidingWindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b2018_수들의합5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        for(int i=1;i<=n;i++){
            arr[i] = arr[i-1] + i;
        }
        int cnt = 0;
        int start = 0, end = 1;
        while(end <= n){
            int sum = arr[end] - arr[start];
            if(sum == n){
                cnt++;
                end++;
            }
            else if(sum < n){
                end++;
            }
            else{
                start++;
            }
        }
        System.out.print(cnt);
    }
}
