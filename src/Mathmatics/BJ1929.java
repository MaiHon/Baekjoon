package Mathmatics;

import java.util.*;

public class BJ1929 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int k = sc.nextInt();
        int n = sc.nextInt();

        int[] map = new int[n+1];
        for(int i=2; i<=n; i++){
            map[i] = i;
        }

        map[0] = -1;
        map[1] = -1;

        for(int i=2; i<=n; i++){
            if(map[i]==-1) continue;

            for(int j=2; i*j<=n; j++){
                    map[i*j] = -1;
            }
        }

        for(int i=k; i<=n; i++){
            if(map[i]!=-1) sb.append(map[i] + "\n");
        }
        System.out.println(sb.toString());
    }
}
