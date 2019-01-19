import java.util.Scanner;

public class BJ11727_faster {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] DP = new int[n+1];

        DP[0] = 1;
        DP[1] = 1;

        for(int i=2; i<=n; i++){
            DP[i] = (DP[i-1]+DP[i-2])%10007;
        }

        int ans = DP[n];

        System.out.println(ans);
    }
}
