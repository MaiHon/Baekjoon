package SAMSUNG;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ12100 {
    static int N, ans;
    static int[][] board;

    static Queue<Integer> q = new LinkedList<>();

    public static void main(String args[])throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.valueOf(st.nextToken());
        board = new int[N][N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                board[i][j] = Integer.valueOf(st.nextToken());
            }
        }

        dfs(board, 0);
        System.out.println(ans);
    }

    static void dfs(int[][] board, int cnt){
        int[][] copy = new int[N][N];

        if(cnt==5){
            int tmp = 0;
            for (int i=0; i<N; i++) {
                for (int j=0; j<N; j++) {
                    tmp = Math.max(tmp, board[i][j]);
                }
            }
            ans = Math.max(ans, tmp);
            return;

        }

        for(int i=0; i<4; i++){
            boolean[][] visited = new boolean[N][N];
            for(int k=0; k<N; k++){
                for(int j=0; j<N; j++){
                    copy[k][j] = board[k][j];
                }
            }

            switch (i){
                case 0:
                    for(int j=0; j<N; j++){
                        for(int k=1; k<N; k++){
                            if(copy[k][j]==0) continue;
                            int num = copy[k][j];

                            for(int l=k-1; l>=0; l--){
                                if(copy[l][j]==0) continue;
                                if(copy[l][j]!=num || visited[l][j]) break;

                                copy[l][j] *= 2;
                                visited[l][j] = true;
                                copy[k][j] = 0;
                                break;
                            }
                        }
                    }

                    for(int j=0; j<N; j++){
                        for(int k=0; k<N; k++){
                            if(copy[k][j]==0) continue;
                            q.offer(copy[k][j]);
                            copy[k][j] = 0;
                        }
                        int index = 0;
                        while(!q.isEmpty()) copy[index++][j] = q.poll();
                    }

                    dfs(copy, cnt+1);
                    break;

                case 1:
                    for(int j=0; j<N; j++){
                        for(int k=N-2; k>=0; k--){
                            if(copy[k][j]==0) continue;
                            int num = copy[k][j];

                            for(int l=k+1; l<N; l++){
                                if(copy[l][j]==0) continue;
                                if(copy[l][j]!=num || visited[l][j]) break;

                                copy[l][j] *= 2;
                                visited[l][j] = true;
                                copy[k][j] = 0;
                                break;
                            }
                        }
                    }

                    for(int j=0; j<N; j++){
                        for(int k=N-1; k>=0; k--){
                            if(copy[k][j]==0) continue;
                            q.offer(copy[k][j]);
                            copy[k][j] = 0;
                        }
                        int index = N-1;
                        while(!q.isEmpty()) copy[index--][j] = q.poll();
                    }

                    dfs(copy, cnt+1);
                    break;

                case 2:
                    for(int k=0; k<N; k++){
                        for(int j=1; j<N; j++){
                            if(copy[k][j]==0) continue;
                            int num = copy[k][j];

                            for(int l=j-1; l>=0; l--){
                                if(copy[k][l]==0) continue;
                                if(copy[k][l]!=num || visited[k][l]) break;

                                copy[k][l] *= 2;
                                visited[k][l] = true;
                                copy[k][j] = 0;
                                break;
                            }
                        }
                    }

                    for(int k=0; k<N; k++){
                        for(int j=0; j<N; j++){
                            if(copy[k][j]==0) continue;
                            q.offer(copy[k][j]);
                            copy[k][j] = 0;
                        }
                        int index = 0;
                        while(!q.isEmpty()) copy[k][index++] = q.poll();
                    }

                    dfs(copy, cnt+1);
                    break;

                case 3:
                    for(int k=0; k<N; k++){
                        for(int j=N-2; j>=0; j--){
                            if(copy[k][j]==0) continue;
                            int num = copy[k][j];

                            for(int l=j+1; l<N; l++){
                                if(copy[k][l]==0) continue;
                                if(copy[k][l]!=num || visited[k][l]) break;

                                copy[k][l] *= 2;
                                visited[k][l] = true;
                                copy[k][j] = 0;
                                break;
                            }
                        }
                    }

                    for(int k=0; k<N; k++){
                        for(int j=N-1; j>=0; j--){
                            if(copy[k][j]==0) continue;
                            q.offer(copy[k][j]);
                            copy[k][j] = 0;
                        }
                        int index = N-1;
                        while(!q.isEmpty()) copy[k][index--] = q.poll();
                    }
                    dfs(copy, cnt+1);
                    break;
            }
        }
    }
}
