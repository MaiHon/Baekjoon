package SAMSUNG;

import java.io.*;
import java.util.*;

public class BJ16236 {
    static int N, ans;
    static int[][] map;
    static boolean[][] visited;

    static int sharkX;
    static int sharkY;
    static int shark, eaten;

    static int fishX;
    static int fishY;

    static int[] dx = new int[]{0, -1, 0, 1};
    static int[] dy = new int[]{-1, 0, 1, 0};

    public static void main(String args[])throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.valueOf(st.nextToken());
        map = new int[N+2][N+2];

        Arrays.fill(map[0], -1);
        for(int i=1; i<N+1; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<N+1; j++){
                map[i][j] = Integer.valueOf(st.nextToken());
                if(map[i][j]==9){
                    sharkX = j;
                    sharkY = i;
                    shark = 2;
                }
            }
            map[i][0] = map[i][N+1] = -1;
        }
        Arrays.fill(map[N+1], -1);

        getFish();
    }

    static int getDis(int sharkX, int sharkY, int fishX, int fishY){
        Queue<int []> q = new LinkedList<>();
        q.offer(new int[]{sharkX, sharkY, 0});

        visited = new boolean[N+2][N+2];
        int dis=Integer.MAX_VALUE;

        while(!q.isEmpty()){
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];
            int len = now[2];

            if(x==fishX && y==fishY){
                dis = len;
                break;
            }

            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(ny<1 || nx<1 || ny>N || nx>N) continue;
                if(visited[ny][nx]) continue;
                if(map[ny][nx]>shark) continue;

                visited[ny][nx] = true;
                q.offer(new int[]{nx, ny, len+1});
            }
        }

        return dis;
    }

    static void getFish(){
        while(true){
            boolean gotFish = false;
            int shortest = Integer.MAX_VALUE;

            for(int i=1; i<N+1; i++){
                for(int j=1; j<N+1; j++){
                    if(map[i][j]==0) continue;
                    if(map[i][j]>=shark) continue;

                    int dist = getDis(sharkX, sharkY, j, i);
                    if(dist<shortest){
                        shortest = dist;
                        fishX = j;
                        fishY = i;
                        gotFish = true;
                    }

                    if(dist==shortest && j < fishX && i == fishY){
                        fishX = j;
                        fishY = i;
                    }
                }
            }

            if(gotFish){
                map[fishY][fishX] = 9;
                map[sharkY][sharkX] = 0;
                eaten++;
                sharkX = fishX;
                sharkY = fishY;
                ans += shortest;

//                for(int[] arr : map){
//                    System.out.println(Arrays.toString(arr));
//                }System.out.println();


                if(eaten==shark){
                    eaten = 0;
                    shark++;
                }

            }else{
                System.out.println(ans);
                return;
            }
        }
    }
}