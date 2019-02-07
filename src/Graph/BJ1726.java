package Graph;

import java.io.*;
import java.util.*;

public class BJ1726 {
    static int m, n, ans;
    static int[] start, end;
    static int[][] map;
    static int[][][] copy;
    static boolean[][][] check;
    static int[] dx = new int[]{1, 0, -1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};
    //                          0, 1, 2,  3

    public static void main(String args[])throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map = new int[m][n];
        copy = new int[4][m][n];
        check = new boolean[4][m][n];

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        start = new int[3];
        end = new int[3];
        for(int i=0; i<2; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++){
                int add = Integer.parseInt(st.nextToken());
                if(j==2){
                    switch(add){
                        case 1:
                            add = 0;
                            break;
                        case 2:
                            add = 2;
                            break;
                        case 3:
                            add = 1;
                            break;
                        case 4:
                            add = 3;
                            break;
                    }
                }
                if(i==0) start[j] = add;
                if(i==1) end[j] = add;
            }
        }
        bfs(start[1]-1, start[0]-1, start[2]);

    }

    static void bfs(int x, int y, int dir){
        Queue<Robot> q = new LinkedList<>();
        q.offer(new Robot(x, y, dir));
        check[dir][y][x] = true;

        while(!q.isEmpty()){
            Robot r = q.poll();
            int px = r.x;
            int py = r.y;
            int pd = r.dir;

            if(px==end[1]-1 && py==end[0]-1){
                if(pd==end[2]){
                    System.out.println(copy[pd][py][px]);
                }else{
                    if(end[2]+2==pd || end[2]-2==pd){
                        System.out.println(copy[pd][py][px]+2);
                    }else{
                        System.out.println(copy[pd][py][px]+1);
                    }
                }
                return;
            }

            for(int i=1; i<=3; i++){
                int nx = px + i * dx[pd];
                int ny = py + i * dy[pd];

                if(nx>=0 && nx<n && ny>=0 && ny<m){
                    if(check[pd][ny][nx]) continue;
                    if(map[ny][nx]==1) break;
                    if(!check[pd][ny][nx]){
                        q.offer(new Robot(nx, ny, pd));
                        copy[pd][ny][nx] = copy[pd][py][px] + 1;
                        check[pd][ny][nx] = true;
                    }
                }
            }

            int nd = pd+1>3 ? 0:pd+1;
            if(!check[nd][py][px]){
                q.offer(new Robot(px, py, nd));
                copy[nd][py][px] = copy[pd][py][px] + 1;
                check[nd][py][px] = true;
            }

            nd = pd-1<0 ? 3:pd-1;
            if(!check[nd][py][px]){
                q.offer(new Robot(px, py, nd));
                copy[nd][py][px] = copy[pd][py][px] + 1;
                check[nd][py][px] = true;
            }
        }
    }
}

class Robot{
    int x;
    int y;
    int dir;

    Robot(int x, int y, int dir){
        this.x = x;
        this.y = y;
        this.dir = dir;
    }
}