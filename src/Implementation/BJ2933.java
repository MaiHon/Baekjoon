package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class BJ2933 {
    private static int r, c, n;
    private static int[] heights;
    private static char[][] cave;
    private static int[][] cluster;
    private static boolean[][] visit;

    private static LinkedList<int[]> q;
                                          
    public static void main(String args[])throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nums = br.readLine().trim().split(" ");

        r = Integer.valueOf(nums[0]);
        c = Integer.valueOf(nums[1]);

        cave = new char[r][c];
        cluster = new int[r][c];
        visit = new boolean[r][c];
        for(int i=0; i<r; i++){
            char[] row = br.readLine().toCharArray();
            for(int j=0; j<c; j++){
                cave[i][j] = row[j];
            }
        }

        n = Integer.valueOf(br.readLine().trim());
        heights = new int[n];

        String[] height = br.readLine().split(" ");
        for(int i=0; i<n; i++){
            heights[i] = r - Integer.valueOf(height[i]);
        }

        for(int i=0; i<n; i++){
            cluster = new int[r][c];
            visit = new boolean[r][c];

            // 2로 나눈 나머지 0이면 왼쪽 아니면 오른쪽에서 막대 던지기
            if(i%2==0) throwL(heights[i]);
            else throwR(heights[i]);

            // 클러스트 그룹핑
            int g = 1;
            for(int j=0; j<r; j++){
                for(int k=0; k<c; k++){
                    if(cave[j][k]=='x' && !visit[j][k]){
                        chk(k, j, g);
                        ++g;
                    }
                }
            }

            // Min값 확인 후에 0이아니면 드랍
            for(int j=--g; j>0; j--){
                int min = getMin(j);
                if(min!=0){
                    dropCluster(j, min);
                }
            }


        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < r; i++) {
            sb.append(cave[i]);
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }

    // 왼쪽에서 막대던지기
    private static void throwL(int h){
        for(int i=0; i<c; i++){
            if(cave[h][i]=='.') continue;
            else cave[h][i] = '.'; break;
        }
    }

    // 오른쪽에서 막대던지기
    private static void throwR(int h){
        for(int i=c-1; i>=0; i--){
            if(cave[h][i]=='.') continue;
            else cave[h][i] = '.'; break;
        }
    }

    private static int[] dx = new int[]{0, 1, 0, -1};
    private static int[] dy = new int[]{1, 0, -1, 0};

    // 클러스터가 분리됬는지 확인 후에 bool값 리턴
    private static void chk(int x, int y, int g){
        q = new LinkedList<>();
        q.offer(new int[]{x, y});
        cluster[y][x] = g;
        visit[y][x] = true;

        while(!q.isEmpty()){
            int[] now = q.poll();

            for(int i=0; i<4; i++){
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if(nx<0 || ny<0 || nx>=c || ny>=r) continue;
                if(visit[ny][nx]) continue;
                if(cave[ny][nx]=='.') continue;

                q.offer(new int[]{nx, ny});
                cluster[ny][nx] = g;
                visit[ny][nx] = true;
            }
        }
    }

    // 최소 드랍높이 만큼 드랍
    private static void dropCluster(int g, int min){
        for(int i=r-1; i>=0; i--){
            for(int j=0; j<c; j++){
                if(cluster[i][j]!=g) continue;

                cave[i][j] = '.';
                cave[i+min][j] = 'x';
            }
        }
    }

    // 각 요소 최대높이 비교로 최소 드랍높이 구하기
    private static int getMin(int g){
        int min = Integer.MAX_VALUE;

        for(int i=0 ;i<r; i++){
            for(int j=0; j<c; j++){
                if(cluster[i][j]!=g) continue;

                min = Math.min(getH(j, i, g), min);
            }
        }
        return min;
    }

    // 각 요소마다 최대높이 구하기
    private static int getH(int x, int y, int g){
        int tmp = 0;

        for(int i=y+1; i<r; i++){
            if(cluster[i][x]==g) return Integer.MAX_VALUE;
            if(cave[i][x]=='x') return tmp;

            tmp++;
        }
        return tmp;
    }
}