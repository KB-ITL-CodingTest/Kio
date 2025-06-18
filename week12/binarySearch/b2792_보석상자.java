package week12.binarySearch;

import java.io.BufferedReader;
import java.util.StringTokenizer;

public class b2792_보석상자 {
    static int n,m;
    static int[] gem;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        gem = new int[m];
        int max = 0;
        for(int i=0;i<m;i++){
            gem[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, gem[i]);
        }
        int left = 1;
        int right = max;
        while (left <= right) {
            // 오버플로우 방지
            int mid = left + (right - left) / 2;

            int cnt = 0;
            for (int i = 0; i < m; i++) {
                //i번째 보석을 mid개로 나누었을 때, 몇 명이 나누어 가질지 카운팅
                cnt += (gem[i] + mid - 1) / mid;
            }
            // n명 이하끼리 나누었다면 개수를 줄여야 한다.
            // 최소값을 찾아야 하므로 n명이 나눴더라도 계속 진행함
            if (cnt <= n) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.print(left);
    }
}
