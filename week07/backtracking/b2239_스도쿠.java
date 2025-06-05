package week07.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class b2239_스도쿠 {
    static int[][] sudoku;
    static boolean find = false;
    static ArrayList<int[]> blanks = new ArrayList<>();
    static boolean[][] row = new boolean[9][10], col = new boolean[9][10], box = new boolean[9][10];
    static void simulate(int depth){
        if(find) return;
        if(depth == blanks.size()){
            find = true;
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<9;i++){
                for(int j=0;j<9;j++){
                    sb.append(sudoku[i][j]);
                }
                sb.append("\n");
            }
            System.out.print(sb);
            return;
        }
        int x = blanks.get(depth)[0];
        int y = blanks.get(depth)[1];
        for(int j=1;j<=9;j++){
            int boxIdx = x/3*3+y/3;
            if(row[x][j] || col[y][j] || box[boxIdx][j]) continue;
            sudoku[x][y] = j;
            row[x][j] = true;
            col[y][j] = true;
            box[boxIdx][j] = true;
            simulate(depth+1);
            sudoku[x][y] = 0;
            row[x][j] = false;
            col[y][j] = false;
            box[boxIdx][j] = false;
            if(find) return;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sudoku = new int[9][9];
        for(int i=0;i<9;i++){
            String line = br.readLine();
            for(int j=0;j<9;j++){
                int num = line.charAt(j) - '0';
                sudoku[i][j] = num;
                if(num == 0){
                    blanks.add(new int[]{i,j});
                }
                else{
                    row[i][num] = true;
                    col[j][num] = true;
                    box[i/3*3+j/3][num] = true;
                }
            }
        }
        simulate(0);
    }
}
