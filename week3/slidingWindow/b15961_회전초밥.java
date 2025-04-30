package week3.slidingWindow;

import java.io.*;
import java.util.StringTokenizer;

public class b15961_회전초밥 {
    static int[] count;
    static int[] sushi;
    static int n,d,k,c;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        sushi = new int[2*n+1];
        count = new int[d+1];
        for(int i=0;i<n;i++){
            sushi[i] = Integer.parseInt(br.readLine());
        }
        // circular 이므로 2배로 확장하여 계산하기 편하게 만듦
        for(int i=n;i<2*n;i++){
            sushi[i] = sushi[i-n];
        }
        // sliding window init
        boolean isCoupon = false;
        for(int i=0;i<k;i++){
            count[sushi[i]]++;

            if(sushi[i] == c){
                isCoupon = true;
            }
        }
        int max = 0;
        for(int i=1;i<=d;i++){
            if(count[i] > 0){
                max++;
            }
        }
        if(!isCoupon){
            max++;
        }
        int cur = max;
//        System.out.println("start:" + cur);
        //sliding window start
        for(int i=0;i<n;i++){
//            System.out.println("i "+ i);
            count[sushi[i]]--;
            if(count[sushi[i]] == 0){
//                System.out.println("pop " + sushi[i]);
                cur--;
            }
            if(count[sushi[i+k]] == 0){
//                System.out.println("push " + sushi[i+k]);
                cur++;
            }
            count[sushi[i+k]]++;
            // 쿠폰이 포함되었다가 사라진 경우
            if(isCoupon && count[c] == 0){
//                System.out.println("coupon out");
                cur++;
                isCoupon = false;
            }
            // 쿠폰이 없었는데 생긴 경우
            else if(!isCoupon && count[c] > 0){
//                System.out.println("coupon in");
                cur--;
                isCoupon = true;
            }
//            System.out.println(cur);
            max = Math.max(cur,max);
        }
        System.out.print(max);
    }
}
