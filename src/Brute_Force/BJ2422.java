package Brute_Force;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2422 {
    private static int N, M;
    private static int from, to, cnt=0;
    private static boolean map[][];
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String args[]){
        getInput();

        cnt = countN();
        System.out.println(cnt);
    }

    private static int countN(){
        int count = 0;

        for (int i=1; i<=N-2; i++) {
            for (int j=i+1; j<=N-1; j++) {
                for (int k=j+1; k<=N; k++) {
                    if (map[i][j] || map[j][k] || map[i][k])
                        continue;
                    count++;
                }
            }
        }
        return count;
    }

    private static void getInput(){
        try{
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            N = Integer.valueOf(st.nextToken());
            M = Integer.valueOf(st.nextToken());

            map = new boolean[N+1][N+1];

            for(int i=0; i<M; i++){
                st = new StringTokenizer(br.readLine().trim());
                from = Integer.parseInt(st.nextToken());
                to = Integer.parseInt(st.nextToken());

                map[from][to] = true;
                map[to][from] = true;
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
