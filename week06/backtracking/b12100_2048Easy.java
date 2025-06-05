package week06.backtracking;

import java.io.*;
import java.util.StringTokenizer;

public class b12100_2048Easy {
    static int n, answer;
    static int findMax(int[][] map){
        int max = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                max = Math.max(max, map[i][j]);
            }
        }
        return max;
    }
    static boolean isMoved(int[][] prev, int[][] cur){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(prev[i][j] != cur[i][j]) return true;
            }
        }
        return false;
    }
    static int[][] moveUp(int[][] cur){
        int[][] nextMap = new int[n][n];
        for(int j=0;j<n;j++){
            int idx = -1;
            boolean[] isMerged = new boolean[n];
            for(int i=0;i<n;i++){
                if(cur[i][j] != 0){
                    if(idx != -1 && nextMap[idx][j] == cur[i][j] && !isMerged[idx]){
                        nextMap[idx][j] += cur[i][j];
                        isMerged[idx] = true;
                    }
                    else{
                        nextMap[++idx][j] = cur[i][j];
                    }
                }
            }
        }
        return nextMap;
    }
    static int[][] moveDown(int[][] cur){
        int[][] nextMap = new int[n][n];
        for(int j=0;j<n;j++){
            int idx = n;
            boolean[] isMerged = new boolean[n];
            for(int i=n-1;i>=0;i--){
                if(cur[i][j] != 0){
                    if(idx != n && nextMap[idx][j] == cur[i][j] && !isMerged[idx]){
                        nextMap[idx][j] += cur[i][j];
                        isMerged[idx] = true;
                    }
                    else{
                        nextMap[--idx][j] = cur[i][j];
                    }
                }
            }
        }
        return nextMap;
    }
    static int[][] moveLeft(int[][] cur){
        int[][] nextMap = new int[n][n];
        for(int i=0;i<n;i++){
            int idx = -1;
            boolean[] isMerged = new boolean[n];
            for(int j=0;j<n;j++){
                if(cur[i][j] != 0){
                    if(idx != -1 && nextMap[i][idx] == cur[i][j] && !isMerged[idx]){
                        nextMap[i][idx] += cur[i][j];
                        isMerged[idx] = true;
                    }
                    else{
                        nextMap[i][++idx] = cur[i][j];
                    }
                }
            }
        }
        return nextMap;
    }
    static int[][] moveRight(int[][] cur){
        int[][] nextMap = new int[n][n];
        for(int i=0;i<n;i++){
            int idx = n;
            boolean[] isMerged = new boolean[n];
            for(int j=n-1;j>=0;j--){
                if(cur[i][j] != 0){
                    if(idx != n && nextMap[i][idx] == cur[i][j] && !isMerged[idx]){
                        nextMap[i][idx] += cur[i][j];
                        isMerged[idx] = true;
                    }
                    else{
                        nextMap[i][--idx] = cur[i][j];
                    }
                }
            }
        }
        return nextMap;
    }

    static void backtrack(int depth,int[][] map){
        if(depth == 5){
            answer = Math.max(answer, findMax(map));
            return;
        }
        for(int dir=0;dir<4;dir++){
            int[][] copy;
            // 향상된 switch문은 java 14부터 사용 가능
            switch (dir){
                case 0:
                    copy = moveUp(map);
                    break;
                case 1:
                    copy = moveDown(map);
                    break;
                case 2:
                    copy = moveLeft(map);
                    break;
                case 3:
                    copy = moveRight(map);
                    break;
                default:
                    copy = map;
            }
            if(isMoved(map,copy)){
                backtrack(depth+1,copy);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] > answer) answer = map[i][j];
            }
        }
        backtrack(0,map);
        System.out.println(answer);
        br.close();
    }
}
