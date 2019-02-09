package Binary_Search;

import java.util.Scanner;

public class BJ2869 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        long A = sc.nextLong();
        long B = sc.nextLong();
        long V = sc.nextLong();

        long VA = V-A;
        long AB = A-B;

        long ans = 1;
        if(VA%AB!=0){
            ans += VA/AB + 1;
        }else{
            ans += VA/AB;
        }
        System.out.println(ans);
    }
}
