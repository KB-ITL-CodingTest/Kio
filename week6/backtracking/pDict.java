package week6.backtracking;

public class pDict {
    class Solution {
        int cnt = 0;
        boolean found = false;
        String[] alpha = {"A", "E", "I", "O", "U"};
        void backtrack(String target, StringBuilder source) {
            if(source.toString().equals(target)) {
                found = true;
                return;
            }
            if(source.length() >= 5) {
                return;
            }
            for(String a : alpha) {
                if(found) return;
                cnt++;
                source.append(a);
                backtrack(target, source);
                source.deleteCharAt(source.length()-1);
            }
        }
        public int solution(String word) {
            backtrack(word, new StringBuilder());
            return cnt;
        }
    }

    public static void main(String[] args) {
        Solution solution = new pDict().new Solution();
        int ans = solution.solution("AAAAE");
        System.out.println(ans);
        solution.cnt = 0;
        solution.found = false;

        ans = solution.solution("AAAE");
        System.out.println(ans);
    }
}
