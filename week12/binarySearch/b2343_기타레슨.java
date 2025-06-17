package week12.binarySearch;

import java.io.BufferedReader;
import java.util.StringTokenizer;

public class b2343_기타레슨 {
    static int[] videos;
    static int n,m;
    static int binarySearch(int start, int end){
        if(start > end) return start;
        int mid = (start + end) / 2;
        int sum = 0;
        int cnt = 0;
        for(int i=n-1;i>=0;i--){
            if(sum + videos[i] > mid){
                cnt++;
                sum = videos[i];
            }
            else{
                sum += videos[i];
            }
        }
        if(sum > 0) cnt++;
        if(cnt > m) return binarySearch(mid+1, end);
        else return binarySearch(start, mid-1);
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        videos = new int[n];
        st = new StringTokenizer(br.readLine());
        int total = 0;
        int start = 0;
        for(int i=0;i<n;i++){
            videos[i] = Integer.parseInt(st.nextToken());
            total += videos[i];
            start = Math.max(start, videos[i]);
        }
        System.out.print(binarySearch(start,total));


    }
}
