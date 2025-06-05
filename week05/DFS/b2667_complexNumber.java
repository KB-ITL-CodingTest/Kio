package week05.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class b2667_complexNumber {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int dfs(int[][] map, boolean[][] visited, int n, int i, int j) {
        visited[i][j] = true;
        int ret = 1;
        for(int k = 0; k < 4; k++){
            int nx = i + dx[k];
            int ny = j + dy[k];
            if(nx < 0 || ny < 0 || nx >= n || ny >= n || visited[nx][ny] || map[nx][ny] == 0) continue;
            ret += dfs(map,visited,n,nx,ny);
        }
        return ret;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> res = new ArrayList<>();
        int[][] maps = new int[n][n];
        int[] answer;
        boolean[][] visited = new boolean[n][n];
        for(int i = 0; i < n; i++){
            String s = br.readLine();
            for(int j = 0; j < n; j++){
                maps[i][j] = s.charAt(j) - '0';
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(!visited[i][j] && maps[i][j] != 0){
                    res.add(dfs(maps,visited,n,i,j));
                }
            }
        }
        Collections.sort(res);
        System.out.println(res.size());
        for(int i : res){
            System.out.println(i);
        }
    }
}
