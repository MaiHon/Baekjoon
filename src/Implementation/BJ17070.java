package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ17070 {
    private static int N;
    private static int[][] map;

    // 가로, 세로, 대각선
    private static int[][] dx = new int[][]{{1, 0, 1},
                                            {0, 0, 1},
                                            {1, 0, 1}};

    private static int[][] dy = new int[][]{{0, 0, 1},
                                            {0, 1, 1},
                                            {0, 1, 1}};


    public static void main(String args[])throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.valueOf(br.readLine().trim());
        map  = new int[N][N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine().trim());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.valueOf(st.nextToken());
            }
        }

        // y, x, w
        // w=0: 가로, 1: 세로, 2: 대각선
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 1, 0});
        int cnt = 0;

        while(!q.isEmpty()){
            int[] now = q.poll();

            int px = now[1];
            int py = now[0];
            int pw = now[2];

            if(px==N-1 && py==N-1){
                cnt++;
                continue;
            }

            for(int i=0; i<3; i++){
                if(dx[pw][i]==0 && dy[pw][i]==0) continue;
                if(i==0 && px==N-1) continue;
                if(i==1 && py==N-1) continue;

                int nx = px + dx[pw][i];
                int ny = py + dy[pw][i];

                if(nx>=N || ny>=N) continue;
                if(map[ny][nx]==1) continue;
                if(i==2 && (map[ny-1][nx]==1 || map[ny][nx-1]==1)) continue;


                q.offer(new int[]{ny, nx, i});
            }
        }

        System.out.println(cnt);
    }
}
