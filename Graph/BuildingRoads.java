import java.util.*;
import java.io.*;


public class BuildingRoads{
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
      	int cities = in.nextInt();
        int CurrentRoads = in.nextInt();
        DisjointSet ds = new DisjointSet(cities);
        for(int road = 0; road < CurrentRoads; road++){
          int start = in.nextInt();
          int end = in.nextInt();
          ds.unionBySize(start, end);
        }
        out.println(ds.components - 1);
        int start = -1;
        for(int i = 1;i <= cities; i++){
          if(ds.findUPar(i) == i && start == -1){start = i;continue;}
          if(start != -1 && ds.findUPar(i) == i){
            out.println(start+" "+i);
            start = i;
          }
        }
    }
    
}

class DisjointSet{
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    int components;
    DisjointSet(int n){
      components = n;
        for(int i = 0;i <= n; i++){
            parent.add(i);
            size.add(1);
        }
    }
    public int findUPar(int node){
        if(node == parent.get(node)) return node;
        int ulp = findUPar(parent.get(node));
        parent.set(node, ulp);
        return parent.get(node);
    }
    public void unionBySize(int u, int v){
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if(ulp_u == ulp_v) return;
        if(size.get(ulp_u) < size.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u));
        }
        else{
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        }
        components--;
    }
}
