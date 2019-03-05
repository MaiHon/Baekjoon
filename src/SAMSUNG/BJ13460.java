package SAMSUNG;

import java.util.*;
import java.io.*;

public class BJ13460 {
    static int M, N;
    static char[][] map;
    static boolean[][][][] visited;
    static boolean inHoleR, inHoleB;

    static Queue<int[]> q;

    static final int[] dx = new int[]{0, 1, 0, -1};
    static final int[] dy = new int[]{-1, 0, 1, 0};

    public static void main(String args[])throws  IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.valueOf(st.nextToken()); //row
        M = Integer.valueOf(st.nextToken()); //column

        map = new char[N][M];
        visited = new boolean[N][M][N][M];

        int rX=0, rY=0;
        int bX=0, bY=0;

        for(int i=0; i<N; i++){
            char[] chars = br.readLine().toCharArray();
            for(int j=0; j<M; j++){
                map[i][j] = chars[j];
                if(map[i][j]=='B'){
                    bX = j;
                    bY = i;
                }
                if(map[i][j]=='R'){
                    rX = j;
                    rY = i;
                }
            }
        }

        q = new LinkedList<>();
        q.offer(new int[]{rX, rY, bX, bY, 0});
        visited[rY][rX][bY][bX] = true;

        while(!q.isEmpty()){
            int[] pos = q.poll();
            if(pos[4]>9) break;


            for(int i=0; i<4; i++){
                inHoleR = false;
                inHoleB = false;

                rX = pos[0];
                rY = pos[1];
                bX = pos[2];
                bY = pos[3];
                int cnt = pos[4];

                while(map[rY+dy[i]][rX+dx[i]]!='#'){
                    if(map[rY+dy[i]][rX+dx[i]]=='O'){
                        inHoleR = true;
                        break;
                    }
                    rX += dx[i];
                    rY += dy[i];
                }

                while(map[bY+dy[i]][bX+dx[i]]!='#'){
                    if(map[bY+dy[i]][bX+dx[i]]=='O'){
                        inHoleB = true;
                        break;
                    }
                    bX += dx[i];
                    bY += dy[i];
                }

                if(!inHoleB){
                    if(inHoleR){
                        System.out.println(cnt+1);
                        return;
                    }


                    if(rX==bX && rY==bY){
                        switch (i){
                            case 3:
                                if(pos[0]>pos[2]){
                                    rX = bX + 1;
                                }else{
                                    bX = rX + 1;
                                }
                                break;

                            case 2:
                                if(pos[1]>pos[3]){
                                    bY = rY - 1;
                                }else{
                                    rY = bY - 1;
                                }
                                break;

                            case 1:
                                if(pos[0]>pos[2]){
                                    bX = rX - 1;
                                }else{
                                    rX = bX - 1;
                                }
                                break;

                            case 0:
                                if(pos[1]>pos[3]){
                                    rY = bY + 1;
                                }else{
                                    bY = rY + 1;
                                }
                                break;
                        }
                    }
                    if(visited[rY][rX][bY][bX]) continue;

                    visited[rY][rX][bY][bX] = true;
                    q.offer(new int[]{rX, rY, bX, bY, cnt+1});
                }
            }
        }
        System.out.println(-1);
    }
}