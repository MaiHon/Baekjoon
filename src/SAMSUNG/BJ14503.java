package SAMSUNG;

import java.io.*;
import java.util.*;

public class BJ14503 {
    static int[] dx = new int[]{0, 1, 0, -1}; // North, West, South, Eest
    static int[] dy = new int[]{-1, 0, 1, 0};

    static int N, M;
    static int[][] map;
    static Queue<int []> q;

    public static void main(String args[])throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.valueOf(st.nextToken());
        M = Integer.valueOf(st.nextToken());

        map = new int[N][M];

        st = new StringTokenizer(br.readLine());
        int firY = Integer.valueOf(st.nextToken());
        int firX = Integer.valueOf(st.nextToken());
        int firDir = Integer.valueOf(st.nextToken());

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.valueOf(st.nextToken());
            }
        }

        int ans = 0;
        q = new LinkedList<>();
        q.offer(new int[]{firX, firY, firDir});

        while(!q.isEmpty()){
            int[] now = q.poll();
            int curX = now[0];
            int curY = now[1];
            int curDir = now[2];


            if(map[curY][curX]==0){
                map[curY][curX] = 2;
                ans++;

//                System.out.println(curDir);
//                for (int[] arr : map) {
//                    System.out.println(Arrays.toString(arr));
//                }System.out.println();

            }

            boolean allClean = true;
            for(int i=3; i>=0; i--){
                int nextDir = (curDir + i)%4 ;
                int nextX = curX + dx[nextDir];
                int nextY = curY + dy[nextDir];

                if((map[nextY][nextX]==2 || map[nextY][nextX]==1)) continue;

                q.offer(new int[]{nextX, nextY, nextDir});
                allClean = false;
                break;
            }

            if(allClean){
                int nextDir = (curDir+2)%4;
                int nextX = curX + dx[nextDir];
                int nextY = curY + dy[nextDir];

                if(map[nextY][nextX]!=1) {
                    q.offer(new int[]{nextX, nextY, curDir});
                }
            }
        }

        System.out.println(ans);
    }
}
