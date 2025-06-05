package week01;

import java.io.*;
import java.util.*;

public class 배열복원하기 {
    static int[][] bArr;
    static int[][] aArr;
    static int h,w,x,y;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        bArr = new int[h+x][w+y];
        aArr = new int[h][w];
        for(int i=0;i< h+x;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<w+y;j++){
                bArr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<h; i++) {
            for(int j = 0; j<w; j++) {
                if(i < x || j < y)
                    aArr[i][j] = bArr[i][j];
                else
                    aArr[i][j] = bArr[i][j] - aArr[i-x][j-y];
            }
        }

        for(int i=0; i<h; i++) {
            for(int j=0; j<w; j++) {
                bw.write(aArr[i][j] +" ");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
