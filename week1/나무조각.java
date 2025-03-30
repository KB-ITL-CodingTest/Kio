package week1;

import java.util.Scanner;

public class 나무조각 {
    static int[] woods = new int[5];
    static void swap(int a, int b){
        int tmp;
        tmp = woods[a];
        woods[a] = woods[b];
        woods[b] = tmp;
    }
    static boolean correct(){
        for(int i=0;i<5;i++){
            if(woods[i] != i+1)
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for(int i=0;i<5;i++)
            woods[i] = scanner.nextInt();
        while(!correct()){
            for(int i=0;i<4;i++){
                if(woods[i] > woods[i+1]) {
                    swap(i, i + 1);
                    for (int wood : woods)
                        System.out.print(wood + " ");
                    System.out.println();
                }
            }
        }


    }
}
