package Graph;

import java.util.*;

public class BJ7562 {
    static int N, dex, dey, cnt;
    static int[][] map;
    static boolean[][] visitied;

    static final int[] dx = new int[]{2, 2, -2, -2, 1, -1, 1, -1};
    static final int[] dy = new int[]{1, -1, 1, -1, 2, 2, -2, -2};

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int caseN = sc.nextInt();

        ArrayList<Integer> anslist = new ArrayList<>();
        while(caseN-- >0){
            N = sc.nextInt();
            map = new int[N][N];
            visitied = new boolean[N][N];

            int y = sc.nextInt();
            int x = sc.nextInt();
            dey = sc.nextInt();
            dex = sc.nextInt();

            bfs(x, y);
            System.out.print(map[dey][dex] + " ");
        }
    }

    static void bfs(int x, int y){
        Queue<int []> q = new LinkedList<>();
        visitied[y][x] = true;
        q.offer(new int[]{x, y});

        while(!q.isEmpty()){
            cnt++;
            int[] now = q.poll();
            int px = now[0];
            int py = now[1];
            if(px==dex && py==dey) break;

            for(int i=0; i<8; i++){
                int nx = px + dx[i];
                int ny = py + dy[i];

                if(nx<0 || nx>=N || ny<0 || ny>=N) continue;
                if(visitied[ny][nx]) continue;

                visitied[ny][nx] = true;
                map[ny][nx] = map[py][px] + 1;
                q.offer(new int[]{nx, ny});
            }
        }
    }
}
