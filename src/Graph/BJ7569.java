package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ7569 {
    static final int[] dx = new int[]{1, 0, -1, 0, 0, 0};
    static final int[] dy = new int[]{0, 1, 0, -1, 0, 0};
    static final int[] dh = new int[]{0, 0, 0, 0, 1, -1};

    static int M, N, H, max;
    static int[][][] map;
    static boolean[][][] visited;
    static Queue<int []> q;

    public static void main(String args[])throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.valueOf(st.nextToken()); //x
        N = Integer.valueOf(st.nextToken()); //y
        H = Integer.valueOf(st.nextToken()); //h

        map = new int[H][N][M];
        visited = new boolean[H][N][M];
        q = new LinkedList<>();

        for(int i=0; i<H; i++){
            for(int j=0; j<N; j++){
                st = new StringTokenizer(br.readLine());
                for(int k=0; k<M; k++){
                    map[i][j][k] = Integer.valueOf(st.nextToken());
                    if(map[i][j][k]==1) {
                        q.offer(new int[]{k, j, i});
                        visited[i][j][k] = true;
                    }
                }
            }
        }

        bfs();
        int day = dayCheck();

//        for(int i=0; i<H; i++){
//            for(int j=0; j<N; j++){
//                System.out.println(Arrays.toString(map[i][j]));
//            }
//        }

        System.out.println(day);

    }
    // when map[y][x] == 1, h == y/N
    static void bfs(){
        max = 0;

        while(!q.isEmpty()){
            int[] now = q.poll();
            int px = now[0];
            int py = now[1];
            int ph = now[2];

            for(int i=0; i<6; i++){
                int nx = px + dx[i];
                int ny = py + dy[i];
                int nh = ph + dh[i];

                if(nx<0 || nx>=M || ny<0 || ny>=N || nh<0 || nh>=H) continue;
                if(visited[nh][ny][nx]) continue;
                if(map[nh][ny][nx]==-1) continue;

                visited[nh][ny][nx] = true;
                map[nh][ny][nx] = map[ph][py][px] + 1;
                q.offer(new int[]{nx, ny, nh});
            }
        }
    }

    static int dayCheck(){
        max = 0;

        for(int i=0; i<H; i++){
            for(int j=0; j<N; j++){
                for(int k=0; k<M; k++){
                    if(map[i][j][k]==0) return -1;
                    max = Math.max(max, map[i][j][k]);
                }
            }
        }
        return max-1;
    }
}

