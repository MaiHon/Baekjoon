package Mathmatics;

        import java.math.BigInteger;
        import java.util.Scanner;

public class BJ2407 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        BigInteger[][] map = new BigInteger[n+1][m+1];
        for(int i=0; i<=n; i++){
            for(int j=0; j<=Math.min(m, i); j++){
                if(j==0 || j==i) map[i][j] = BigInteger.ONE;
                else{
                    map[i][j] = map[i-1][j].add(map[i-1][j-1]);
                }
            }
        }

        System.out.println(map[n][m]);
    }
}
