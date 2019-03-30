package Implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class BJ2933_reference {

    static int[] dx = {0, 0, -1, +1};
    static int[] dy = {-1, +1, 0, 0};
    static int[] heights;
    static char[][] map;
    static int R, C, N;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception {
        getInput();
        // 입력 완료.
        /////////////////////////////////////////////
        for (int cnt = 0; cnt < N; cnt++) {
            int height = heights[cnt];
            throwStone(height, cnt % 2 == 0);
        }
        printMap();
    }

    public static void printMap() {
        for (int r = 0; r < R; r++)
            System.out.println(map[r]);
    }

    public static void throwStone(int height, boolean fromLeft) {
        if (fromLeft) {
            for (int cnt = 0; cnt < C; cnt++) {
                if (map[height][cnt] == 'x') {
                    map[height][cnt] = '.';
                    for (int dir = 0; dir < 4; dir++) {
                        int check_r = height + dy[dir];
                        int check_c = cnt + dx[dir];
                        if (check_r >= 0 && check_r < R && check_c >= 0 && check_c < C && map[check_r][check_c] == 'x') {
                            boolean[][] visited = new boolean[101][101];
                            visited[check_r][check_c] = true;
                            if (!isConnected(check_r, check_c, visited)) {
                                pullDown(visited);
                            }
                        }
                    }
                    break;
                }
            }
        } else {
            for (int cnt = C - 1; cnt >= 0; cnt--) {
                if (map[height][cnt] == 'x') {
                    map[height][cnt] = '.';
                    for (int dir = 0; dir < 4; dir++) {
                        int check_r = height + dy[dir];
                        int check_c = cnt + dx[dir];
                        if (check_r >= 0 && check_r < R && check_c >= 0 && check_c < C && map[check_r][check_c] == 'x') {
                            boolean[][] visited = new boolean[101][101];
                            visited[check_r][check_c] = true;
                            if (!isConnected(check_r, check_c, visited)) {
                                pullDown(visited);
                            }
                        }
                    }
                    break;
                }
            }
        }
    }

    public static void pullDown(boolean[][] visited) {
        HashSet<Integer> cs = new HashSet<>();
        for (int r = R - 1; r >= 0; r--) {
            for (int c = C - 1; c >= 0; c--) {
                if (visited[r][c]) {
                    cs.add(c);
                }
            }
        }
        /////////////////////////////////////////////
        int val = Integer.MAX_VALUE;
        for (int c : cs) {
            for (int r = R - 1; r >= 0; r--) {
                if (visited[r][c]) {
                    /////////////////////////////////
                    int count = 0;
                    int tmp_r = r;
                    while (tmp_r + 1 < R && map[tmp_r + 1][c] == '.') {
                        count++;
                        tmp_r++;
                    }
                    val = Math.min(val, count);
                    /////////////////////////////////
                    break;
                }
            }
        }
        /////////////////////////////////////////
        for (int r = R - 1; r >= 0; r--) {
            for (int c = C - 1; c >= 0; c--) {
                if (visited[r][c]) {
                    char tmp = map[r][c];
                    map[r][c] = '.';
                    map[r + val][c] = tmp;
                }
            }
        }
    }

    public static boolean isConnected(int r, int c, boolean[][] visited) {
        boolean ret = false;
        for (int dir = 0; dir < 4; dir++) {
            int next_r = r + dy[dir];
            int next_c = c + dx[dir];
            if (next_r == R) {
                ret = true;
                break;
            } else if (next_r >= 0 && next_r < R && next_c >= 0 && next_c < C && map[next_r][next_c] == 'x' && !visited[next_r][next_c]) {
                visited[next_r][next_c] = true;
                if (isConnected(next_r, next_c, visited)) {
                    ret = true;
                    break;
                }
            }
        }
        return ret;
    }

    public static void getInput() throws Exception {
        String[] parser = br.readLine().split(" ");
        R = Integer.parseInt(parser[0]);
        C = Integer.parseInt(parser[1]);
        map = new char[R][C];
        for (int r = 0; r < R; r++)
            map[r] = br.readLine().toCharArray();
        N = Integer.parseInt(br.readLine());
        heights = new int[N];
        parser = br.readLine().split(" ");
        for (int cnt = 0; cnt < N; cnt++)
            heights[cnt] = R - Integer.parseInt(parser[cnt]);
    }

}