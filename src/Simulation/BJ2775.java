package Simulation;

import java.io.*;

public class BJ2775 {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testNum = Integer.parseInt(br.readLine());
        for (int i = 0; i < testNum; i++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());

            int[] floor = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
            for (int j = 0; j < k; j++) {
                int ppl = 0;
                for (int h = 0; h < n; h++) {
                    ppl += floor[h];
                    floor[h] = ppl;
                }


            }
            bw.write(Integer.toString(floor[n-1]));
            bw.newLine();

        }
        bw.flush();
    }
}
