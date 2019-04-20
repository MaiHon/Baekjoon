package SAMSUNG;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ17143 {
    public static void main(String args[]){
        getInput();
        hunting();
    }

    // 사냥 후에 모든 상어 움직임
    private static int[] dx = new int[]{0, 1, 0, -1};
    private static int[] dy = new int[]{-1, 0, 1, 0};
    private static int movement = 0;
    private static void sharkMove(){
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(board[i][j].isEmpty()) continue;

                Shark ns = (Shark)board[i][j].get(0);
                if(ns.m!=movement) continue;

                int move = ns.s;
                int dir = ns.d;
                int size = ns.z;

                int nx=j, ny=i, ndir=dir;

                while(ns.s>0){
                    nx += dx[ndir];
                    ny += dy[ndir];

                    if(nx<0 || nx>=C || ny<0 || ny>=R){
                        ndir = (ndir+2)%4;
                        ns.s++;
                    }else ns.s--;
                }
                board[i][j].remove(0);
                board[ny][nx].add(new Shark(move, ndir, size, ns.m+1));
            }
        }
        movement++;
    }

    // 사람에서 가장 가까운 상어 사냥
    private static int cnt = 0;
    private static void getCloest(int position){
        for(int i=0; i<R; i++){
            if(board[i][position].isEmpty()) continue;

            Shark ns = (Shark)board[i][position].get(0);
            cnt += ns.z;
            board[i][position].remove(0);
            break;
        }
    }

    // 상어가 다 움직이고 나서, 여러개의 상어가 한칸에 존재하면
    // 상어 중에 가장 큰놈만 살아남기
    private static void getTogether(){
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(board[i][j].isEmpty()) continue;
                if(board[i][j].size()==1) continue;

                int max = 0;
                int speed = 0;
                int dir = 0;
                int movement = 0;

                for(int k=0; k<board[i][j].size(); k++){
                    Shark shark = (Shark)board[i][j].get(k);

                    if(max<shark.z){
                        max = shark.z;
                        dir = shark.d;
                        speed = shark.s;
                        movement = shark.m;
                    }
                }

                board[i][j] = new ArrayList();
                board[i][j].add(new Shark(speed, dir, max, movement));
            }
        }
    }

    // 사냥하고 끝나면 ans출력
    private static void hunting(){
        int position = 0;

        while(position<C){
            getCloest(position);
            sharkMove();
            getTogether();
            position++;
        }

        System.out.println(cnt);
    }

    // 인풋처리
    // 상어가 같은칸에 겹치는 경우를 생각해서 어레이리스트로 만들기
    private static int R, C, M;
    private static ArrayList[][] board;
    private static class Shark{
        int s, d, z, m;

        Shark(int s, int d, int z, int m){
            this.s = s;
            this.d = d;
            this.z = z;
            this.m = m;
        }
    }


    private static void getInput(){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            R = Integer.valueOf(st.nextToken());
            C = Integer.valueOf(st.nextToken());
            M = Integer.valueOf(st.nextToken());

            board = new ArrayList[R][C];
            for(int i=0; i<R; i++){
                for(int j=0; j<C; j++){
                    board[i][j] = new ArrayList<Shark>();
                }
            }

            for(int i=0; i<M; i++){
                st = new StringTokenizer(br.readLine());

                int r = Integer.valueOf(st.nextToken()) - 1;
                int c = Integer.valueOf(st.nextToken()) - 1;
                int s = Integer.valueOf(st.nextToken());
                int d = Integer.valueOf(st.nextToken()) - 1;
                int z = Integer.valueOf(st.nextToken());

                if(d==1) d = 2;
                else if(d==2) d = 1;

                Shark shark = new Shark(s, d, z, 0);
                board[r][c].add(shark);
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}


