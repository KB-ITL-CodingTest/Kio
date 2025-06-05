package week02.queue;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class 프로세스 {
    public static int solution(int[] priorities, int location) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<priorities.length; i++){
            pq.offer(-priorities[i]);
            q.offer(new int[]{priorities[i],i});
        }
        while(!q.isEmpty()){
            int[] cur = q.poll();
            if(-pq.peek() == cur[0]){
                pq.poll();
                answer++;
                if(cur[1] == location) break;
            }
            else{
                q.offer(cur);
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        int sol = solution(new int[]{2,1,3,2}, 2);
        System.out.println(sol);
    }
}
