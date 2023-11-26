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
      int n = in.nextInt();
      int target = in.nextInt();
      int coins[] = new int[n];
      for(int i = 0; i < n; i++) coins[i] = in.nextInt();
      
      int dp[][] = new int[n + 1][target + 1];
      int ans = 0;
      for(int sum = 0; sum <= target; sum++){
        if(sum % coins[0] == 0) dp[0][sum] =  sum / coins[0];
        else dp[0][sum] = (int) 1e8;
      }
      
      for(int index = 1; index < n; index++){
        for(int sum = 1; sum <= target; sum++){
            int take = (int) 1e8;
            if(coins[index] <= sum) take = 1 + dp[index][sum - coins[index]];
            int notTake = dp[index - 1][sum];
            dp[index][sum] = Math.min(take, notTake);
        }
      }
      ans = dp[n - 1][target];
      if(ans > 1e7) out.println("-1");
      else out.println(ans);
    }
    public static int helper(int index, int sum, int[] coins, int[][] dp){
      if(index == 0){
        if(sum == 0) return 0;
        else if(sum % coins[0] == 0) return sum / coins[index];
        else return (int) 1e8;
      }
      if(dp[index][sum] != -1) return dp[index][sum];
      int take = (int) 1e8;
      if(coins[index] <= sum) take = 1 + helper(index, sum - coins[index], coins, dp);
      int notTake = helper(index - 1, sum, coins, dp);
      return dp[index][sum] = Math.min(take, notTake);
    }
    
}