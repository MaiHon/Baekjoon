package SAMSUNG;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ15683_v1 {
    static int N, M, Cam, min;
    static int[][] map;
    static boolean camVisited[][];

    public static void main(String args[])throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.valueOf(st.nextToken());
        M = Integer.valueOf(st.nextToken());

        map = new int[N+2][M+2];
        camVisited = new boolean[N+2][M+2];

        Arrays.fill(map[0], 6);
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<=M; j++){
                if(j==0) map[i][j] = 6;
                else {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if(map[i][j]!=6 && map[i][j]!=0) Cam += 1;
                }
            }
            map[i][M+1] = 6;
        }
        Arrays.fill(map[N+1], 6);

        min = Integer.MAX_VALUE;
        dfs(0, map, 0, 0);
        System.out.println(min);
    }

    static void dfs(int depth, int[][] map, int o, int t){
        if(depth==Cam){
            int cnt = 0;
            for(int i=1; i<=N+1; i++){
                for(int j=1; j<=M+1; j++){
                    if(map[i][j]==0){
                        cnt += 1;
                    }
                }
            }
            min = Math.min(min, cnt);
            return;
        }else{
            for(int i=o; i<=N; i++){
                for(int j=1; j<=M; j++){
                    if(map[i][j]!=0 && map[i][j]!=6 && map[i][j]!=7){
                        if(camVisited[i][j]) continue;
                        camVisited[i][j] = true;
                        int[][] copy = new int[N+2][M+2];


                        if(map[i][j]==1){
                            for(int k=0; k<4; k++){
                                copyArea(copy, map);
                                cam(k, i, j, copy);
                                dfs(depth+1, copy, i, j);
                            }
                        }else if(map[i][j]==2){
                            for(int k=0; k<2; k++){
                                copyArea(copy, map);
                                cam(k, i, j, copy);
                                cam(k+2, i, j, copy);
                                dfs(depth+1, copy, i, j);
                            }
                        }else if(map[i][j]==3){
                            for(int k=0; k<4; k++){
                                copyArea(copy, map);
                                cam(k%4, i, j, copy);
                                cam((k+1)%4, i, j, copy);
                                dfs(depth+1, copy, i, j);
                            }
                        }else if(map[i][j]==4){
                            for(int k=0; k<4; k++){
                                copyArea(copy, map);
                                cam(k%4, i, j, copy);
                                cam((k+1)%4, i, j, copy);
                                cam((k+2)%4, i, j, copy);
                                dfs(depth+1, copy, i, j);
                            }
                        }else if(map[i][j]==5){
                            copyArea(copy, map);
                            cam(0, i, j, copy);
                            cam(1, i, j, copy);
                            cam(2, i, j, copy);
                            cam(3, i, j, copy);
                            dfs(depth+1, copy, i, j);
                        }


                        camVisited[i][j] = false;
                    }
                }
            }
        }
    }

    static void copyArea(int[][] copy, int[][] origin){
        for(int i=0; i<N+2; i++){
            for(int j=0; j<M+2; j++){
                copy[i][j] = origin[i][j];
            }
        }
    }


    static void cam(int dir, int row, int col, int[][] map){
        switch (dir){
            case 0:
                for(int i=1; i<=M-1; i++){
                    if(col+i>M+1) break;
                    if(map[row][col+i]==6) break;

                    if(map[row][col+i]==0){
                        map[row][col+i] = 7;
                    }
                }
                break;
            case 1:
                for(int i=1; i<=N-1; i++){
                    if(row+i>N+1) break;
                    if(map[row+i][col]==6) break;

                    if(map[row+i][col]==0){
                        map[row+i][col] = 7;
                    }
                }
                break;
            case 2:
                for(int i=1; i<=M-1; i++){
                    if(col-i<1) break;
                    if(map[row][col-i]==6) break;

                    if(map[row][col-i]==0){
                        map[row][col-i] = 7;
                    }
                }
                break;
            case 3:
                for(int i=1; i<=N-1; i++){
                    if(row-i<1) break;
                    if(map[row-i][col]==6) break;

                    if(map[row-i][col]==0){
                        map[row-i][col] = 7;
                    }
                }
                break;
        }
    }
}