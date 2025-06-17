package week12.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b12015_가장긴증가하는부분수열2 {
    static int[] lis;
    static int binarySearch(int left, int right, int target){

        while(left<right){
            int mid = (left+right)/2;
            if(target >lis[mid]){
                left=mid+1;
            }
            else {
                right=mid;
            }
        }
        return left;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int len = 1;
        lis = new int[n];
        lis[0] = arr[0];
        for (int i = 1; i < n; i++) {
            if(arr[i]>lis[len-1]){
                lis[len++]=arr[i];
            }
            else{
                int pos = binarySearch(0, len, arr[i]);
                lis[pos] = arr[i];
            }
        }
        System.out.println(len);
    }
}
