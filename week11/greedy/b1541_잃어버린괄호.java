package week11.greedy;

import java.io.BufferedReader;
import java.util.Arrays;

public class b1541_잃어버린괄호 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        String[] parse = br.readLine().split("-");
        int n = parse.length;
        int[] parseInt = new int[n];
        for (int i = 0; i < n; i++) {
            String[] parts = parse[i].split("\\+");
            parseInt[i] = Arrays.stream(parts)
                    .mapToInt(Integer::parseInt)
                    .sum();
        }
        int ans = parseInt[0];
        for(int i = 1; i < n; i++){
            ans -= parseInt[i];
        }
        System.out.print(ans);
    }
}
