package week06;

import java.io.*;
import java.util.ArrayList;

public class b16926_arrayRotation {
    static int[][] arr;
    static int N, M, R;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        R = Integer.parseInt(input[2]);
        arr = new int[N][M];
        for(int i=0;i<N;i++){
            input = br.readLine().split(" ");
            for(int j=0;j<M;j++){
                arr[i][j] = Integer.parseInt(input[j]);
            }
        }
        int[][] res = new int[N][M];
        int maxDepth = Math.min(N, M)/2;
        //바깥 껍질부터 한꺼풀씩 전개하여 R칸만큼 이동 후 저장한다.
        ArrayList<Integer> spread;
        for(int depth=0;depth<maxDepth;depth++){
            spread = new ArrayList<>();
            //상
            for(int i=depth;i<M-1-depth;i++){
                spread.add(arr[depth][i]);
            }
            //우
            for(int i=depth;i<N-1-depth;i++){
                spread.add(arr[i][M-1-depth]);
            }
            //하
            for(int i=M-1-depth;i>depth;i--){
                spread.add(arr[N-1-depth][i]);
            }
            //좌
            for(int i=N-1-depth;i>depth;i--){
                spread.add(arr[i][depth]);
            }

            int idx = R;
            int maxIdx = spread.size();
            //상
            for(int i=depth;i<M-1-depth;i++){
                res[depth][i] = spread.get(idx%maxIdx);
                idx++;
            }
            //우
            for(int i=depth;i<N-1-depth;i++){
                res[i][M-1-depth] = spread.get(idx%maxIdx);
                idx++;
            }
            //하
            for(int i=M-1-depth;i>depth;i--){
                res[N-1-depth][i] = spread.get(idx%maxIdx);
                idx++;
            }
            //좌
            for(int i=N-1-depth;i>depth;i--){
                res[i][depth] = spread.get(idx%maxIdx);
                idx++;
            }
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                bw.write(res[i][j] + " ");
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
    }


}
