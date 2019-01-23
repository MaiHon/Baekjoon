package Stack;

import java.io.*;
import java.util.*;

public class BJ10799 {
    public static void main(String args[])throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> st = new Stack();

        String[] input = br.readLine().split("");
        int cnt = 0;

        for(int i=0; i<input.length; i++){
            if(input[i].equals("(")){
                st.push(i);
            }else if(input[i].equals(")")){
                if(input[i-1].equals("(")){
                    st.pop();
                    cnt += st.size();
                }else{
                    st.pop();
                    cnt += 1;
                }
            }
        }
        System.out.println(cnt);

    }
}
