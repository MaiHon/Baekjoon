package SAMSUNG;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ15683_v2 {
    static int N, M, camN, min;
    static int[][] map;
    static int[][] camSet;

    static int[][] move = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // 0: East, 1: South, 2: West, 3: North

    public static void main(String args[])throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.valueOf(st.nextToken());
        M = Integer.valueOf(st.nextToken());

        map = new int[N+2][M+2];
        camSet = new int[8][4];

        Arrays.fill(map[0], 6);
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<=M; j++){
                if(j==0) map[i][j] = 6;
                else {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if(map[i][j]!=6 && map[i][j]!=0) {
                        camSet[camN][0] = j;
                        camSet[camN][1] = i;
                        camSet[camN][2] = map[i][j];
                        camN++;
                    }
                }
            }
            map[i][M+1] = 6;
        }
        Arrays.fill(map[N+1], 6);

        min = Integer.MAX_VALUE;
        dfs(0);
        System.out.println(min);
    }

    static void dfs(int depth){
        if(depth==camN){
            int cnt = 0;
            for(int i=1; i<=N; i++){
                for(int j=1; j<=M; j++){
                    if(map[i][j]==0){
                        cnt++;
                    }
                }
            }

            min = Math.min(min, cnt);
            return;
        }

        int copy[][] = new int[N+2][M+2];
        int camType = camSet[depth][2];
        int camDir = camSet[depth][3];

        for(int i=0; i<4; i++){
            camSet[depth][3] = (camSet[depth][3]+i)%4;
            int[] new_dir = getDirs(camType, camSet[depth][3]);
            copyArea(copy, map);
            cam(new_dir, camSet[depth][1], camSet[depth][0]);
            dfs(depth + 1);
            copyArea(map, copy);
        }
        camSet[depth][3] = camDir;
    }

    static void copyArea(int[][] copy, int[][] origin){
        for(int i=0; i<N+2; i++){
            for(int j=0; j<M+2; j++){
                copy[i][j] = origin[i][j];
            }
        }
    }

    static int[] getDirs(int camType, int originDir){
        int[] Dirs = new int[4];
        switch(camType){
            case 1:
                Dirs[originDir] = 1;
                break;
            case 2:
                Dirs[originDir] = originDir;
                Dirs[(originDir+2)%4] = 1;
                break;
            case 3:
                Dirs[originDir] = originDir;
                Dirs[(originDir+1)%4] = 1;
                break;
            case 4:
                Dirs[originDir] = originDir;
                Dirs[(originDir+1)%4] = 1;
                Dirs[(originDir+2)%4] = 1;
                break;
            case 5:
                Dirs[0] = 1;
                Dirs[1] = 1;
                Dirs[2] = 1;
                Dirs[3] = 1;
                break;
        }
        return Dirs;
    }

    static void cam(int dir[], int row, int col){
        for(int j=0; j<4; j++){
            if(dir[j]==0) continue;

            int y = row;
            int x = col;
            while(true){
                x += move[j][1];
                y += move[j][0];

                if(x<1|| x>M+1 || y<1 || y>N+1) break;
                if(map[y][x]==6) break;
                if(map[y][x]==0) map[y][x] = 7; // 7 for areas where can be checked
            }
        }
    }
}