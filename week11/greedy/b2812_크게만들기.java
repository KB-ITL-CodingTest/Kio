package week11.greedy;

import java.io.*;
import java.util.StringTokenizer;

public class b2812_크게만들기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int remain = K;
        int[] arr = br.readLine().chars().map(c -> c - '0').toArray();
        int[] stack = new int[N];
        int top = -1;
        for(int i =0;i<N;i++){
            // 스택이 비어있지 않고, 현재 값이 이전값보다 크며, 아직 K개를 다 지우지 않은 경우
            while(top!=-1 && stack[top] < arr[i] && remain > 0){
                top--;
                remain--;
            }
            stack[++top] = arr[i];
        }
        StringBuilder sb = new StringBuilder();
        for(int i =0;i< N-K ;i++){
            sb.append(stack[i]);
        }
        System.out.print(sb);
    }
}
