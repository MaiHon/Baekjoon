package Stack;

import java.io.*;

public class BJ1406 {
    public static void main(String args[])throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        sb.append(br.readLine());
        int point = sb.length();
        String order;
        String[] put;
        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++){
            order = br.readLine();
            switch(order){
                case "L":
                    if(point!=0){
                        point--;
                    }
                    break;

                case "D":
                    if(point<sb.length()){
                        point++;
                    }
                    break;

                case "B":
                    if(point!=0){
                        sb.deleteCharAt(point-1);
                        point--;
                    }
                    break;

                default:
                    put = order.split(" ");
                    sb.insert(point, put[1]);
                    point++;
                    break;
            }
        }
        System.out.println(sb);
    }
}