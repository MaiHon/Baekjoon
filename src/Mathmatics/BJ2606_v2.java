package Mathmatics;

import java.util.*;

public class BJ2606_v2 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int E = sc.nextInt();

        int[][] map = new int[N+1][N+1];
        for(int i=0; i<E; i++){
            int from = sc.nextInt();
            int to = sc.nextInt();

            map[to][from] = map[from][to] = 1;
        }

        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                if(map[i][j]==0 && i!=j){
                    map[i][j] = 1000000;
                }
            }
        }
        for(int k=1; k<=N; k++){
            for(int i=1; i<=N; i++){
                for(int j=1; j<=N; j++){
                    if(map[i][k] + map[k][j] < map[i][j]){
                        map[i][j] = map[i][k] + map[k][j];
                    }
                }
            }
        }

        int ans = 0;
        for(int i=2; i<=N; i++){
            if(map[1][i]<1000000){
                ans += 1;
            }
        }

        System.out.println(ans);
    }
}
