import java.io.*;
import java.util.Arrays;

public class BJ1475 {
    public static void main(String args[])throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long num = Integer.parseInt(br.readLine());
        if(num==0) bw.write("1");
        else {
            int nums[] = {0, 0, 0, 0, 0, 0, 0, 0, 0};
            while (num != 0) {
                if (num % 10 == 9) nums[6]++;
                else nums[(int) num % 10]++;
                num /= 10;
            }
            if (nums[6] % 2 == 1) nums[6] = nums[6] / 2 + 1;
            else nums[6] /= 2;

            Arrays.sort(nums);

            bw.write(Integer.toString(nums[8]));
            bw.newLine();

        }
        bw.flush();
    }
}