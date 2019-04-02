package Brute_Force;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class BJ16179 {
    private static int N, M, ans;
    private static char[][] map;
    private static LinkedList<Node> q;

    public static void main(String args[]){
        getInput();

        // 코인은 항상 2개 -> first & second
        Node first = q.poll();
        Node second = q.poll();


        ans = Integer.MAX_VALUE;
        dfs(0, first.x, first.y, second.x, second.y);
        if(ans!=Integer.MAX_VALUE) System.out.println(ans);
        else System.out.println(-1);
    }

    // 입력받기
    private static void getInput(){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String[] nam = br.readLine().split(" ");

            N = Integer.valueOf(nam[0]);
            M = Integer.valueOf(nam[1]);

            map = new char[N][M];
            q = new LinkedList<>();

            // 코인이 있는자리는 q에 추가해주기
            for(int i=0; i<N; i++){
                char[] comp = br.readLine().toCharArray();
                for(int j=0; j<M; j++){
                    map[i][j] = comp[j];
                    if(comp[j]=='o') {
                        q.offer(new Node(j, i)); // x, y, coin
                    }
                }
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

    private static int[] dx = new int[]{1, 0, -1, 0};
    private static int[] dy = new int[]{0, 1, 0, -1};

    private static void dfs(int cnt, int x1, int y1, int x2, int y2){
        // DFS -> 4방향 코인이동
        for(int i=0; i<4; i++){
            int nx1 = x1 + dx[i]; int ny1 = y1 + dy[i];
            int nx2 = x2 + dx[i]; int ny2 = y2 + dy[i];

            // 불가능한 경우들

            if(cnt>=10) return; // 만약 이동횟수가 10회 이상이면 리턴

            if(cnt>ans) return; // 구했던 답보다 횟수가 크면 리턴

            if(isFallen(nx1, ny1) && isFallen(nx2, ny2)){ // 두 개의 코인 모두 떨어질 경우 다른방향으로 바로 continue
                continue;
            }

            // 가능한 경우들(코인 한 개만 떨어진 경우)
            if(isFallen(nx1, ny1) && !isFallen(nx2, ny2)){
                // 구했던 값과 비교해서 작은거 고르기
                ans = Math.min(ans, cnt+1);
                return;
            }

            if(!isFallen(nx1, ny1) && isFallen(nx2, ny2)){
                // 구했던 값과 비교해서 작은거 고르기
                ans = Math.min(ans, cnt+1);
                return;
            }

            // 두 개의 코인이 모두 떨어지지 않았을 경우
            // 각각의 경우 벽을 만나면 제자리 유지
            if(map[ny1][nx1] == '#'){
                nx1 = x1;
                ny1 = y1;
            }
            if(map[ny2][nx2] == '#'){
                nx2 = x2;
                ny2 = y2;
            }

            dfs(cnt+1, nx1, ny1, nx2, ny2);
        }
    }

    private static boolean isFallen(int x, int y){
        return (x<0 || y<0 || x>=M || y>=N);
    }

    private static class Node{
        int x;
        int y;


        Node(int x, int y){
            this.x = x;
            this.y = y;

        }
    }
}