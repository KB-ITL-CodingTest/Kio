package week07.backtracking;

import java.io.*;
import java.util.*;

public class b15664_N과M10 {
    static int N,M;
    static int[] arr;
    static Set<String> set = new TreeSet<>();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static void backtrack(int depth, int start, int[] result) throws IOException {
        if(depth == M){
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<M;i++){
                sb.append(result[i]).append(" ");
            }
            bw.write(sb.toString());
            bw.newLine();
            return;
        }
        int prev = -1;
        for(int i=start;i<N;i++){
            if(prev == arr[i]) continue;
            prev = arr[i];
            result[depth] = arr[i];
            backtrack(depth+1,i+1,result);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        backtrack(0, 0, new int[M]);
        bw.flush();
        bw.close();
        br.close();
    }
}
