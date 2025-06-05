package week09.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b2491_수열 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] seq = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            seq[i] = Integer.parseInt(st.nextToken());
        }
        int maxLen = 1;
        int[] dp_inc = new int[n];
        int[] dp_dec = new int[n];
        Arrays.fill(dp_inc, 1);
        Arrays.fill(dp_dec, 1);

        for (int i = 1; i < n; i++) {
            if (seq[i] > seq[i - 1]) {
                dp_inc[i] += dp_inc[i - 1];
            } else if (seq[i] < seq[i - 1]) {
                dp_dec[i] += dp_dec[i - 1];
            } else {
                dp_inc[i] += dp_inc[i - 1];
                dp_dec[i] += dp_dec[i - 1];
            }
            maxLen = Math.max(maxLen, Math.max(dp_inc[i], dp_dec[i]));
        }

        System.out.println(maxLen);
    }
}
