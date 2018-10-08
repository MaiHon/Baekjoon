import java.io.*;
import java.util.Stack;

public class BJ10828 {
    public static void main(String args[])throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Integer> st = new Stack();
        int num = Integer.parseInt(br.readLine());
        for(int tN=0; tN<num; tN++){
            String[] line = br.readLine().split(" ");
            switch(line[0]){
                case "push":
                    st.push(Integer.parseInt(line[1]));
                    break;

                case "pop":
                    if(!st.isEmpty()) {
                        bw.write(st.pop() + "\n");
                    }
                    else bw.write(-1 + "\n");
                    break;

                case "size":
                    bw.write(st.size() + "\n");
                    break;

                case "empty":
                    if(st.isEmpty()) bw.write(1 + "\n");
                    else bw.write(0 + "\n");
                    break;

                case "top":
                    if(!st.isEmpty()) bw.write(st.peek() + "\n");
                    else bw.write(-1 + "\n");
                    break;
            }

        }
        bw.flush();
    }
}