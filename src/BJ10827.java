import java.util.*;
import java.math.*;

public class BJ10827 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        BigDecimal a;
        int b;

        a = sc.nextBigDecimal();
        b = sc.nextInt();
        BigDecimal c = a.pow(b);

        // System.out.println(a.pow(b)); -> to recall toString() method.
        System.out.println(c.toPlainString()); // for more certain value, using toPlainString()


    }
}
