package SAMSUNG;

import java.io.*;
import java.util.*;

public class BJ5373 {
    static char[][] cube;
    static StringBuilder sb;
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        sb = new StringBuilder();

        int tCase = sc.nextInt();

        while(tCase-->0){
            int turn = sc.nextInt();
            cube = new char[][]{
                    {'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w'},  // U
                    {'r', 'r', 'r', 'r', 'r', 'r', 'r', 'r', 'r'},  // F
                    {'y', 'y', 'y', 'y', 'y', 'y', 'y', 'y', 'y'},  // D
                    {'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o'},  // B
                    {'g', 'g', 'g', 'g', 'g', 'g', 'g', 'g', 'g'},  // L
                    {'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'}}; // R

            for(int i=0; i<turn; i++){
                char order[] = sc.next().toCharArray();
                char asp = order[0];
                char way = order[1];

               rotate(asp, way);
               selfRotate(asp, way);
            }

            for(int i=1; i<=9; i++){
                if(i%3==0) sb.append(cube[0][i-1] + "\n");
                else sb.append(cube[0][i-1]);
            }
        }
        System.out.println(sb);
    }

    static void rotate(char aspect, char way){
        char tmp;
        switch (aspect){
            case 'L':
                switch (way){
                    case '+':
                        for(int i=0; i<3; i++){
                            tmp = cube[0][i*3];
                            cube[0][i*3] = cube[3][i*3]; // B => U
                            cube[3][i*3] = cube[2][i*3]; // D => B
                            cube[2][i*3] = cube[1][i*3]; // F => D
                            cube[1][i*3] = tmp;          // U => F
                        }
                        break;

                    case '-':
                        for(int i=0; i<3; i++){
                            tmp = cube[0][i*3];
                            cube[0][i*3] = cube[1][i*3]; // F => U
                            cube[1][i*3] = cube[2][i*3]; // D => F
                            cube[2][i*3] = cube[3][i*3]; // B => D
                            cube[3][i*3] = tmp;          // U => B
                        }
                        break;
                }

                break;
            case 'R':
                switch (way){
                    case '+':
                        for(int i=0; i<3; i++){
                            tmp = cube[0][2+i*3];
                            cube[0][2+i*3] = cube[1][2+i*3]; // F => U
                            cube[1][2+i*3] = cube[2][2+i*3]; // D => F
                            cube[2][2+i*3] = cube[3][2+i*3]; // B => D
                            cube[3][2+i*3] = tmp;            // U => B
                        }
                        break;

                    case '-':
                        for(int i=0; i<3; i++){
                            tmp = cube[0][2+i*3];
                            cube[0][2+i*3] = cube[3][2+i*3]; // B => U
                            cube[3][2+i*3] = cube[2][2+i*3]; // D => B
                            cube[2][2+i*3] = cube[1][2+i*3]; // F => D
                            cube[1][2+i*3] = tmp;            // U => F
                        }
                        break;
                }

                break;
            case 'F':
                switch (way){
                    case '+':
                        for(int i=0; i<3; i++){
                            tmp = cube[0][6+i];
                            cube[0][6+i] = cube[4][6+i];   // L => U
                            cube[4][6+i] = cube[2][2-i];   // D => L
                            cube[2][2-i] = cube[5][6+i];   // R => D
                            cube[5][6+i] = tmp;            // U => R
                        }
                        break;

                    case '-':
                        for(int i=0; i<3; i++){
                            tmp = cube[0][6+i];
                            cube[0][6+i] = cube[5][6+i];    // R => U
                            cube[5][6+i] = cube[2][2-i];    // D => R
                            cube[2][2-i] = cube[4][6+i];    // R => D
                            cube[4][6+i] = tmp;             // U => R
                        }
                        break;
                }

                break;
            case 'B':
                switch (way){
                    case '+':
                        for(int i=0; i<3; i++){
                            tmp = cube[0][i];
                            cube[0][i] = cube[5][i];    // R => U
                            cube[5][i] = cube[2][8-i];  // D => R
                            cube[2][8-i] = cube[4][i];  // L => D
                            cube[4][i] = tmp;    // U => L
                        }
                        break;
                    case '-':
                        for(int i=0; i<3; i++){
                            tmp = cube[0][i];
                            cube[0][i] = cube[4][i];    // L => U
                            cube[4][i] = cube[2][8-i];  // D => L
                            cube[2][8-i] = cube[5][i];  // R => D
                            cube[5][i] = tmp;    // U => R
                        }
                        break;
                }

                break;
            case 'U':
                switch (way){
                    case '+':
                        for(int i=0; i<3; i++){
                            tmp = cube[1][i];
                            cube[1][i] = cube[5][6-3*i];    // R => F
                            cube[5][6-3*i] = cube[3][8-i];  // B => R
                            cube[3][8-i] = cube[4][2+3*i];  // L => B
                            cube[4][2+3*i] = tmp;           // F => L
                        }
                        break;
                    case '-':
                        for(int i=0; i<3; i++){
                            tmp = cube[1][i];
                            cube[1][i] = cube[4][2+3*i];    // L => F
                            cube[4][2+3*i] = cube[3][8-i];  // B => L
                            cube[3][8-i] = cube[5][6-3*i];  // L => F
                            cube[5][6-3*i] = tmp;           // F => R
                        }
                        break;
                }

                break;
            case 'D':
                switch (way){
                    case '+':
                        for(int i=0; i<3; i++){
                            tmp = cube[1][6+i];
                            cube[1][6+i] = cube[4][i*3];    // L => F
                            cube[4][i*3] = cube[3][2-i];    // B => L
                            cube[3][2-i] = cube[5][8-i*3];  // R => B
                            cube[5][8-i*3] = tmp;           // F => R
                        }
                        break;
                    case '-':
                        for(int i=0; i<3; i++){
                            tmp = cube[1][6+i];
                            cube[1][6+i] = cube[5][8-i*3];    // L => F
                            cube[5][8-i*3] = cube[3][2-i];    // B => L
                            cube[3][2-i] = cube[4][i*3];      // R => B
                            cube[4][i*3] = tmp;               // F => R
                        }
                        break;
                }
                break;
        }
    }

    static void selfRotate(char asp, char way){
        int i=0;
        char tmp;


        switch (asp){
            case 'U':
                i = 0;
                break;
            case 'F':
                i = 1;
                break;
            case 'D':
                i = 2;
                break;
            case 'B':
                i =3;
                break;
            case 'L':
                i = 4;
                break;
            case 'R':
                i = 5;
                break;
        }

        switch (way){
            case '-':
                tmp = cube[i][0];
                cube[i][0] = cube[i][2];
                cube[i][2] = cube[i][8];
                cube[i][8] = cube[i][6];
                cube[i][6] = tmp;

                tmp = cube[i][1];
                cube[i][1] = cube[i][5];
                cube[i][5] = cube[i][7];
                cube[i][7] = cube[i][3];
                cube[i][3] = tmp;
                break;

            case '+':
                tmp = cube[i][0];
                cube[i][0] = cube[i][6];
                cube[i][6] = cube[i][8];
                cube[i][8] = cube[i][2];
                cube[i][2] = tmp;

                tmp = cube[i][1];
                cube[i][1] = cube[i][3];
                cube[i][3] = cube[i][7];
                cube[i][7] = cube[i][5];
                cube[i][5] = tmp;
                break;
        }
    }
}
