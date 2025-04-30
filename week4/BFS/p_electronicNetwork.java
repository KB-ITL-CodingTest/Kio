package week4.BFS;

public class p_electronicNetwork {
    // 2 <= n <= 100
    static int dfs(boolean[][]map, boolean[] visited, int now){
        visited[now] = true;
        int cur = 1;
        for(int i=1;i<map[now].length;i++){
            if(map[now][i] && !visited[i]){
                cur += dfs(map, visited, i);
            }
        }
        return cur;
    }
    static public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        boolean[][] map = new boolean[n+1][n+1];
        for(int i=0;i<n-1;i++){
            map[wires[i][0]][wires[i][1]] = true;
            map[wires[i][1]][wires[i][0]] = true;
        }
        for(int i=0;i<n-1;i++){
            int t1 = wires[i][0];
            int t2 = wires[i][1];
            map[wires[i][0]][wires[i][1]] = false;
            map[wires[i][1]][wires[i][0]] = false;
//            System.out.println(dfs(map, new boolean[n+1], t1));
//            System.out.println(dfs(map, new boolean[n+1], t2));
            answer = Math.min(answer,Math.abs( dfs(map, new boolean[n+1], t1)- dfs(map, new boolean[n+1], t2)));
            map[wires[i][0]][wires[i][1]] = true;
            map[wires[i][1]][wires[i][0]] = true;
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.print(solution(7,new int[][] {{1,2},{2,7},{3,7},{3,4},{4,5},{6,7}}));
    }

}
