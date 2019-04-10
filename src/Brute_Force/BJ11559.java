package Brute_Force;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class BJ11559 {
    private static char[][] board = new char[12][6];
    private static boolean[][] visit;

    public static void main(String args[]){
        getInput();

        boolean found;
        int cnt = 0;

        while(true){
            boolean allClear = true;
            visit = new boolean[12][6];

            for(int i=11; i>=0; i--){
                for(int j=0; j<6; j++){
                    if(board[i][j]=='.') continue;
                    if(visit[i][j]) continue;;

                    found = chkBoom(j, i, board[i][j]);

                    // 만약 카운트 갯수가 4를 넘지 않으면 reboom함수로 체크 풀어주기
                    if(!found) reBoom(j, i, board[i][j]);
                    else allClear = false;
                    // 한번이라도 4개를 넘으면 allClear에 false값 넘겨서 계속 처리하기
                }
            }

            if(allClear) break;
            else {
                // 전부 터드리지 않은 경우 update로 터트리기
                cnt++;
                update();
            }
        }
        System.out.println(cnt);
    }

    // input값 처리
    private static void getInput(){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            for(int i=0; i<12; i++){
                char[] boards = br.readLine().toCharArray();
                for(int j=0; j<6; j++){
                    board[i][j] = boards[j];
                }
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    private static int[] dx = new int[]{1, 0, -1, 0};
    private static int[] dy = new int[]{0, 1, 0, -1};

    // 카운트 갯수가 4개가 넘으면 true값 넘기기
    private static boolean chkBoom(int x, int y, char color){
        LinkedList<int[]> q = new LinkedList<>();

        q.offer(new int[]{x, y});
        visit[y][x] = true;

        int cnt = 1;
        while(!q.isEmpty()){
            int[] now = q.poll();

            for(int i=0; i<4; i++){
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if(ny<0 || ny>=12 || nx<0 || nx>=6) continue;
                if(visit[ny][nx]) continue;
                if(board[ny][nx]!=color) continue;

                cnt++;
                visit[ny][nx] = true;
                q.offer(new int[]{nx, ny});
            }
        }
        return cnt>=4;
    }

    // visit한 부분 체크 풀어주기
    private static void reBoom(int x, int y, char color){
        LinkedList<int[]> q = new LinkedList<>();

        q.offer(new int[]{x, y});
        visit[y][x] = false;

        while(!q.isEmpty()){
            int[] now = q.poll();

            for(int i=0; i<4; i++){
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if(ny<0 || ny>=12 || nx<0 || nx>=6) continue;
                if(!visit[ny][nx]) continue;
                if(board[ny][nx]!=color) continue;

                visit[ny][nx] = false;
                q.offer(new int[]{nx, ny});
            }
        }
    }

    // visit체크 된곳 전부 폭팔
    private static void update(){
        for(int i=11; i>=0; i--){
            for(int j=0; j<6; j++){
                if(!visit[i][j]) continue;

                board[i][j] = '.';
            }
        }

        for(int i=11; i>=0; i--){
            for(int j=0; j<6; j++){
                if(visit[i][j]) continue;

                drop(j, i, board[i][j]);
            }
        }
    }

    // 떨어질 수 있는 최대 높이 계산 -> 떨어뜨리기
    private static void drop(int x,int y, char color){
        int height = 0;
        for(int i=y+1; i<12; i++){
            if(board[i][x]!='.') break;

            height++;
        }

        board[y][x] = '.';
        board[y+height][x] = color;
    }
}