package SAMSUNG;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ17135 {
    public static void main(String args[]){
        getInput();
        start();
        System.out.println(ans);
    }

    private static int N, M, D;
    private static int[][] board;
    private static boolean[][] count;

    // 인풋 처리
    private static void getInput(){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.valueOf(st.nextToken());
            M = Integer.valueOf(st.nextToken());
            D = Integer.valueOf(st.nextToken());

            board = new int[N+1][M];
            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<M; j++){
                    board[i][j] = Integer.valueOf(st.nextToken());
                }
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    // 현재 궁수위치 x에서 가장 가까운 적 찾기
    private static void getClose(int x, int[][] board){
        int tmpX = Integer.MAX_VALUE;
        int tmpY = 0;
        boolean found = false;

        // 궁수로부터 거리
        for(int k=1; k<=D; k++){
            // 궁수로부터 y축 거리
            for(int i=1; i<=k; i++){
                if(N-i<0) continue;

                for(int l=1; l<=2; l++) {
                    int j = x;
                    switch (l) {
                        case 1:
                            j -= (k - i);
                            break;
                        case 2:
                            j += (k - i);
                            break;
                    }

                    if(j<0 || j>=M) continue;
                    if(board[N-i][j]!=1) continue;

                    // 적 찾아도 제일 왼쪽의 적 구하기 위해서 i문 다 돌아주기
                    if(j<=tmpX){
                        found = true;
                        tmpX = j;
                        tmpY = N-i;
                    }
                }
            }
            // 사정거리안에 적이 발견됬으면 적 쏘기
            if(found){
                count[tmpY][tmpX] = true;
                return;
            }
        }
    }

    // 화살 맞은 적 죽이고, 적 한칸씩 밑으로 이동
    private static int cnt = 0;
    private static void update(int[][] board){
        for(int i=N-1; i>=0; i--){
            for(int j=0; j<M; j++){
                if(board[i][j]!=1) continue;
                if(count[i][j]) {
                    cnt++;
                    board[i][j] = 0;
                    count[i][j] = false;
                    continue;
                }

                board[i][j] = 0;
                if(i+1<N) board[i+1][j] = 1;
            }
        }
    }

    // 궁수포메이션 조합짜고 각 조합마다 실행시켜서 max값 찾아내기
    private static int ans;
    private static void start(){
        ans = 0;
        int[][] copy = new int[N][M];
        count = new boolean[N][M];

        for(int i=0; i<M; i++){
            for(int j=i+1; j<M; j++){
                for(int k=j+1; k<M; k++){
                    setZero(copy);
                    setFalse(count);
                    copyArr(board, copy);

                    cnt = 0;
//                    System.out.println(i + " " + j + " " + k);
                    run(i, j, k, copy);
                    ans = Math.max(ans, cnt);
//                    System.out.println(ans);
                }
            }
        }
    }

    // 현재 포메이션에서의 최대 죽일수 있는 적 구하기
    private static void run(int i, int j, int k, int[][] board){
        while(true){
            getClose(i, board);
            getClose(j, board);
            getClose(k, board);

            update(board);
//            for(int[] arr : board){
//                System.out.println(Arrays.toString(arr));
//            }System.out.println(cnt);

            if(isEmpty(board)) break;
        }
    }

    // 적이 모두 사라졌는지 체크하기
    private static boolean isEmpty(int[][] board){
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(board[i][j]!=1) continue;

                return false;
            }
        }
        return true;
    }

    private static void copyArr(int[][] from, int[][] to){
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                to[i][j] = from[i][j];
            }
        }
    }

    private static void setZero(int[][] arr){
        for(int i=0; i<N; i++){
            Arrays.fill(arr[i], 0);
        }
    }

    private static void setFalse(boolean[][] arr){
        for(int i=0; i<N; i++){
            Arrays.fill(arr[i], false);
        }
    }
}