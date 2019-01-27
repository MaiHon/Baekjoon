package Stack;

import java.io.*;
import java.util.*;

public class BJ1406_stack {
    public static void main(String args[])throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();
        String order;
        String[] put;

        st = new StringTokenizer(br.readLine());
        char[] charArray = st.nextToken().toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            left.push(charArray[i]);
        }

        int caseN = Integer.parseInt(br.readLine());

        for(int i=0; i<caseN; i++){
            order = br.readLine();
            switch(order){
                case "L":
                    if(!left.isEmpty()){
                        right.push(left.pop());
                    }
                    break;

                case "D":
                    if(!right.isEmpty()){
                        left.push(right.pop());
                    }
                    break;

                case "B":
                    if(!left.isEmpty()){
                        left.pop();
                    }
                    break;

                default:
                    put = order.split(" ");
                    left.push(put[1].charAt(0));
                    break;
            }
        }

        while(!left.isEmpty()){
            right.push(left.pop());
        }
        StringBuffer sb = new StringBuffer();
        while(!right.isEmpty()){
            sb.append(right.pop());
        }
        System.out.println(sb.toString());
    }
}
