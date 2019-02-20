package SAMSUNG;

import java.util.*;
import java.io.*;

public class BJ3190_v2 {
    static int N, K, L;
    static int[][] map;
    static Queue<int []> head, tail;

    static final int[] Xdir = new int[]{1, 0, -1, 0};
    static final int[] Ydir = new int[]{0, 1, 0, -1};

    public static void main(String args[])throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.valueOf(br.readLine());
        map = new int[N+2][N+2];

        Arrays.fill(map[0], -1);
        for (int i=1; i<=N; i++) {
            map[i][0] = -1;
            map[i][N + 1] = -1;
        }
        Arrays.fill(map[N + 1], -1);


        K = Integer.valueOf(br.readLine());
        for(int i=0; i<K; i++){
            String[] yAx = br.readLine().split(" ");
            int y = Integer.valueOf(yAx[0]);
            int x = Integer.valueOf(yAx[1]);
            map[y][x] = 1;
        }

        head = new LinkedList<>();
        tail = new LinkedList<>();

        head.offer(new int[]{1, 1, 0, 1}); // x, y, dir, len
        tail.offer(new int[]{1, 1, 0});

        L = Integer.valueOf(br.readLine());
        int[] move = new int[100001];
        for(int i=0; i<L; i++){
            String[] order = br.readLine().split(" ");
            int idx = Integer.valueOf(order[0]);
            String Dir = order[1];

            if(Dir.equals("L")){
                move[idx] = 3;
            }else{
                move[idx] = 1;
            }
        }

        for(int i=1; i<100001; i++){
            boolean apple = false;

            int[] h = head.poll();
            int hx = h[0];
            int hy = h[1];
            int dir = h[2];
            int len = h[3];

            int nx = hx + Xdir[dir];
            int ny = hy + Ydir[dir];

            switch (map[ny][nx]){
                case -1:
                    System.out.println(i);
                    return;
                case 0:
                    map[ny][nx] = 2;
                    break;
                case 1:
                    map[ny][nx] = 2;
                    ++len;
                    apple = true;
                    break;
                case 2:
                    System.out.println(i);
                    return;
            }

            if(move[i]!=0){
                dir = (dir + move[i])%4;
            }

            if(!apple){
                int[] t = tail.poll();
                int tx = t[0];
                int ty = t[1];
                int tDir = t[2];

                map[ty][tx] = 0;
                tx = t[0] + Xdir[t[2]];
                ty = t[1] + Ydir[t[2]];
                tDir = (tDir + move[i-len+1])%4;

                tail.offer(new int[]{tx, ty, tDir});
                head.offer(new int[]{nx, ny, dir, len});
            }else{
                head.offer(new int[]{nx, ny, dir, len});
            }
        }
    }
}
