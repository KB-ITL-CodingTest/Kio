package week10;

import java.io.BufferedReader;
import java.util.StringTokenizer;

public class b14719_빗물 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int ans = 0;
        // 2차원 배열 풀이 O(h*w)
//        boolean[][] map = new boolean[h][w];
//        st = new StringTokenizer(br.readLine());
//        for(int i=0;i<w;i++){
//            int num = Integer.parseInt(st.nextToken());
//            for(int j=0;j<num;j++){
//                map[j][i] = true;
//            }
//        }
//        for(int i=0;i<h;i++){
//            boolean wall = false;
//            int water = 0;
//            for(int j=0;j<w;j++){
//                if(!wall && map[i][j]){
//                    wall = true;
//                }
//                else if(wall && !map[i][j]){
//                    water++;
//                }
//                else if(wall && map[i][j]){
//                    ans += water;
//                    water = 0;
//                }
//            }
//        }
        int[] blocks = new int[w];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < w; i++) {
            blocks[i] = Integer.parseInt(st.nextToken());
        }

        int[] leftMax = new int[w];
        int[] rightMax = new int[w];

        leftMax[0] = blocks[0];
        for (int i = 1; i < w; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], blocks[i]);
        }

        rightMax[w - 1] = blocks[w - 1];
        for (int i = w - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], blocks[i]);
        }
        for (int i = 1; i < w - 1; i++) {
            int water = Math.min(leftMax[i], rightMax[i]) - blocks[i];
            if (water > 0) {
                ans += water;
            }
        }
        System.out.print(ans);
    }
}