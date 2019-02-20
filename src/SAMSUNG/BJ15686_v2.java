package SAMSUNG;

import java.io.*;
import java.util.*;

public class BJ15686_v2 {
    static int N, M, ans;
    static int[][] map;
    static boolean[] visited;

    static int[] houses;
    static int[] houseX;
    static int[] houseY;
    static int homeidx;

    static int[] chickens;
    static int[] chickenX;
    static int[] chickenY;
    static int chickenidx;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.valueOf(st.nextToken());
        M = Integer.valueOf(st.nextToken());

        map = new int[N + 2][N + 2];
        visited = new boolean[14];

        houseX = new int[2*N+1];
        houseY = new int[2*N+1];

        chickenX = new int[14];
        chickenY = new int[14];

        homeidx = 0;
        chickenidx = 0;

        Arrays.fill(map[0], -1);
        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < N + 1; j++) {
                map[i][j] = Integer.valueOf(st.nextToken());
                if (map[i][j] == 1) {
                    houseX[homeidx] = j;
                    houseY[homeidx] = i;
                    homeidx++;
                }

                if (map[i][j] == 2) {
                    chickenX[chickenidx] = j;
                    chickenY[chickenidx] = i;
                    chickenidx++;
                }
            }
            map[i][0] = -1;
            map[i][N + 1] = -1;
        }
        Arrays.fill(map[N + 1], -1);

        ans = Integer.MAX_VALUE;
        for(int i=0; i<=chickenidx-M; i++){
            visited[i] = true;
            dfs(1, i);
            visited[i] = false;
        }

        System.out.println(ans);
    }

    static void dfs(int depth, int idx){
        if(depth==M){
            int sum = 0;

            for(int i=0; i<homeidx; i++){
                int min = Integer.MAX_VALUE;
                for(int j=0; j<chickenidx; j++){
                    if(visited[j]){
                        int tmp = Math.abs(houseX[i] - chickenX[j]) + Math.abs(houseY[i] - chickenY[j]);
                        min = Math.min(min, tmp);
                    }
                }
                sum += min;
            }
            ans = Math.min(ans, sum);
            return;
        }

        for(int i=idx+1; i<=chickenidx-M+depth+1; i++){
            visited[i] = true;
            dfs(depth+1, i);
            visited[i] = false;
        }
    }
}