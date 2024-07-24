
import java.util.*;
import java.io.*;


public class MessageRoute{
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
            int testCases=1;
            while(testCases-- > 0){
                solve(in , out);
            }
            out.close();
        } catch (Exception e) {
            return;
        }
    }
    
    public static void solve(FastReader in, FastWriter out) throws IOException {
      	int computers = in.nextInt();
        int network = in.nextInt();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i <= computers; i++) adj.add(new ArrayList<>());
        for(int i = 0; i < network; i++){
          int u = in.nextInt();
          int v = in.nextInt();
          adj.get(u).add(v);
          adj.get(v).add(u);
        }
        Queue<Integer> q = new LinkedList<>();
        int dist[] = new int[computers + 1];
        boolean vis[] = new boolean[computers + 1];
        int parent[] = new int[computers + 1];
        Arrays.fill(dist, -1);
        dist[1] = 1;
        q.add(1);
        while(!q.isEmpty()){
          int node = q.poll();
            for(int adjNode: adj.get(node)){
              if(!vis[adjNode]){
                vis[adjNode] = true;
                q.offer(adjNode);
                dist[adjNode] = dist[node] + 1;
                parent[adjNode] = node;
              }
            }
        }
        if(dist[computers] == -1){ out.println("IMPOSSIBLE"); return;}
        out.println(dist[computers]);
        ArrayList<Integer> path = new ArrayList<>();
        int index = computers;
        while(true){
          path.add(index);
          if(index == 1) break;
          index = parent[index];
        }
        index = path.size();
        while(--index >= 0) out.print(path.get(index) + " ");
    }
    
}