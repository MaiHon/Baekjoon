package Implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ3568 {
    private static class Char implements Comparable<Char>{
        char x;
        int val;

        Char(char x, int i){
            this.x = x;

            if(x=='&') this.val = i+200;
            else if(x=='[') this.val = i+201;
            else if(x==']') this.val = i+199;
            else if(x=='*') this.val = i+200;
            else this.val = 120-i;
        }

        public int compareTo(Char c){
            return this.val-c.val > 0 ? -1:1;
        }

    }
    public static void main(String args[]){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();
            StringTokenizer st = new StringTokenizer(br.readLine());

            String declare = st.nextToken();
            array = new PriorityQueue<>();
            while(st.hasMoreTokens()){
                sb.append(declare);

                String variable = st.nextToken();
                variable = variable.substring(0, variable.length()-1);

                toChar(variable);
                boolean space = false;

                while(!array.isEmpty()){
                    Char now = array.poll();

                    if(now.x!='&' && now.x!='*' && now.x!='[' && now.x!=']' && !space) {
                        sb.append(" ");
                        sb.append(now.x);
                        space = true;
                    }else{
                        sb.append(now.x);
                    }
                }sb.append(";\n");
            }
            System.out.println(sb);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    private static PriorityQueue<Char> array;
    private static void toChar(String str){

        for(int i=0; i<str.length(); i++){
            array.add(new Char(str.charAt(i), i));
        }
    }
}
