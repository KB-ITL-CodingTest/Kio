package week12.binarySearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b2512_예산 {
    static int budget, n;
    static int[] arr;
    static int binarySearch(int left, int right){
        if(left > right){
            return right;
        }
        int mid = (left + right) / 2;
        int sum = 0;
        for(int i=0;i<n;i++){
            sum += Math.min(arr[i], mid);
        }
        if(sum < budget){
            return binarySearch(mid+1, right);
        }
        else if(sum > budget){
            return binarySearch(left, mid-1);
        }
        else{
            return mid;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sum = 0;
        int max = 0;
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
            max = Math.max(max, arr[i]);
        }
        budget = Integer.parseInt(br.readLine());
        if(sum <= budget){
            System.out.print(max);
        }
        else{
            int ans = binarySearch(0, max);
            System.out.print(ans);
        }
    }
}
