package week06.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b1182_subsequenceSum {
    static int N, S;
    static int dfs(int[] arr, int i, int sum) {
        if(i == N) {
            return sum == S ? 1 : 0;
        }
        int ret = 0;
        ret += dfs(arr, i+1, sum + arr[i]);
        ret += dfs(arr, i+1, sum);
        return ret;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int answer = dfs(arr, 0, 0);
        if(S == 0) answer--;
        System.out.println(answer);
    }
}
