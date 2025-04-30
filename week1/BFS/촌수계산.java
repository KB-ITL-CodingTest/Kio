package week1.BFS;

import java.util.*;

public class 촌수계산 {
    static int n,start,end,m;
    static boolean[][] relation;
    public static void bfs(){
        Queue<Integer> q = new LinkedList<>();
        int[] visited = new int[n+1];
        q.offer(start);
        while(!q.isEmpty()){
            int cur = q.poll();
            for(int i=1;i<=n;i++){
                if(relation[cur][i] && visited[i] == 0) {
                    q.offer(i);
                    visited[i] = visited[cur] + 1;
                }
            }
        }
        if(visited[end] == 0)
            System.out.print(-1);
        else
            System.out.print(visited[end]);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        start = scanner.nextInt();
        end = scanner.nextInt();
        m = scanner.nextInt();
        relation = new boolean[n+1][n+1];
        int x,y;
        for(int i=0;i<m;i++){
            x = scanner.nextInt();
            y = scanner.nextInt();
            relation[x][y] = true;
            relation[y][x] = true;
        }
        bfs();
    }
}
