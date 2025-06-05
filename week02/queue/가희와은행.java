package week02.queue;

import java.io.*;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class 가희와은행 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 초기 서 있는 사람 수
        int n = Integer.parseInt(st.nextToken());
        // 명당 업무 처리 시간
        int t = Integer.parseInt(st.nextToken());
        // 제한 시간
        int w = Integer.parseInt(st.nextToken());
        Queue<int[]> playQ = new LinkedList<>();
        PriorityQueue<int[]> waitQ = new PriorityQueue<>(
                (a, b) -> Integer.compare(a[2], b[2])
        );
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            int[] cur = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            playQ.offer(cur);
        }
        int m = Integer.parseInt(br.readLine());
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int [] cur = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            waitQ.offer(cur);
        }
        int curId = 0,curRemain = 1, curStart = 0;
        for(int i=0;i<w;i++){
//            System.out.println("round " + i);
            curRemain--;
            if(!waitQ.isEmpty() && waitQ.peek()[2] == i){
//                System.out.println("insert to " + waitQ.peek()[0]);
                int cur[] = waitQ.poll();
                playQ.offer(new int[] {cur[0],cur[1]});
            }

            if(curRemain == 0){
//                System.out.println("complete " + curId);
                int[] cur = playQ.poll();
                curId = cur[0];
                curRemain = cur[1];
                curStart = i;

            }
            else if( (i - curStart) % t == 0){
//                System.out.println("back to " + curId);
                playQ.offer(new int[] {curId, curRemain});
                int cur[] = playQ.poll();
                curId = cur[0];
                curRemain = cur[1];
                curStart = i;
            }
            //System.out.println("cur i - curStart = " + (i-curStart) );
            bw.write(String.valueOf(curId));
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
