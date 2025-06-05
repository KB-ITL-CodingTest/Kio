package week10.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b11054_바이토닉_lis {
    static int binarySearch(int[] lis, int right, int target){
        int left = 0;
        int mid;
        while(left<right){
            mid = (left+right)/2;
            if(lis[mid] < target){
                left = mid+1;
            }
            else{
                right = mid;
            }
        }
        return right;
    }

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
        int[] lis = new int[n];
        int[] lds = new int[n];
        lis[0] = arr[0];
        lds[0] = arr[n-1];
        int ans = 1;
        int inc_idx = 0, dec_idx = 0;
        for(int i=0;i<n;i++){
            if(lis[inc_idx] < arr[i]){
                lis[++inc_idx] = arr[i];
            }
            else{
                int pos = binarySearch(lis, inc_idx, arr[i]);
                lis[pos] = arr[i];
            }
            dp_inc[i] = inc_idx;

            if(lds[dec_idx] < arr[n-1-i]){
                lds[++dec_idx] = arr[n-1-i];
            }
            else{
                int pos = binarySearch(lds, dec_idx, arr[n-1-i]);
                lds[pos] = arr[n-1-i];
            }
            dp_dec[n-1-i] = dec_idx;
        }
        for(int j=0;j<n;j++){
            ans = Math.max(ans,dp_dec[j]+dp_inc[j]+1);
        }
        System.out.println(ans);
    }
}
