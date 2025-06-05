package week05.BFS;

import java.io.*;
import java.util.*;

public class b18352_findCity {
    //도시 개수, 도로 개수, 거리 정보, 출발 도시
    static int N, M, K, X;
    static ArrayList<Integer>[] graph;
    static int[] visited;
    static void bfs(int start) {
        Deque<Integer> queue = new ArrayDeque<>();
        queue.addLast(start);
        visited[start] = 1;
        while(!queue.isEmpty()){
            int cur = queue.pollFirst();
            for(int next : graph[cur]){
                if(visited[next] == 0){
                    queue.addLast(next);
                    visited[next] = visited[cur] + 1;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N+1];
        for(int i = 1; i <= N; i++){
            graph[i] = new ArrayList<>();
        }
        visited = new int[N+1];
        for(int i = 1; i <= M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
        }
        bfs(X);
        boolean exist = false;
        for(int i = 1; i <= N; i++){
            if(visited[i] == K+1){
                bw.write(i + "\n");
                exist = true;
            }
        }
        if(!exist){
            bw.write("-1");
        }
        bw.flush();
    }
}
