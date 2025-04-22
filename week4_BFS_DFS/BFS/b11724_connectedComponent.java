package week4_BFS_DFS.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b11724_connectedComponent {
    static int n,m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        boolean[][] graph = new boolean[n+1][n+1];
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = true;
            graph[b][a] = true;
        }
        boolean[] visited = new boolean[n+1];
        Queue<Integer> q = new LinkedList<>();
        int answer = 0;
        for(int i=1;i<=n;i++){
            if(visited[i]) continue;
            visited[i] = true;
            q.add(i);
            answer++;
            while(!q.isEmpty()){
                int u = q.poll();
                for(int v=1;v<=n;v++){
                    if(graph[u][v] && !visited[v]){
                        visited[v] = true;
                        q.add(v);
                    }
                }
            }
        }
        System.out.print(answer);
    }
}
