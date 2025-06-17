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
        int ans = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            int cnt = 0;
            for (int i = 0; i < m; i++) {
                cnt += (gem[i] + mid - 1) / mid;  // 올림 처리
            }

            if (cnt <= n) {
                ans = mid;        // 최소 불만도를 계속 갱신
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.print(ans);
    }
}
