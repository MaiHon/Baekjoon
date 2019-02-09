package Graph;

import java.io.*;
import java.util.*;

public class BJ10026_DFS {
    static int N;
    static char[][] map, RGmap;
    static boolean[][] check;
    static int[] dx = new int[]{1, -1, 0, 0};
    static int[] dy = new int[]{0, 0, 1, -1};

    public static void main(String args[])throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        RGmap = new char[N][N];
        check = new boolean[N][N];

        for(int i=0; i<N; i++){
            char[] arr = br.readLine().toCharArray();
            for(int j=0; j<N; j++){
                map[i][j] = arr[j];
                RGmap[i][j] = arr[j];
                if(arr[j]=='G') RGmap[i][j] = 'R';
            }
        }

        int RGB = 0;
        int RB = 0;

        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                if(map[i][j]!='0') {
                    dfs(j, i, map);
                    RGB++;
                }
                if(RGmap[i][j]!='0') {
                    dfs(j, i, RGmap);
                    RB++;
                }
            }
        }

        System.out.println(RGB+" "+RB);

    }

    static void dfs(int x, int y, char[][] map){
        char ch = map[y][x];
        check[y][x] = true;
        map[y][x] = '0';

        for(int i=0; i<4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(ny<0 ||ny >N-1 || nx<0 || nx>N-1 ) continue;

            char next = map[ny][nx];

            if(ch==next) dfs(nx, ny, map);
        }
    }
}
