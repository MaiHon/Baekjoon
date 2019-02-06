package Brute_Force;

import java.util.*;
import java.io.*;

public class BJ14502 {
    static int m, n;
    static int nwall, nvirus;
    static boolean check[][];
    static int map[][], reset[][];
    static int dx[] = new int[]{1, 0, -1, 0};
    static int dy[] = new int[]{0, 1, 0, -1};

    public static void main(String args[])throws IOException{
        long stime = System.nanoTime();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        int size = m*n;
        nwall = 3;
        map = new int[m][n];
        reset = new int[m][n];
        check = new boolean[m][n];

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==1) nwall++;
                reset[i][j] = map[i][j];
            }
        }

        int ans = 0;
        for(int y1=0; y1<m; y1++){
            for(int x1=0; x1<n; x1++){
                if(map[y1][x1]!=0) continue;

                for(int y2=0; y2<m; y2++){
                    for(int x2=0; x2<n; x2++) {
                        if(map[y2][x2]!=0) continue;
                        if(x1==x2 && y1==y2) continue;


                        for(int y3=0; y3<m; y3++){
                            for(int x3=0; x3<n; x3++) {
                                if(map[y3][x3]!=0) continue;
                                if(x1==x3 && y1==y3) continue;
                                if(x2==x3 && y2==y3) continue;

                                nvirus = 0;
                                for(int i=0; i<m; i++){
                                    for(int j=0; j<n; j++){
                                        if(map[i][j]==2 && !check[i][j]){
                                            nvirus++;
                                            map[y1][x1] = map[y2][x2] = map[y3][x3] = 1;
                                            bfs(j, i);
                                        }
                                    }
                                }
                                int safe = m*n - nvirus - nwall;
                                ans = Math.max(ans, safe);

//                                System.out.println(m*n);
//                                System.out.println(nvirus);
//                                System.out.println(nwall);
//                                System.out.println(m*n - nvirus - nwall);

                                Reset();
                            }
                        }
                    }
                }
            }
        }
        System.out.println(ans);
        long etime = System.nanoTime();
//        System.out.println(etime-stime);
    }

    static void bfs(int x, int y){
        Queue<Grid> q = new LinkedList<>();
        q.offer(new Grid(x, y));
        check[y][x] = true;

        while(!q.isEmpty()){
            Grid g = q.poll();
            int gx = g.x;
            int gy = g.y;

            for(int i=0; i<4; i++){
                int nx = gx+dx[i];
                int ny = gy+dy[i];

                if(nx>=0 && nx<n && ny>=0 && ny<m){
                    if(!check[ny][nx] && map[ny][nx]==0){
                        map[ny][nx] = 2;
                        check[ny][nx] = true;
                        nvirus++;
                        q.offer(new Grid(nx, ny));
                    }
                }
            }
        }
    }

    static void Reset() {
        //slower...
//        for (int i=0; i<m; i++) {
//            map[i] = Arrays.copyOf(reset[i], n);
//        }

        for (int i=0; i<m; i++) {
            for(int j=0; j<n; j++){
                map[i][j] = reset[i][j];
            }
        }
        check = new boolean[m][n];
    }
}

class Grid{
    int x;
    int y;

    Grid(int x, int y){
        this.x = x;
        this.y = y;
    }

}