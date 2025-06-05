package week06.bitmasking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b1182_subsequenceSum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int count = 0;
        int totalSubsets = 1 << N;  // 2^N 개의 부분집합

        // 1 ~ 2^N-1 까지의 경우의 수를 모두 탐색한다
        for(int bitmask = 1; bitmask < totalSubsets; bitmask++) {
            int sum = 0;
            //arr i번째 값이 현재 검사하는 경우의 수에 포함 되는지 여부 검사, 포함된다면 sum에 더한다.
            for(int i = 0; i < N; i++) {
                if((bitmask & (1 << i)) != 0) {
                    sum += arr[i];
                }
            }
            if(sum == S) count++;
        }

        System.out.println(count);
    }
}
