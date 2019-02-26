package SAMSUNG;

import java.util.*;
import java.io.*;

public class BJ16235 {
    static int N, M, K;
    static int[][] soil;
    static int[][] map;
    static int[][] field;
    static boolean[][] dead;
    static int[][] tree;

    static int[] dx = new int[]{1, 1, 1, 0, 0, -1, -1, -1};
    static int[] dy = new int[]{1, -1, 0, 1, -1, 1, -1, 0};


    public static void main(String args[])throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.valueOf(st.nextToken());    // map size N by N
        M = Integer.valueOf(st.nextToken());    // the number of trees
        K = Integer.valueOf(st.nextToken());    // year

        map = new int[N][N];
        field = new int[N][N];
        soil = new int[N][N];

        dead = new boolean[N*N][10001];         // row => treeIdx, col => number of tree
        tree = new int[N*N][10001];             // row => treeIdx, col => number of tree


        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                soil[i][j] = Integer.valueOf(st.nextToken());
            }
            Arrays.fill(field[i], 5);
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.valueOf(st.nextToken()) - 1;    // x
            int y = Integer.valueOf(st.nextToken()) - 1;    // y
            int z = Integer.valueOf(st.nextToken());        // size

            tree[y*N + x][map[y][x]] = z;
            map[y][x]++;
        }

        for(int i=0; i<K; i++){
            spring();
            summer();
            autumn();
            sortingTree();
            winter();

        }

        int ans = 0;
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                ans += map[i][j];
            }
        }

        System.out.println(ans);
    }

    static void winter(){
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                field[i][j] += soil[i][j];
            }
        }
    }

    static void spring(){
        for (int i=0; i <N; i++) {
            for (int j=0; j<N; j++) {
                if (map[i][j]>0) {
                    int treeN = map[i][j];
                    for (int k=0; k<treeN; k++) {
                        if (field[i][j] >= tree[i*N + j][k]) {
                            field[i][j] -= tree[i*N + j][k];
                            tree[i*N + j][k]++;
                        }
                        else {
                            dead[i*N + j][k] = true;
                        }
                    }
                }
            }
        }
    }

    static void summer(){
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(map[i][j]>0){
                    int treeN = map[i][j];
                    for(int k=0; k<treeN; k++){
                        if(dead[i*N + j][k]){
                            field[i][j] += tree[i*N + j][k] / 2;
                            dead[i*N + j][k] = false;
                            map[i][j]--;
                        }
                    }
                }
            }
        }
    }

    static void autumn(){
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(map[i][j]>0){
                    for(int k=0; k<map[i][j]; k++){
                        int treeIdx = i*N + j;
                        if(tree[treeIdx][k]%5==0){
                            for(int l=0; l<8; l++){
                                int nx = j + dx[l];
                                int ny = i + dy[l];

                                if(ny<0 || nx<0 || ny>=N || nx>=N) continue;
                                tree[ny*N + nx][map[ny][nx]] = 1;
                                map[ny][nx]++;
                            }
                        }
                    }
                }
            }
        }
    }


    static void sortingTree(){
        for(int i=0; i<N*N; i++){
            Arrays.sort(tree[i], 0, map[i/N][i%N]); // map[i][j]
        }
    }
}
