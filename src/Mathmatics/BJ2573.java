package Mathmatics;

import java.io.*;
import java.util.*;

public class BJ2573 {
    static int N, M;
    static int[][] before, after;
    static boolean[][] visited;
    static Queue<int []> q;

    static final int[] dx = new int[]{1, 0, -1, 0};
    static final int[] dy = new int[]{0, 1, 0, -1};

    public static void main(String args[])throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.valueOf(st.nextToken()); //y
        M = Integer.valueOf(st.nextToken()); //x

        before = new int[N][M];
        after = new int[N][M];
        visited = new boolean[N][M];

        q = new LinkedList<>();
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                before[i][j] = Integer.valueOf(st.nextToken());
                after[i][j] = before[i][j];
                if(before[i][j]!=0) q.offer(new int[]{j, i});
            }
        }


        int ans = 0;
        int cnt = cntGroup();
        while(cnt<2){
            melting();
            cnt = cntGroup();
            beforeAndAfter();

            ans++;
            if(cnt==0){
                ans = 0;
                break;
            }
        }
        System.out.println(ans);
    }

    static void melting(){
        int len = q.size();

        for(int i=0; i<len; i++){
            int[] now = q.poll();
            int px = now[0];
            int py = now[1];

            int melt = 0;
            for(int j=0; j<4; j++){
                int nx = px + dx[j];
                int ny = py + dy[j];

                if(nx<0 || nx>=M || ny<0 || ny>=N) continue;
                if(visited[py][px]) continue;
                if(before[ny][nx]==0) {
                    melt -= 1;
                }
            }
            after[py][px] += melt;
            if(after[py][px]<0) after[py][px] = 0;
            if(after[py][px]>0) {
                visited[py][px] = true;
                q.offer(new int[]{px, py});
            }
        }
    }

    static int cntGroup(){
        int cnt = 0;
        visited = new boolean[N][M];

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(after[i][j]!=0 && !visited[i][j]){
                    Queue<int []> que = new LinkedList<>();
                    visited[i][j] = true;
                    que.offer(new int[]{j, i});

                    while(!que.isEmpty()){
                        int[] pos = que.poll();
                        int x = pos[0];
                        int y = pos[1];

                        for(int k=0; k<4; k++){
                            int nx = x + dx[k];
                            int ny = y + dy[k];

                            if(nx<0 || nx>=M || ny<0 || ny>=N) continue;
                            if(visited[ny][nx]) continue;
                            if(after[ny][nx]==0) continue;

                            visited[ny][nx] = true;
                            que.offer(new int[]{nx, ny});
                        }
                    }
                    cnt += 1;
                }
            }
        }
        visited = new boolean[N][M];
        return cnt;
    }

    static void beforeAndAfter(){
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                before[i][j] = after[i][j];
            }
        }
    }
}
