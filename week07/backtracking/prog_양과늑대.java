package week07.backtracking;

import java.util.ArrayList;

public class prog_양과늑대 {
    static class Solution {
        int maxSheep = 0;
        void backtrack(ArrayList<Integer>[] tree, int[] info, int sheep, int wolf, ArrayList<Integer> canGo){
            // 늑대가 더 많아지면 아무리 양이 따라와도 계속 0이됨. 모든 가능한 경우를 다 본 경우에도 업데이트
            if(wolf >= sheep || canGo.isEmpty()) {
                maxSheep = Math.max(maxSheep, sheep);
                return;
            }
            for(int i=0; i<canGo.size(); i++){
                int now = canGo.get(i);
                // 복원하지 않고 진행하기 위해 복사해서 사용함
                ArrayList<Integer> next = new ArrayList<>(canGo);
                // visited 처리와 같은 의미 - 현재 위치에 도달했으므로 삭제한다
                next.remove(i);
                // 자식들로 갈 수 있음
                for(int nextNode : tree[now]){
                    if(next.contains(nextNode)) continue;
                    next.add(nextNode);
                }
                if(info[now] == 0) backtrack(tree, info, sheep+1, wolf, next);
                else backtrack(tree,info,sheep,wolf+1,next);
            }
        }
        public int solution(int[] info, int[][] edges) {
            ArrayList<Integer>[] tree = new ArrayList[info.length];
            for(int i=0;i<info.length;i++){
                tree[i] = new ArrayList<>();
            }
            for (int[] edge : edges) {
                int a = edge[0];
                int b = edge[1];
                tree[a].add(b);
            }
            //0번은 무조건 양이므로 먼저 해놓고 진행, 그렇지 않으면 0,0부터 시작해서 시작하자마자 리턴하여 추가 조건 설정해야함
            ArrayList<Integer> canGo = new ArrayList<>(tree[0]);

            backtrack(tree, info, 1, 0, canGo);
            return maxSheep;
        }
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] info = {0,0,1,1,1,0,1,0,1,0,1,1};
        int[][] edges = {{0,1},{1,2},{1,4},{0,8},{8,7},{9,10},{9,11},{4,3},{6,5},{4,6},{8,9}};
        System.out.println(solution.solution(info, edges));
        solution.maxSheep = 0;
        info = new int[]{0,1,0,1,1,0,1,0,0,1,0};
        edges = new int[][]{{0,1},{0,2},{1,3},{1,4},{2,5},{2,6},{3,7},{4,8},{6,9},{9,10}};
        System.out.println(solution.solution(info, edges));
        solution.maxSheep = 0;
        info = new int[]{0,1,1};
        edges = new int[][]{{0,1},{0,2}};
        System.out.println(solution.solution(info, edges));
    }
}
