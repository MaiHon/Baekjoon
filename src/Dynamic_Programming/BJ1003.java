package Dynamic_Programming;

import java.io.*;

public class BJ1003 {
    static int cntZ;
    static int cntO;
    public static void main(String args[]) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        for(int tN = 0; tN<num; tN++){
            int n = Integer.parseInt(br.readLine());
            // Initialize static variables
            cntO = 0;
            cntZ = 0;
            int ans = fibonacci(n);
            bw.write(cntZ + " " + cntO);
            bw.newLine();
        }
        bw.flush();
    }

    // Create a static method for using it without Instance
    static int fibonacci(int n){
        if(n == 0) {
            cntZ++;
            return 0;
        }
        else if(n == 1) {
            cntO++;
            return 1;
        }
        else {
            return fibonacci(n-1) + fibonacci(n-2);
        }
    }
}
