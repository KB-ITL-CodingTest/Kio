package week3_twoPointer_slidingWindow;

import java.io.*;
import java.util.StringTokenizer;

public class b11728_배열합치기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr1 = new int[n];
        int p1 = 0;
        int[] arr2 = new int[m];
        int p2 = 0;
        int[] res = new int[n+m];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr1[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<m;i++){
            arr2[i] = Integer.parseInt(st.nextToken());
        }
        int cur = 0;
        while(p1 < n && p2 < m){
            if(arr1[p1] > arr2[p2]){
                res[cur++] = arr2[p2++];
            }
            else{
                res[cur++] = arr1[p1++];
            }
        }
        while(p1 < n){
            res[cur++] = arr1[p1++];
        }
        while(p2 < m){
            res[cur++] = arr2[p2++];
        }
        for(int i=0;i<cur;i++){
            bw.write(String.valueOf(res[i]) + " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
