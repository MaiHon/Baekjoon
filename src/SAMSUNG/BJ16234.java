package SAMSUNG;

import java.util.*;
import java.io.*;

public class BJ16234 {
    static int N, L, R, ans, sum, countries, areaNum;
    static int[][] map, check;
    static int[] total, cnt;
    static boolean[][] visited;
    static boolean isUpdate;

    static Queue<int []> pos;

    static int[] dx = new int[]{1, 0, -1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};

    public static void main(String args[])throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.valueOf(st.nextToken());
        L = Integer.valueOf(st.nextToken());
        R = Integer.valueOf(st.nextToken());

        map = new int[N][N];
        visited = new boolean[N][N];
        check = new int[N][N];

        cnt = new int[2501];
        total = new int[2501];


        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.valueOf(st.nextToken());
            }
        }

        ans = 0;
        pos = new LinkedList<>();

        while(true){
            visited = new boolean[N][N];
            check = new int[N][N];
            isUpdate = false;
            areaNum = 0;

            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(visited[i][j]) continue;
                    bfs(j, i, map[i][j]);
                }
            }

            while(!pos.isEmpty()){
                int[] po = pos.poll();
                map[po[1]][po[0]] = total[po[2]] / cnt[po[2]];
            }

            if(!isUpdate) break;
            ans++;
        }

        System.out.println(ans);
    }

    static void bfs(int x, int y, int val){
        boolean keepGoing = false;

        for(int i=0; i<4; i++) {
            int nnx = x + dx[i];
            int nny = y + dy[i];

            if (nny < 0 || nnx < 0 || nnx >= N || nny >= N) continue;
            if (Math.abs(map[y][x] - map[nny][nnx]) < L) continue;
            if (Math.abs(map[y][x] - map[nny][nnx]) > R) continue;

            keepGoing = true;
        }


        if(keepGoing){
            areaNum++;
            sum = val;
            countries = 1;

            Queue<int[]> q = new LinkedList<>();

            q.offer(new int[]{x, y});
            pos.offer(new int[]{x, y, areaNum});
            while(!q.isEmpty()){
                int[] now = q.poll();
                int px = now[0];
                int py = now[1];

                check[py][px] = areaNum;
                visited[py][px] = true;

                for(int i=0; i<4; i++){
                    int nx = px + dx[i];
                    int ny = py + dy[i];

                    if(ny<0 || nx<0 || nx>=N || ny>=N) continue;
                    if(Math.abs(map[py][px]-map[ny][nx])<L) continue;
                    if(Math.abs(map[py][px]-map[ny][nx])>R) continue;
                    if(visited[ny][nx]) continue;

                    visited[ny][nx] = true;
                    check[ny][nx] = areaNum;

                    sum += map[ny][nx];
                    countries += 1;

                    q.offer(new int[]{nx, ny});
                    pos.offer(new int[]{nx, ny, areaNum});
                    isUpdate = true;
                }
            }

            cnt[areaNum] = countries;
            total[areaNum] = sum;
        }
    }
}