package week11.greedy;

import java.io.*;
import java.util.StringTokenizer;

public class b2812_크게만들기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int remain = K;
        int[] arr = br.readLine().chars().map(c -> c - '0').toArray();
        int[] stack = new int[N];
        int top = -1;
        for(int i =0;i<N;i++){
            while(top!=-1 && stack[top] < arr[i] && remain > 0){
                top--;
                remain--;
            }
            stack[++top] = arr[i];
        }
        for(int i =0;i< N-K ;i++){
            bw.write(String.valueOf(stack[i]));
        }
        bw.flush();
    }
}
