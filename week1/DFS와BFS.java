package week1;

import java.util.*;

public class DFS와BFS {
    static List<Integer>[] map;
    static boolean[] visited;
    public static void bfs(int v){
        Queue<Integer> q = new LinkedList<>();
        q.offer(v);
        visited[v] = true;
        while(!q.isEmpty()) {
            int cur = q.poll();
            System.out.print(cur+1 + " ");
            for (int next : map[cur]) {
                if (!visited[next]) {
                    q.offer(next);
                    visited[next] = true;
                }
            }
        }
    }
    public static void dfs(int v) {
        Stack<Integer> s = new Stack<>();
        s.push(v);
        while(!s.isEmpty()) {
            int cur = s.pop();
            if(visited[cur]){
                continue;
            }
            visited[cur] = true;
            System.out.print(cur+1 + " ");
            for (int i = map[cur].size() - 1; i >= 0; i--) {
                int next = map[cur].get(i);
                if (!visited[next]) {
                    s.push(next);
                }
            }
        }
    }
    public static void main(String[] args) {
        int n,m,v;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        v = scanner.nextInt();
        map = new ArrayList[n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            map[i] = new ArrayList<>();
        }
        int s,e;
        for(int i=0;i<m;i++){
            s = scanner.nextInt();
            e = scanner.nextInt();
            map[s-1].add(e-1);
            map[e-1].add(s-1);
        }

        for (int i = 0; i < n; i++) {
            Collections.sort(map[i]);
        }

        dfs(v-1);
        visited = new boolean[n];
        System.out.println();
        bfs(v-1);

    }
}
