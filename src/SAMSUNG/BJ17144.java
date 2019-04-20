package SAMSUNG;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ17144 {
    public static void main(String args[]){
        getInput();
        while(T-->0) {
            e_board = new int[R][C];
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (board[i][j] == -1 || board[i][j] == 0) continue;

                    extend(j, i);
                }
            }
            getTogether();
            purify();

//            for (int[] arr : board) {
//                System.out.println(Arrays.toString(arr));
//            }
//            System.out.println();
        }

        int ans = getAns();
        System.out.println(ans);
    }

    private static int getAns(){
        int ans = 0;
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(board[i][j]==-1) continue;

                ans += board[i][j];
            }
        }
        return ans;
    }

    // 입력값 처리
    private static int R, C, T;
    private static int[][] board;
    private static int[][] e_board;
    private static int[] purifier;
    private static void getInput(){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            R = Integer.valueOf(st.nextToken());
            C = Integer.valueOf(st.nextToken());
            T = Integer.valueOf(st.nextToken());

            board = new int[R][C];
            e_board = new int[R][C];
            purifier = new int[2];

            // k는 공기청정기 y좌표 저장위해서
            int k = 0;
            for(int i=0; i<R; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<C; j++){
                    board[i][j] = Integer.valueOf(st.nextToken());
                    if(board[i][j]==-1){
                        purifier[k] = i;
                        k++;
                    }
                }
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    // 미세먼지 확장
    private static int[] dx = new int[]{1, 0, -1, 0};
    private static int[] dy = new int[]{0, 1, 0, -1};
    private static void extend(int x, int y){
        int cnt = 0;
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx<0||nx>=C||ny<0||ny>=R) continue;
            if(board[ny][nx]==-1) continue;

            e_board[ny][nx] += board[y][x]/5;
            cnt++;
        }

        board[y][x] -= board[y][x]/5*cnt;
    }

    // 미세먼지 확장 후 값 더해주기
    private static void getTogether(){
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(board[i][j]==-1) continue;

                board[i][j] += e_board[i][j];
            }
        }
    }

    private static void purify(){
        int p1 = purifier[0];
        int p2 = purifier[1];

        // 왼쪽 끝 부분 처리
        for(int i=p1-2; i>=0; i--){
            board[i+1][0] = board[i][0];
        }

        for(int i=p2+2; i<R; i++){
            board[i-1][0] = board[i][0];
        }

        // 맨 윗 부분 처리
        for(int i=1; i<C; i++){
            board[0][i-1] = board[0][i];
        }

        // 맨 아랫 부분 처리
        for(int i=1; i<C; i++){
            board[R-1][i-1] = board[R-1][i];
        }

        // 오른쪽 끝 부분 처리
        for(int i=1; i<=p1; i++){
            board[i-1][C-1] = board[i][C-1];
        }
        for(int i=R-2; i>=p2; i--){
            board[i+1][C-1] = board[i][C-1];
        }

        // 공기청정기 나오는 부분 처리
        for(int i=C-2; i>0; i--){
            board[p1][i+1] = board[p1][i];
        }
        board[p1][1] = 0;

        for(int i=C-2; i>0; i--){
            board[p2][i+1] = board[p2][i];
        }
        board[p2][1] = 0;
    }
}
