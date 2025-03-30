package week1;

import java.util.*;
import java.io.*;

public class CPU {
    public static String ten_to_two(int n,int r){
        StringBuilder sb = new StringBuilder();
        while(n > 0){
            sb.append(n&1);
            n = n >> 1;
        }
        while (sb.length() < r) { // 3자리 미만이면 앞에 0 추가
            sb.append("0");
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) throws IOException{
        Map<String,String> opcodeMap = new HashMap<>();
        opcodeMap.put("ADD","0000");
        opcodeMap.put("SUB","0001");
        opcodeMap.put("MOV","0010");
        opcodeMap.put("AND","0011");
        opcodeMap.put("OR","0100");
        opcodeMap.put("NOT","0101");
        opcodeMap.put("MULT","0110");
        opcodeMap.put("LSFTL","0111");
        opcodeMap.put("LSFTR","1000");
        opcodeMap.put("ASFTR","1001");
        opcodeMap.put("RL","1010");
        opcodeMap.put("RR","1011");


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            int rD = Integer.parseInt(st.nextToken());
            int rA = Integer.parseInt(st.nextToken());
            int rB = Integer.parseInt(st.nextToken());

            StringBuilder sb = new StringBuilder();
            String ret;

            if(command.endsWith("C")){
                String substr = command.substring(0, command.length()-1);
                sb.append(opcodeMap.get(substr));
                sb.append("10");
                sb.append(ten_to_two(rD,3));
                sb.append(ten_to_two(rA, 3));
                sb.append(ten_to_two(rB,4));
            }
            else{
                sb.append(opcodeMap.get(command));
                sb.append("00");
                sb.append(ten_to_two(rD,3));
                sb.append(ten_to_two(rA, 3));
                sb.append(ten_to_two(rB,3));
                sb.append("0");
            }

            ret = sb.append('\n').toString();
            bw.write(ret);
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
