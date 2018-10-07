import java.io.*;

public class BJ2920_EasyWay {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String ascending = "1 2 3 4 5 6 7 8";
		String descending = "8 7 6 5 4 3 2 1";
		
		String example = br.readLine();
		if(example.equals(ascending)) bw.write("ascending");
		else if(example.equals(descending)) bw.write("descending");
		else bw.write("mixed");
		
		
		bw.flush();
	}
}
