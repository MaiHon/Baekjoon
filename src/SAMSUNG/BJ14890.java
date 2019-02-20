package SAMSUNG;

import java.io.*;
import java.util.*;

public class BJ14890 {
    static int N, L, cnt;
    static int[][] map;
    static boolean[][] visited;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.valueOf(st.nextToken());
        L = Integer.valueOf(st.nextToken());

        map = new int[N + 2][N + 2];
        visited = new boolean[N+2][N+2];

        Arrays.fill(map[0], -1);
        for (int i = 1; i < N + 1; i++) {
            map[i][0] = -1;
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < N+1; j++) {
                map[i][j] = Integer.valueOf(st.nextToken());
            }
            map[i][N+1] = -1;
        }
        Arrays.fill(map[N+1], -1);


        cnt = 0;
        for(int i=1; i<=N; i++){
            rampX(i, 1);
        }

        visited = new boolean[N+2][N+2];

        for(int i=1; i<=N; i++){
            rampY(1, i);
        }

        System.out.println(cnt);
    }

    static void rampY(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});

        while(!q.isEmpty()){
            int[] now = q.poll();
            int px = now[0];
            int py = now[1];

            if(px == N && py == y) break;

            int nx = px+1;
            int ny = py;

            switch (map[py][px]-map[ny][nx]){
                case -1: // nextV > curV
                    for(int i=1; i<=L; i++){
                        if(nx-i<1) return;
                        if(map[ny][nx-i]+1!=map[ny][nx]) return;
                        if(visited[ny][nx-i]) return;
                    }
                    for(int i=1; i<=L; i++){
                        visited[ny][nx-i] = true;
                    }
                    q.offer(new int[]{nx, ny});

                    break;
                case 0: // nextV == curV
                    q.offer(new int[]{nx, ny});
                    break;
                case 1: // nextV < curV
                    for(int i=1; i<L; i++){
                        if(nx+i>N) return;
                        if(map[ny][nx+i]+1!=map[py][px]) return;
                        if(visited[ny][nx+i]) return;
                    }
                    for(int i=0; i<L; i++){
                        visited[ny][nx+i] = true;
                    }
                    q.offer(new int[]{nx+L-1, ny});

                    break;
                default:
                    return;
            }
        }
        cnt += 1;
    }

    static void rampX(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});

        while(!q.isEmpty()){
            int[] now = q.poll();
            int px = now[0];
            int py = now[1];

            if(px == x && py == N) break;

            int nx = px;
            int ny = py+1;

            switch (map[py][px]-map[ny][nx]){
                case -1: // nextV > curV
                    for(int i=1; i<=L; i++){
                        if(ny-i<1) return;
                        if(map[ny-i][nx]+1!=map[ny][nx]) return;
                        if(visited[ny-i][nx]) return;
                    }
                    for(int i=1; i<=L; i++){
                        visited[ny-i][nx] = true;
                    }
                    q.offer(new int[]{nx, ny});

                    break;
                case 0: // nextV == curV
                    q.offer(new int[]{nx, ny});
                    break;
                case 1: // nextV < curV
                    for(int i=1; i<L; i++){
                        if(ny+i>N) return;
                        if(map[ny+i][nx]+1!=map[py][px]) return;
                        if(visited[ny+i][nx]) return;
                    }
                    for(int i=0; i<L; i++){
                        visited[ny+i][nx] = true;
                    }
                    q.offer(new int[]{nx, ny+L-1});

                    break;
                default:
                    return;
            }
        }
        cnt += 1;
    }
}
