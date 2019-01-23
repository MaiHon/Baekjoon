package Stack;

import java.io.*;
import java.util.Stack;

public class BJ9012 {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testNum = Integer.parseInt(br.readLine());
        for(int i=0; i<testNum; i++){
            Stack<Character> ch = new Stack();
            char[] input = br.readLine().toCharArray();
            boolean isEnd = false;
            for(int j=0; j<input.length; j++) {
                if(input[j]=='(') ch.push(input[j]);
                else if(input[j]==')' && !ch.isEmpty()) ch.pop();
                else if(input[j]==')' && ch.isEmpty()) {
                    bw.write("NO\n");
                    isEnd = true;
                    break;
                }
            }
            if (!isEnd) {
                if (!ch.isEmpty()) {
                    bw.write("NO\n");
                } else {
                    bw.write("YES\n");
                }
            }
        }
        bw.flush();
    }
}
