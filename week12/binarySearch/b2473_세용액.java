package week12.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b2473_세용액 {
    static long[] arr;
    static int binarySearch(long sum, int left, int right){
        int bestIdx = left;
        long min = Long.MAX_VALUE;
        while(left <= right){
            int mid = (left+right)/2;
            long total = sum + arr[mid];

            if(Math.abs(total) < min){
                min = Math.abs(total);
                bestIdx = mid;
            }
            if(total < 0){
                left = mid+1;
            }
            else if(total > 0){
                right = mid-1;
            }
            else{
                return mid;
            }
        }
        return bestIdx;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);
        long min = Long.MAX_VALUE;
        long[] ans = new long[3];
        //binary search 풀이 O(N^2logN)
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n-1;j++){
                int k = binarySearch(arr[i] + arr[j], j+1, n-1);
                long sum = Math.abs(arr[i] + arr[j] + arr[k]);
                if(sum < min){
                    min = sum;
                    ans[0] = arr[i];
                    ans[1] = arr[j];
                    ans[2] = arr[k];
                }
            }
        }
        //two pointer 풀이 O(NlogN)
//        long minSum = Long.MAX_VALUE;
//        for(int i=0;i<n-2;i++){
//            int left = i+1, right = n-1;
//            while(left < right){
//                long total = arr[i] + arr[left] + arr[right];
//                if(Math.abs(total) < minSum){
//                    minSum = Math.abs(total);
//                    ans[0] = arr[i];
//                    ans[1] = arr[left];
//                    ans[2] = arr[right];
//                }
//                if(total < 0){
//                    left++;
//                }
//                else if(total > 0){
//                    right--;
//                }
//                else{
//                    break;
//                }
//            }
//            if(minSum == 0) break;
//        }
        System.out.println(ans[0] + " " + ans[1] + " " + ans[2]);
    }
}
