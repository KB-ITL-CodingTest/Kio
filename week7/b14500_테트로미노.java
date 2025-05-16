package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b14500_테트로미노 {
    static int[][] board;
    static int answer = 0;
    static int n,m;
    static boolean[] used = new boolean[5];
    static int[][][][] polynomino = {
            // I
            {
                    {{0,0},{0,1},{0,2},{0,3}},
                    {{0,0},{1,0},{2,0},{3,0}},
            },
            // O
            {
                    {{0,0},{0,1},{1,0},{1,1}},
            },
            // L - 기본 모양
            {
                    // L
                    {{0,0},{1,0},{2,0},{2,1}},
                    {{0,0},{0,1},{0,2},{1,0}},
                    {{0,0},{0,1},{1,1},{2,1}},
                    {{1,0},{1,1},{1,2},{0,2}},
                    // J
                    {{0,1},{1,1},{2,1},{2,0}},
                    {{0,0},{1,0},{1,1},{1,2}},
                    {{0,0},{0,1},{1,0},{2,0}},
                    {{0,0},{0,1},{0,2},{1,2}},
            },
            // S - 세운 모양
            {
                    {{0,1},{0,2},{1,0},{1,1}},
                    {{0,0},{1,0},{1,1},{2,1}},
                    // Z - 눕힌 모양
                    {{0,0},{0,1},{1,1},{1,2}},
                    {{0,1},{1,0},{1,1},{2,0}},
            },
            // T
            {
                    {{0,0},{0,1},{0,2},{1,1}},
                    {{0,1},{1,0},{1,1},{2,1}},
                    {{0,1},{1,0},{1,1},{1,2}},
                    {{0,0},{1,0},{1,1},{2,0}},
            }
    };

    static boolean check(int x, int y, int[][] cur ){
        for(int[] now : cur){
            if(x+now[0] < 0 || x+now[0] >= n || y+now[1] < 0 || y+now[1] >= m) return false;
        }
        return true;
    }
    static int put(int x, int y, int[][] cur){
        int ret = 0;
        for(int[] now : cur){
            ret += board[x+now[0]][y+now[1]];
        }
        return ret;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 최대 500 * 500
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                // 19가지
                for(int k=0;k<5;k++){
                    for(int[][] cur : polynomino[k]){
                        if(check(i,j,cur)){
                            answer = Math.max(answer, put(i,j,cur));
                        }
                    }
                }
            }
        }
        System.out.print(answer);
    }
}
