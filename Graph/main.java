
import java.util.*;
import java.io.*;

public class main {
    static int startNode = 0, endNode = 0;

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
        int cities = in.nextInt();
        int roads = in.nextInt();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= cities; i++)
            adj.add(new ArrayList<>());
        for (int i = 0; i < roads; i++) {
            int u = in.nextInt();
            int v = in.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean vis[] = new boolean[cities + 1];
        int parent[] = new int[cities + 1];
        if (visitAll(adj, vis, parent)) {
            int tv = endNode;
            ArrayList<Integer> path = new ArrayList<>();
            path.add(endNode);
            while (tv != startNode) {
                path.add(parent[tv]);
                tv = parent[tv];
            }
            Collections.reverse(path);
            path.add(path.get(0));
            out.println(path.size());
            for (int i : path)
                out.print(i + " ");
        } else
            out.println("IMPOSSIBLE");
    }

    public static boolean visitAll(ArrayList<ArrayList<Integer>> adj, boolean vis[], int[] parent) {
        for (int i = 1; i < vis.length; i++) {
            if (!vis[i]) {
                if (dfs(i, -1, adj, vis, parent))
                    return true;
            }
        }
        return false;
    }

    public static boolean dfs(int node, int par, ArrayList<ArrayList<Integer>> adj, boolean vis[], int[] parent) {
        vis[node] = true;
        parent[node] = par;
        for (int adjNode : adj.get(node)) {
            if (!vis[adjNode]) {
                if (dfs(adjNode, node, adj, vis, parent))
                    return true;
            } else if (adjNode != par) {
                startNode = adjNode;
                endNode = node;
                return true;
            }
        }
        return false;
    }
}