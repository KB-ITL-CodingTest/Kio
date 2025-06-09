package week11.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b2212_센서 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        int[] dist = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            dist[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(dist);
        int[] diff =  new int[N-1];
        for(int i =0;i<N-1;i++){
            diff[i] = dist[i+1]-dist[i];
        }
        // 어디를 기준으로 자를 것인가. K-1개의 지점을 오른쪽에 있는 센서와의 거리차로 저장 (greedy)
        Arrays.sort(diff);
        int ans = 0;
        //1 3 6 6 7 9의 경우 2개로 나눈다면 1 3 / 6 6 7 9 -> 6-3이 3으로 가장 크므로 이렇게 분할하면 거리차 총합의 3이 줄어든다.
        // 첫번째 기지국 [1,3], 두번째 기지국 [6,9]. 범위 내부 위치 어디든 총합은 변하지 않음.
        for(int i =0;i<N-K;i++){
            ans+=diff[i];
        }
        System.out.print(ans);
    }
}
