package Implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ2290 {
    private static StringBuilder sb;

    public static void main(String args[]){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String[] line = br.readLine().trim().split(" ");
            sb = new StringBuilder();

            int s = Integer.parseInt(line[0]);
            char[] nums = line[1].toCharArray();

            printN(s, nums);
            System.out.println(sb);

        }catch (Exception e ){
            System.out.println(e.getMessage());
        }
    }

    private static void printN(int s, char[] num){
        int t = 0;
        for(int i=0; i<2*s+3; i++){
            // horizontal
            if(i==0 || i==s+1 || i==2*s+2){
                for(int j=0; j<num.length; j++){
                    sb.append(" ");
                    for(int k=0; k<s; k++){
                        sb.append(numArray[num[j]-'0'][t]);
                    }sb.append("  ");
                }sb.append("\n");
                t+=3;
            }else{
                // vertical
                if(i<s+1){
                    for(int j=0; j<num.length; j++){
                        sb.append(numArray[num[j]-'0'][1]);
                        empty(s);
                        sb.append(numArray[num[j]-'0'][2]);
                        sb.append(" ");
                    }sb.append("\n");
                }else{
                    for(int j=0; j<num.length; j++){
                        sb.append(numArray[num[j]-'0'][4]);
                        empty(s);
                        sb.append(numArray[num[j]-'0'][5]);
                        sb.append(" ");
                    }sb.append("\n");
                }
            }
        }
    }

    // for empty space between '|'s
    private static void empty(int s){
        for(int i=0; i<s; i++){
            sb.append(" ");
        }
    }

    // number array
    private static char[][] numArray = new char[][]{
            {'-', '|', '|', ' ', '|', '|', '-'},	//0
            {' ', ' ', '|', ' ', ' ', '|', ' '},	//1
            {'-', ' ', '|', '-', '|', ' ', '-'},	//2
            {'-', ' ', '|', '-', ' ', '|', '-'},	//3
            {' ', '|', '|', '-', ' ', '|', ' '},	//4
            {'-', '|', ' ', '-', ' ', '|', '-'},	//5
            {'-', '|', ' ', '-', '|', '|', '-'},	//6
            {'-', ' ', '|', ' ', ' ', '|', ' '},	//7
            {'-', '|', '|', '-', '|', '|', '-'},	//8
            {'-', '|', '|', '-', ' ', '|', '-'} 	//9
    };
}