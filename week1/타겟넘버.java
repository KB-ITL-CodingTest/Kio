package week1;

import java.io.*;
import java.util.*;

public class 타겟넘버 {
    public static int dfs(int[] numbers, int target, int value, int depth){
        if(depth == numbers.length){
            if(target == value){
                return 1;
            }
            return 0;
        }
        int ret = 0;
        ret += dfs(numbers,target,value+numbers[depth],depth+1);
        ret += dfs(numbers,target,value-numbers[depth],depth+1);

        return ret;
    }
    public static int solution(int[] numbers, int target) {
        return dfs(numbers, target, 0, 0);
    }

    public static void main(String[] args) {
        int[] numbers = {4,1,2,1};
        int target = 4;
        System.out.print(solution(numbers,target));
    }
}
