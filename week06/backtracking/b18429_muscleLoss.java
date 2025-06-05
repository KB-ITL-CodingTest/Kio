package week06.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b18429_muscleLoss {
    static int N,K;
    static int[] routine;
    static int dfs(int cnt, int weight, boolean[] visited) {
        if(weight < 500) return 0;
        if(cnt == N) return 1;
        int ret = 0;
        weight -= K;
        for(int i=0;i<N;i++){
            if(visited[i]) continue;
            visited[i] = true;
            ret += dfs(cnt+1, weight + routine[i], visited);
            visited[i] = false;
        }
        return ret;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        routine = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            routine[i] = Integer.parseInt(st.nextToken());
        }
        int answer = dfs(0,500, new boolean[N]);
        System.out.print(answer);
    }
}
