import java.util.*;
import java.io.*;

public class main {
    static int mod = (int) 1e9 + 7;

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine().trim();
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
            FastReader in = new FastReader();
            FastWriter out = new FastWriter();
            int testCases = 1;// in.nextInt();
            while (testCases-- > 0) {
                solve(in, out);
            }
            out.close();
        } catch (Exception e) {
            return;
        }
    }

    public static long ncr(int n, int r) {
        long sum = 1;

        // Calculate the value of n choose r using the
        // binomial coefficient formula
        for (int i = 1; i <= r; i++) {
            sum = sum * (n - r + i) / i;
        }
        return sum;
    }

    public static int power(int x, int n, int p) {

        for (int i = 0; i < n; i++) {
            x = (x * 2) % p;
        }
        return x % p;
    }

    public static void solve(FastReader in, FastWriter out) throws IOException {
        int n = in.nextInt();
        int target = in.nextInt();
        int coins[] = new int[n];
        for (int i = 0; i < n; i++)
            coins[i] = in.nextInt();
        int dp[][] = new int[n][target + 1];
        for (int[] i : dp)
            Arrays.fill(i, -1);
        out.println(helper(n - 1, target, coins, dp));
    }

    public static int helper(int ind, int sum, int coins[], int dp[][]) {
        if (ind == 0)
            return (sum % coins[ind] == 0) ? 1 : 0;
        if (dp[ind][sum] != -1)
            return dp[ind][sum];
        int pick = 0;
        if (coins[ind] <= sum)
            pick = helper(ind, sum - coins[ind], coins, dp) % mod;
        int notPick = (helper(ind - 1, sum, coins, dp)) % mod;
        return dp[ind][sum] = (pick + notPick) % mod;
    }

}