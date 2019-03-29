package Implementation;

import java.util.Scanner;

public class BJ2490 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        for(int i=0; i<3; i++){
            int[] cnt = new int[2];
            for(int j=0; j<4; j++){
                int n = sc.nextInt();
                if(n==0) cnt[0]++;
                if(n==1) cnt[1]++;
            }
            if(cnt[0]==1) System.out.println("A");
            else if(cnt[1]==1) System.out.println("C");
            else if(cnt[0]==4) System.out.println("D");
            else if(cnt[1]==4) System.out.println("E");
            else System.out.println("B");
        }
    }
}
