package week11.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class b11000_강의실배정 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] classroom = new int[N][2];
        PriorityQueue<Integer> pq =  new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            classroom[i][0] = Integer.parseInt(st.nextToken());
            classroom[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(classroom,(a,b)-> a[0] - b[0]);
        pq.offer(classroom[0][1]);
        for(int i = 1; i < N; i++){
            int prev = pq.poll();
            if(prev > classroom[i][0]){
                pq.offer(prev);
            }
            pq.offer(classroom[i][1]);
        }
        System.out.print(pq.size());
    }
}
