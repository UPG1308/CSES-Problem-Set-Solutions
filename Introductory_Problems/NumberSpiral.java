
import java.util.*;
import java.io.*;


public class NumberSpiral{
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
            int testCases=in.nextInt();
            while(testCases-- > 0){
                solve(in , out);
                // int n = 10;
                // int m = 10;
                
                // char grid[][] = new char[n][m];
                // for(int i = 0; i < n; i++){
                //   String[] s = in.nextLine().trim().split("");
                //   // for(int j = 0; j < m; j++)out.print(grid[i][j] +" ");
                //   for(int j = 0; j < m; j++){
                //     // out.print(s[j]+" ");
                //     grid[i][j] = s[j].charAt(0); //Integer.parseInt(s[j]);
                //   }
                // }
               
                

            }
            out.close();
        } catch (Exception e) {
            return;
        }
    }
    
    public static void solve(FastReader in, FastWriter out) throws IOException {
      	long row = in.nextInt();
        long col = in.nextInt();

        long max = Math.max(row, col);
        long diagonal = (max * max ) - (max - 1);
        long difference =Math.abs(row - col);
        long val = diagonal;


        if(row > col){
            val += (row %  2 == 0)? difference: -difference;
        }
        else if(col > row) {
            val += (col %  2 != 0)? difference: -difference;
        }

        out.println(val);
    }
}
