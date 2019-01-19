import java.math.BigInteger;
import java.util.*;

public class BJ11726 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        BigInteger[] DP = new BigInteger[n+1];

        DP[0] = BigInteger.ONE;
        DP[1] = BigInteger.ONE;

        for(int i=2; i<=n; i++){
            DP[i] = DP[i-1].add(DP[i-2]);
        }

        BigInteger d = new BigInteger("10007");
        BigInteger ans = DP[n].remainder(d);

        System.out.println(ans);
    }
}
