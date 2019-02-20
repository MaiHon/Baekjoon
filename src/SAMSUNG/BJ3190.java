package SAMSUNG;

import java.io.*;
import java.util.*;

public class BJ3190 {
    static int N, K, L, ans;
    static int[][] map;

    static int[] dx = new int[]{1, -1, 0, 0};
    static int[] dy = new int[]{0, 0, 1, -1};

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        map = new int[N+2][N+2];

        Arrays.fill(map[0], -1);
        for (int i=1; i<=N; i++) {
            map[i][0] = -1;
            map[i][N + 1] = -1;
        }
        Arrays.fill(map[N + 1], -1);


        K = sc.nextInt();
        for(int i=0; i<K; i++){
            map[sc.nextInt()][sc.nextInt()] = 1;
        }

        for(int[] arr: map){
            System.out.println(Arrays.toString(arr));
        }


        int[] move = new int[10001];
        L = sc.nextInt();
        for(int i=0; i<L; i++) {
            int time = sc.nextInt();
            char dir = sc.next().charAt(0);

            if (dir == 'L') {
                move[time] = 3;
            } else {
                move[time] = 1;
            }
        }

        int[] dx = new int[]{1, 0, -1, 0};
        int[] dy = new int[]{0, 1, 0, -1};

        int dir = 0;
        int tailDir = 0;
        int curX = 1;
        int curY = 1;
        int tailX = 1;
        int tailY = 1;
        int tailSec = 0;

        for(int i=1; i<10001; i++){
            boolean eat = false;
            switch (map[curY + dy[dir]][curX + dx[dir]]) {
                case -1: // walls
                    System.out.println(i);
                    return;

                case 0: //empty
                    map[curY + dy[dir]][curX + dx[dir]] = 2;
                    break;

                case 1: // apples
                    map[curY + dy[dir]][curX + dx[dir]] = 2;
                    eat = true;
                    break;

                case 2: // body
                    System.out.println(i);
                    return;
            }

            curX += dx[dir];
            curY += dy[dir];
            dir = (dir + move[i]) % 4;

            if (!eat) {
                map[tailY][tailX] = 0;
                tailX += dx[tailDir];
                tailY += dy[tailDir];
                tailDir = (tailDir + move[i - tailSec]) % 4;
            }
            else {
                tailSec++;
            }
        }
    }
}