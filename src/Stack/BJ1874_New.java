package Stack;

import java.io.*;
import java.util.Stack;

public class BJ1874_New {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Integer> st = new Stack();

        int testN = Integer.parseInt(br.readLine());
        int max = 0;
        boolean isError = false;

        for(int tN=1; tN<=testN; tN++){
            int n = Integer.parseInt(br.readLine());

            if(n>max){
                st.push(n);
                for(int i=max; i<n; i++) {
//                    bw.write("+\n");
                    sb.append("+\n");
                }
//                bw.write("-\n");
                sb.append("-\n");
                max = n;
            }
            else {
                if(st.peek()<n) {
                    isError = true;
                    break;
                }
                st.push(n);
//                bw.write("-\n");
                sb.append("-\n");
            }
        }

        if(isError){
            System.out.println("NO");
//            bw.close();
        } else{
            System.out.println(sb.toString());
//            bw.flush();
//            bw.close();
        }
    }
}


// Need to study abbout BufferedWriter and StringBuilder