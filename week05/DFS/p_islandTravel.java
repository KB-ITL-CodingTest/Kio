package week05.DFS;

import java.util.ArrayList;
import java.util.Collections;

public class p_islandTravel {
    static class Solution {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        int dfs(char[][] map, boolean[][] visited, int i, int j) {
            visited[i][j] = true;
            int n = map.length;
            int m = map[i].length;
            int ret = map[i][j] - '0';
            for(int k = 0; k < 4; k++){
                int nx = i + dx[k];
                int ny = j + dy[k];
                if(nx < 0 || ny < 0 || nx >= n || ny >= m || visited[nx][ny] || map[nx][ny] == 'X') continue;
                ret += dfs(map,visited,nx,ny);
            }
            return ret;
        }
        public int[] solution(String[] maps) {
            ArrayList<Integer> res = new ArrayList<>();
            int[] answer;
            char[][] map = new char[maps.length][maps[0].length()];
            boolean[][] visited = new boolean[maps.length][maps[0].length()];
            for(int i = 0; i < maps.length; i++){
                for(int j = 0; j < maps[i].length(); j++){
                    map[i][j] = maps[i].charAt(j);
                }
            }
            for(int i = 0; i < maps.length; i++){
                for(int j = 0; j < maps[i].length(); j++){
                    if(!visited[i][j] && map[i][j] != 'X'){
                        res.add(dfs(map,visited,i,j));
                    }
                }
            }
            Collections.sort(res);
            answer = !res.isEmpty() ? res.stream().mapToInt(i -> i).toArray(): new int[]{-1};
            return answer;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] ans = (sol.solution(new String[]{"X591X","X1X5X","X231X", "1XXX1"}));
        for(int i : ans){
            System.out.println(i);
        }
        ans = (sol.solution(new String[]{"XXX","XXX","XXX"}));
        for(int i : ans){
            System.out.println(i);
        }
    }
}
