import java.util.*;
import java.io.*;


public class TwoKnight{
    static class FastReader{
        BufferedReader br;
        StringTokenizer st;
        public FastReader(){
            br=new BufferedReader(new InputStreamReader(System.in));
        }
        String next(){
            while(st==null || !st.hasMoreTokens()){
                try {
                    st=new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        int nextInt(){
            return Integer.parseInt(next());
        }
        long nextLong(){
            return Long.parseLong(next());
        }
        double nextDouble(){
            return Double.parseDouble(next());
        }
        String nextLine(){
            String str="";
            try {
                str=br.readLine().trim();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return str;
        }
    }
    static class FastWriter {
		private final BufferedWriter bw;

		public FastWriter() {
			this.bw = new BufferedWriter(new OutputStreamWriter(System.out));
		}

		public void print(Object object) throws IOException {
			bw.append("" + object);
		}

		public void println(Object object) throws IOException {
			print(object);
			bw.append("\n");
		}

		public void close() throws IOException {
			bw.close();
		}
	}
	
	
    public static void main(String[] args) {
        try {
            FastReader in=new FastReader();
            FastWriter out = new FastWriter();
            int testCases = 1;
            while(testCases-- > 0){
                solve(in , out);
            }
            out.close();
        } catch (Exception e) {
            return;
        }
    }
    public static long ncr(int n, int r){
        long sum = 1;

        // Calculate the value of n choose r using the
        // binomial coefficient formula
        for (int i = 1; i <= r; i++) {
            sum = sum * (n - r + i) / i;
        }
        return sum;
    }
    public static void solve(FastReader in, FastWriter out) throws IOException {
      	int n = in.nextInt();
        for(int i = 1; i <= n; i++){
            long totalWays = ncr(i * i,2); // Total ways we can place 2 knights are (n^2)*(n^2 - 1)/ 2;
            long totalAttacks = 4 *(i - 1)*(i - 2); // attacks happens in 3x2 and 2x3 matrix forms. So we need to calculate
            //total number of 3x2 and 2x3 matrices in the grid ==> (n - 2)*(n - 1) and (n - 1)*(n - 2)
            // (n - 2)*(n - 1) + (n - 1)*(n - 2) = 2 * (n - 1)*(n - 2)
            // and in each rectangle 2x3 and 3x2 grids we can place knights 2 ways ==> 2 * 2 * (n - 1)*(n - 2)
            //youtube link ---- https://youtu.be/uHAGgpa2qwA?si=VEqA54la-h1ICQsp
            out.println(totalWays - totalAttacks);
        }
    }
}
