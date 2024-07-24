
import java.util.*;
import java.io.*;

public class BuildingTeams {
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
            int testCases = 1;
            while (testCases-- > 0) {
                solve(in, out);
            }
            out.close();
        } catch (Exception e) {
            return;
        }
    }

    public static void solve(FastReader in, FastWriter out) throws IOException {
        int pupils = in.nextInt();
        int friendships = in.nextInt();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= pupils; i++)
            adj.add(new ArrayList<>());
        for (int i = 0; i < friendships; i++) {
            int u = in.nextInt();
            int v = in.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int group[] = new int[pupils + 1];
        Arrays.fill(group, -1);
        for (int j = 1; j <= pupils; j++) {
            if (group[j] == -1) {
                if (!isBipartite(j, adj, group)) {
                    out.println("IMPOSSIBLE");
                    return;
                }
            }
        }
        for (int i = 1; i <= pupils; i++)
            out.print(group[i] + " ");

    }

    public static boolean isBipartite(int nod, ArrayList<ArrayList<Integer>> adj, int[] group) {
        Queue<Integer> q = new LinkedList<>();
        group[nod] = 1;
        q.add(nod);
        while (!q.isEmpty()) {
            int node = q.poll();
            for (int adjNode : adj.get(node)) {
                if (group[adjNode] == -1) {
                    q.offer(adjNode);
                    group[adjNode] = (group[node] == 1) ? 2 : 1;
                } else if (group[adjNode] == group[node])
                    return false;
            }
        }
        return true;
    }

}