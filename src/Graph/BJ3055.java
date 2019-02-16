package Graph;

import java.io.*;
import java.util.*;

public class BJ3055 {
    static int R, C, ans;
    static char[][] map;
    static boolean escaped = false;
    static boolean[][] visited;

    static Queue<int []> water;
    static Queue<int []> headgehog;

    static int[] dx = new int[]{1, 0, -1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};

    public static void main(String args[])throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.valueOf(st.nextToken());
        C = Integer.valueOf(st.nextToken());

        map = new char[R][C];
        visited = new boolean[R][C];

        water = new LinkedList<>();
        headgehog = new LinkedList<>();

        for(int i=0; i<R; i++){
            char[] chars = br.readLine().toCharArray();
            for(int j=0; j<C; j++){
                map[i][j] = chars[j];
                if(map[i][j]=='*') {
                    water.offer(new int[]{j, i});
                    visited[i][j] = true;
                }
                if(map[i][j]=='S') {
                    headgehog.offer(new int[]{j, i, 0});
                    visited[i][j] = true;
                }
                if(map[i][j]=='D' || map[i][j]=='X'){
                    visited[i][j] = true;
                }
            }
        }

        ans = 0;
        BFS();

        if(escaped){
            System.out.println(ans);
        }else{
            System.out.println("KAKTUS");
        }
    }

    static void BFS(){

        Outter : while(true){
            int wsize = water.size();
            for(int i=0; i<wsize; i++){
                int[] pos = water.poll();
                int px = pos[0];
                int py = pos[1];

                for(int j=0; j<4; j++){
                    int nx = px + dx[j];
                    int ny = py + dy[j];

                    if(nx<0 || nx>=C || ny<0 || ny>=R) continue;
                    if(visited[ny][nx]) continue;

                    visited[ny][nx] = true;
                    map[ny][nx] = '*';
                    water.offer(new int[]{nx, ny});

                    if(map[ny][nx]=='S'){
                        map[ny][nx] = '*';
                        water.offer(new int[]{nx, ny});
                    }
                }
            }

//            for(int i=0; i<R; i++){
//                System.out.println(Arrays.toString(map[i]));
//            }
//            System.out.println();

            int hsize = headgehog.size();
            for(int i=0; i<hsize; i++){
                int[] pos = headgehog.poll();
                int px = pos[0];
                int py = pos[1];
                int len = pos[2];

                for(int j=0; j<4; j++){
                    int nx = px + dx[j];
                    int ny = py + dy[j];

                    if(nx<0 || nx>=C || ny<0 || ny>=R) continue;
                    if(visited[ny][nx] && map[ny][nx]!='D') continue;
                    if(map[ny][nx]=='D'){
                        ans = len + 1;
                        escaped = true;
                        break Outter;
                    }

                    visited[ny][nx] = true;
                    map[ny][nx] = 'S';
                    map[py][px] = '.';
                    headgehog.offer(new int[]{nx, ny, len+1});
                }
            }

//            for(int i=0; i<R; i++){
//                System.out.println(Arrays.toString(map[i]));
//            }
//            System.out.println();

            if(headgehog.isEmpty()){
                break;
            }
        }
    }
}
