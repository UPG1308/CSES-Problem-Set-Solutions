import java.util.*;
import java.io.*;


public class TwoSets{
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
            int testCases = 1; //in.nextInt();
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
      	long n = in.nextInt();

        long totalSum = (n)*(n + 1) /2;
        if(totalSum % 2 != 0){
          out.println("NO");
          return ;
        }
        ArrayList<Long> list1 = new ArrayList<>();
        ArrayList<Long> list2 = new ArrayList<>();
        boolean flag = true;
        if(n % 2 == 1){
          list2.add(n);
          n--;
        }
        long k = 1, l = n;
        while(k < l){
          if(flag){
            list1.add(k);
            list1.add(l);
          }
          else {
            list2.add(k);
            list2.add(l);
          }
          flag = !flag;
          k++;l--;
        }
        
        out.println("YES");
        out.println(list1.size());
        for(long i: list1)out.print(i +" ");
        out.println("");
        out.println(list2.size());
        for(long i: list2)out.print(i +" ");
        
    }
}
