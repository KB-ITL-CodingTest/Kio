package week3_twoPointer_slidingWindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b1806_부분합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =  new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int minLen = Integer.MAX_VALUE;
        int start = 0;
        int sum = 0;
        for(int end = 0;end < n;end++){
            sum += arr[end];
            if(sum < s)
                continue;
            while(sum-arr[start] >= s){
                sum -= arr[start];
                start++;
            }
            minLen = Math.min(minLen,end-start+1);

        }
        System.out.print(minLen < Integer.MAX_VALUE ? minLen : 0);
    }
}
