package week6.backtracking;

import java.io.*;
import java.util.StringTokenizer;

public class b6663_lotto {
    static int[] arr;
    static int k;
    static int[] sol;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static void solution(int idx, int depth) throws IOException {
        if(depth == 6){
            for(int i=0; i<6; i++){
                bw.write(sol[i]+" ");
            }
            bw.newLine();
            return;
        }
        for(int i=idx;i<k;i++){
            sol[depth] = arr[i];
            solution(i + 1,depth+1);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            if(k == 0) break;
            arr = new int[k];
            sol = new int[k];
            for(int i = 0; i < k; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            solution(0,0);
            bw.newLine();
        }
        bw.flush();
    }
}
