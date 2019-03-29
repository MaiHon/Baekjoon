package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class BJ17070_dfs {
    static int N, cnt;
    static int[][] map;
    static int[][] chk;
    static boolean[][] visit;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        chk = new int[N][N];
        visit = new boolean[N][N];

        for(int i=0;i<N;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<N;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cnt = 0;
        dfs(0,1,0);

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                System.out.print(chk[i][j]);
            }
            System.out.println();
        }

        System.out.println(cnt);
    }

    //가로 세로 대각선
    private static int[][] dx = new int[][]{{1, 0, 1},
                                            {0, 0, 1},
                                            {1, 0, 1}};

    private static int[][] dy = new int[][]{{0, 0, 1},
                                            {0, 1, 1},
                                            {0, 1, 1}};

    public static void dfs(int y, int x, int type){
        //type
        //0 : 가로
        //1 : 세로
        //2 : 대각선

        chk[y][x]++;
        if(y==N-1 && x==N-1) { //도착
            cnt++;
            return;
        }

        for(int i=0;i<3;i++) {
            if(dx[type][i]==0 && dy[type][i]==0) continue;
            int nx = x + dx[type][i];
            int ny = y + dy[type][i];

            if(nx>=N || ny>=N) continue;
            if(map[ny][nx]==1) continue;
            if(i==2 && (map[ny-1][nx]==1 || map[ny][nx-1]==1)) continue;

            dfs(ny, nx, i);

        }

    }
}