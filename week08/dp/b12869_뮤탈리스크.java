package week08.dp;

import java.io.BufferedReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class b12869_뮤탈리스크 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[3];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        boolean[][][] visited;
        if(N == 1) visited = new boolean[arr[0]+1][1][1];
        else if(N == 2) visited = new boolean[arr[0]+1][arr[1]+1][1];
        else visited = new boolean[arr[0]+1][arr[1]+1][arr[2]+1];

        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0,0,0,0});
        visited[0][0][0] = true;
        int[][] damage = {{1,3,9},{1,9,3},{3,1,9},{3,9,1},{9,1,3},{9,3,1}};
        while(!q.isEmpty()){
            int[] cur = q.poll();
            if(cur[0] == arr[0] && cur[1] == arr[1] && cur[2] == arr[2]) {
                System.out.println(cur[3]);
                return;
            }
            for(int[] d : damage){
                int[] next = new int[4];
                System.arraycopy(cur, 0, next, 0, 4);
                for(int j=0;j<N;j++){
                    next[j] += d[j];
                    if(next[j] > arr[j]) next[j] = arr[j];
                }
                if(visited[next[0]][next[1]][next[2]]) continue;
                visited[next[0]][next[1]][next[2]] = true;
                q.offer(new int[]{next[0],next[1],next[2],next[3]+1});
            }
        }
    }
}
