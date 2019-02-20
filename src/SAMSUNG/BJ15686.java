package SAMSUNG;

import java.util.*;
import java.io.*;

public class BJ15686 {
    static int N, M, ans;
    static int[][] map;
    static boolean[][] visited;

    static ArrayList<int[]> houses;
    static ArrayList<int[]> chickens;

    public static void main(String args[])throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.valueOf(st.nextToken());
        M = Integer.valueOf(st.nextToken());

        map = new int[N+2][N+2];
        visited = new boolean[N+2][N+2];
        houses = new ArrayList<>();
        chickens = new ArrayList<>();

        Arrays.fill(map[0], -1);
        for(int i=1; i<N+1; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<N+1; j++){
                map[i][j] = Integer.valueOf(st.nextToken());
                if(map[i][j]==1) houses.add(new int[]{j, i});
            }
            map[i][0] = -1;
            map[i][N+1] = -1;
        }
        Arrays.fill(map[N+1], -1);

        ans = Integer.MAX_VALUE;
        dfs(0, 1, 1);
        System.out.println(ans);
    }

    static void dfs(int depth, int x, int y){
        if(depth==M){
            int sum = 0;

            for(int i=0; i<houses.size(); i++){
                int min = Integer.MAX_VALUE;
                int[] house = houses.get(i);

                for(int j=0; j<chickens.size(); j++){
                    int[] chicken = chickens.get(j);

                    int tmp = Math.abs(chicken[0] - house[0]) + Math.abs(chicken[1] - house[1]);
                    min = Math.min(min, tmp);
                }
                sum += min;
            }
            ans = Math.min(ans, sum);
            return;
        }

        for(int i=y; i<N+1; i++){
            for(int j=1; j<N+1; j++){
                if(visited[i][j]) continue;
                if(map[i][j]!=2) continue;

                visited[i][j] = true;
                chickens.add(new int[]{j, i});
                dfs(depth+1, j, i);
                chickens.remove(depth);
                visited[i][j] = false;
            }
        }
    }
}
