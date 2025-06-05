package week03.twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b2470_두용액 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int a = arr[0], b= arr[n-1], diff = Integer.MAX_VALUE;
        int start = 0, end = n-1;
        while (start < end){
            int sum = arr[start] + arr[end];
            if(Math.abs(sum) < Math.abs(diff)) {
                a = arr[start];
                b = arr[end];
                diff = sum;
            }
            if(sum == 0){
                break;
            }
            else if(sum < 0){
                start++;
            }
            else{
                end--;
            }

        }
        System.out.print(a + " " + b);
    }
}
