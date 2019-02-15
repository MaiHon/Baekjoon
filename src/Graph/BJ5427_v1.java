package Graph;

import java.io.*;
import java.util.*;

public class BJ5427_v1 {
    static int N, M, ans;
    static char[][] map;
    static boolean[][] visited;
    static boolean escape;

    static Queue<int[]> fire, person;

    static final int[] dx = new int[]{1, 0, -1, 0};
    static final int[] dy = new int[]{0, 1, 0, -1};

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int caseN = Integer.valueOf(st.nextToken());

        while (caseN-- > 0) {
            st = new StringTokenizer(br.readLine());
            N = Integer.valueOf(st.nextToken());
            M = Integer.valueOf(st.nextToken());

            map = new char[M][N];
            visited = new boolean[M][N];

            fire = new LinkedList<>();
            person = new LinkedList<>();

            for (int i = 0; i < M; i++) {
                char[] chars = br.readLine().toCharArray();
                for (int j = 0; j < N; j++) {
                    char str = chars[j];
                    if (str == '#') {
                        map[i][j] = str;
                        visited[i][j] = true;
                    } else if (str == '*') {
                        map[i][j] = str;
                        fire.offer(new int[]{j, i});
                    } else if (str == '@') {
                        map[i][j] = str;
                        person.offer(new int[]{j, i, 0});
                    } else if (str == '.') map[i][j] = str;
                }
            }

            fireBFS();

            if(ans==0 && !escape){
                System.out.println("IMPOSSIBLE");
            }else{
                System.out.println(ans+1);
            }
        }
    }

    static void fireBFS() {
        ans = 0;
        escape = false;

        Outter : while(true){
            int size = fire.size();
            for(int l=0; l<size; l++){
                int[] fnow = fire.poll();
                int x = fnow[0];
                int y = fnow[1];

                for(int k=0; k<4; k++){
                    int pnx = x + dx[k];
                    int pny = y + dy[k];

                    if (pny < 0 || pny >= M || pnx < 0 || pnx >= N) continue;
                    if(map[pny][pnx]=='.' || map[pny][pnx]=='@'){
                        map[pny][pnx] = '^';
                        fire.offer(new int[]{pnx, pny});
                    }
                }
            }

            int psize = person.size();
            for(int p=0; p<psize; p++) {
                int[] now = person.poll();
                int px = now[0];
                int py = now[1];
                int len = now[2];

                if (px == N-1 || py == M-1 || px == 0 || py ==0) {
                    ans = len;
                    escape = true;
                    break Outter;
                }

                for (int i = 0; i<4; i++) {
                    int nx = px + dx[i];
                    int ny = py + dy[i];
                    int nlen = len + 1;

                    if (ny < 0 || ny >= M || nx < 0 || nx >= N) continue;
                    if (visited[ny][nx]) continue;
                    if (map[ny][nx] == '#' || map[ny][nx] == '*' || map[ny][nx] == '^') continue;

                    map[ny][nx] = '@';
                    if(map[py][px]!='^') map[py][px] = '.';
                    visited[ny][nx] = true;
                    person.offer(new int[]{nx, ny, nlen});
                }
            }

            int fsize = fire.size();
            for(int l=0; l<fsize; l++){
                int[] f = fire.poll();
                int x = f[0];
                int y = f[1];

                map[y][x] = '*';
                fire.offer(new int[]{x, y});
            }

            if(person.isEmpty() && fire.isEmpty()) break;
        }
    }
}