package BackTracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ1987 {
    private static char[][] map;
    private static int row, col, ans;

    private static int[] dx = new int[]{1, 0, -1, 0};
    private static int[] dy = new int[]{0, 1, 0, -1};

    private static HashMap<Character, Integer> checker;
    private static boolean isFinished;


    public static void main(String args[]){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            row = Integer.valueOf(st.nextToken());
            col = Integer.valueOf(st.nextToken());

            map = new char[row][col];
            for(int i=0; i<row; i++){
                char[] list = br.readLine().toCharArray();
                for(int j=0; j<col; j++){
                    map[i][j] = list[j];
                }
            }

            checker = new HashMap<>();

            isFinished = false;
            checker.put(map[0][0], 1);
            dfs(0, 0, 1);

            System.out.println(ans);

        }
        catch(Exception e){
            System.out.println(e);
        }

    }

    private static void dfs(int x, int y, int depth){
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx<0 || ny<0 || nx>=col || ny>=row) continue;
            if(checker.containsKey(map[ny][nx])){
                ans = Math.max(ans, depth);
                continue;
            }

            checker.put(map[ny][nx], 1);
            dfs(nx, ny, depth+1);
            checker.remove(map[ny][nx]);
        }
    }
}
