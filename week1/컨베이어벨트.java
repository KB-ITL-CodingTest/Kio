package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 컨베이어벨트 {
    static int n, k;
    static int[] durability;
    static boolean[] convayer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        durability = new int[2*n];
        convayer = new boolean[2*n];
        int done = 0, round = 0;
        int start = 0, end = n-1;
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<2*n;i++){
            durability[i] = Integer.parseInt(st.nextToken());
        }
        while(done < k){
            round++;
            //1. 컨베이어 회전
            start = (start+2*n-1) % (2*n);
            end = (end+2*n-1) % (2*n);
            if(convayer[end]){
                convayer[end] = false;
            }
            //2. 앞으로 이동
            for(int i=1;i<n;i++){
                if(convayer[(end+2*n-i)%(2*n)] && !convayer[(end+2*n-i+1)%(2*n)] && durability[(end+2*n-i+1)%(2*n)] > 0){
                    convayer[(end+2*n-i)%(2*n)] = false;
                    convayer[(end+2*n-i+1)%(2*n)] = true;
                    durability[(end+2*n-i+1)%(2*n)]--;
                    if(durability[(end+2*n-i+1)%(2*n)] == 0){
                        done++;
                    }
                }
            }
            if(convayer[end]){
                convayer[end] = false;
            }
            //3. 로봇 놓기
            if(durability[start] > 0){
                convayer[start] = true;
                durability[start]--;
                if(durability[start] == 0){
                    done++;
                }
            }
        }
        System.out.print(round);
    }
}
