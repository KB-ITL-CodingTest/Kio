package week12.binarySearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b1300_K번째수 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        int left = 1;
        int right = (int)Math.min(1_000_000_000,(long)n*n);
        int mid;
        int cnt;
        while(left <= right){
            mid = (left+right)/2;
            cnt = 0;
            for(int i=1;i<=n;i++){
                cnt += Math.min(mid/i,n);
            }
            if(cnt < k){
                left = mid+1;
            }
            else{
                right = mid-1;
            }
        }
        System.out.print(left);
    }
}
