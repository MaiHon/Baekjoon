import java.io.*;
import java.util.Stack;

public class BJ1874 {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Integer> first = new Stack();

        int max = 1;
        int testNum = Integer.parseInt(br.readLine());
        for(int i=0; i<testNum; i++) {
            int n = Integer.parseInt(br.readLine());
            boolean isEnd = false;

            for (int tN=1; tN<=testNum; tN++) {
                if(first.isEmpty()){
                    first.push(tN);
                    bw.write("+\n");
                }
                else if(!first.isEmpty() && tN>max){
                    first.push(tN);
                    bw.write("+\n");
                }

                if(tN==n) {
                    if(first.peek()<n) isEnd = true;
                    first.pop();
                    if(max<n) max=n;
                    bw.write("-\n");
                    break;
                }
            }

            if(isEnd) break;
        }

        if(!first.isEmpty()){
            System.out.println("NO");
        }
        else {
            bw.flush();
        }

    }

}


// time over