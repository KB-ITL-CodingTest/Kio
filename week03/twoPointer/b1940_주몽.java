package week03.twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b1940_주몽 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int s = 0, e = n-1;
        int cnt = 0;
        while(s<e){
            int sum = arr[s] + arr[e];
            if(sum == m){
                cnt++;
                s++;
            }
            else if(sum > m){
                e--;
            }
            else{
                s++;
            }
        }
        System.out.print(cnt);
    }
}
