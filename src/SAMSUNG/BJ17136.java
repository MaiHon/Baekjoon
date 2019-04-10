package SAMSUNG;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ17136 {
    private static int[][] board = new int[10][10];
    private static int[] papers = new int[]{5, 5, 5, 5, 5};

    public static void main(String args[]){
        getInput();
        dfs(0, 0, 0);

        if(isPossible) System.out.println(ans);
        else System.out.println(-1);
    }

    private static int ans = Integer.MAX_VALUE;
    private static boolean isPossible = false;
    private static void dfs(int depth, int x, int y){
        // 현재위치에서 다음 색종이로 덮어야 할 영역 찾기
        int[] tmp = isDone(y);

        // 색종이로 덮을 영역이 없고, 이전에 구한 답보다 횟수가 작을때
        if(tmp[2]==0 && ans > depth){
            isPossible = true;
            ans = depth;
            return;
        }

        x = tmp[0]; y = tmp[1];
        for(int size=5; size>=1; size--){
            if(papers[size-1]==0) continue;
            if(cover(x, y, size)) {
                // 사이즈가 적용될 수 있으면, 1인곳을 2로 다바꿈
                papers[size - 1]--;
                update(x, y, size, 2);

                dfs(depth + 1, x, y);

                // dfs끝나고 나면 2로 바꿨던 영역 1로 롤백
                papers[size - 1]++;
                update(x, y, size, 1);
            }
        }
    }

    // 다음 색종이로 덮을 영역 찾기, 엎다면 3번째 인수로 0 있다면 1 리턴
    private static int[] isDone(int y){
        int[] tmp = {0, 0, 0};
        for(int i=y; i<10; i++){
            for(int j=0; j<10; j++){
                if(board[i][j]==1) return new int[]{j, i, 1};
            }
        }
        return tmp;
    }

    // 업데이트하기
    private static void update(int x, int y, int n, int to){
        for(int i=y; i<y+n; i++){
            for(int j=x; j<x+n; j++){
                board[i][j] = to;
            }
        }
    }

    // 사이즈 n의 색종이로 해당영역 덮을 수 있는지 확인
    private static boolean cover(int x, int y, int n){
        if(y+n>10 || x+n>10) return false;

        for(int i=y; i<y+n; i++){
            for(int j=x; j<x+n; j++){
                if(board[i][j]!=1) return false;
            }
        }
        return true;
    }

    private static void getInput(){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st;

            for(int i=0; i<10; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<10; j++){
                    board[i][j] = Integer.valueOf(st.nextToken());
                }
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
