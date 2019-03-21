package Mathmatics;

import java.util.Scanner;

public class BJ11051 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        int[][] map = new int[N+1][K+1];
        map[0][0] = 1;

        for(int i=1; i<=N; i++){
            map[i][0] = 1;
            for(int j=1; j<=K; j++){
                map[i][j] = (map[i-1][j-1] + map[i-1][j])%10007;
            }

        }

        System.out.println(map[N][K]);
    }
}
