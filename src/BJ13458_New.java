import java.io.*;

public class BJ13458_New {
    static int cnt;
    static int fir;
    static int sec;

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int roomNum = Integer.parseInt(br.readLine());
        String students[] = br.readLine().split(" ");
        String teacher[]= br.readLine().split(" ");

        fir = Integer.parseInt(teacher[0]);
        sec = Integer.parseInt(teacher[1]);

        long ans = 0;
        for(int i=0; i<students.length; i++){
            int student = Integer.parseInt(students[i]);
            ans += teacherNum(student);

        }
        bw.write(ans + "\n");
        bw.flush();
    }

    static int teacherNum(int student){
        cnt=0;
        if(student <= fir){
            return 1;
        }
        else{
            cnt++;
            student -= fir;
            cnt += student/sec;
            if(student%sec!=0){
                cnt++;
            }
            return cnt;
        }
    }
}



// Too slow, it takes 5seconds for solving....
// Faster way is required.