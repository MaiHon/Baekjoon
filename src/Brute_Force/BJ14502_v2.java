package Brute_Force;

import java.util.*;
import java.io.*;

public class BJ14502_v2 {
    static int m, n, ans;
    static boolean check[][];
    static LinkedList<Info> virus, possible;
    static int map[][], copy[][];
    static int dx[] = new int[]{1, 0, -1, 0};
    static int dy[] = new int[]{0, 1, 0, -1};

    public static void main(String args[])throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new int[m][n];
        copy = new int[m][n];
        virus = new LinkedList<>();
        possible = new LinkedList<>();

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==2) virus.add(new Info(j, i));
                if(map[i][j]==0) possible.add(new Info(j, i));
            }
        }

        ans = 0;
        dfs(0, 0);
        System.out.println(ans);
    }

    static void dfs(int start, int len){
        if(len==3){
            copy();
//            Virus();
            for(Info i : virus){
                Virus(i.x, i.y);
            }

            int max = 0;
            for(int i=0; i<m; i++){
                for(int j=0; j<n; j++){
                    if(copy[i][j]==0) max++;
                }
            }
            ans = Math.max(ans, max);

            return;
        }

        for(int i=start; i<possible.size(); i++) {
            Info g = possible.get(i);
            map[g.y][g.x] = 1;
            dfs(i+1, len+1);
            map[g.y][g.x] = 0;
        }
    }

    static void /*Virus()*/Virus(int x, int y){
//        check = new boolean[m][n];
//        Queue<Info> q = new LinkedList<>();
//        for(int i=0; i<virus.size(); i++) {
//            q.add(virus.get(i));
//        }
//        while(!q.isEmpty()){
//            Info p = q.poll();
//            int px = p.x;
//            int py = p.y;
//
//            for(int i=0; i<4; i++){
//                int nx = px + dx[i];
//                int ny = py + dy[i];
//
//                if(nx>=0 && nx<n && ny>=0 && ny<m){
//                    if(copy[ny][nx]==0 && !check[ny][nx]){
//                        copy[ny][nx] = 2;
//                        q.offer(new Info(nx, ny));
//                    }
//                }
//            }
//        }
//        int max = 0;
//        for(int i=0; i<m; i++){
//            for(int j=0; j<n; j++){
//                if(copy[i][j]==0) max++;
//            }
//        }
//        ans = Math.max(ans, max);

        copy[y][x] = 2;
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx>=0 && nx<n && ny>=0 && ny<m){
                if(copy[ny][nx]==0){
                    copy[ny][nx] = 2;
                    Virus(nx, ny);
                }
            }

        }
    }

    static void copy(){
        for (int i=0; i<m; i++) {
            for(int j=0; j<n; j++){
                copy[i][j] = map[i][j];
            }
        }
    }
}

class Info{
    int x;
    int y;

    Info(int x, int y){
        this.x = x;
        this.y = y;
    }
}