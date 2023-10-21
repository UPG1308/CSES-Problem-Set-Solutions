import java.util.*;
import java.io.*;
 
 
public class Main{
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
            int testCases = 1;// in.nextInt();
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
    public static int power(int x, int n, int p) {
        
        for(int i = 0;i < n; i++){
          x = (x * 2) % p;
        }
        return x % p;
    }
    public static void solve(FastReader in, FastWriter out) throws IOException {
      // 	int n = in.nextInt();
      // 	int mod = 1000_000_007;
      // 	int[] dice = {1,2,3,4,5,6};
      // 	int [][]dp = new int[6][n + 1];
      // 	for(int[] i: dp)Arrays.fill(i, -1);
      // 	out.println(helper(dice.length - 1, n, dice, mod, dp));
      
      int n = in.nextInt();
      int mod = (int) 1e9 + 7;
      int dp[] = new int[n + 1];
      dp[0] = 1;
      for(int i = 1; i <= n; i++){
        for(int x = 1; x <= 6; x++){
          if(x > i) break;
          dp[i] = (dp[i] + dp[i - x]) % mod;
        }
      }
      out.println(dp[n]);
    }
    
    // public static int helper(int ind,int target, int[] dice, int mod, int[][] dp){
    //   if(ind == 0){
    //     return target % mod;
    //   }
    //   if(dp[ind][target] != -1) return dp[ind][target];
    //   int notTake = helper(ind - 1, target, dice, mod, dp);
    //   int take = 0;
    //   if(dice[ind] <= target)take = helper(ind, target - dice[ind], dice, mod, dp);
    //   return dp[ind][target] = (take % mod + notTake % mod) % mod;
    // }
}