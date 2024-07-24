
import java.util.*;
import java.io.*;


public class main{
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
      	int n = in.nextInt();
        int m = in.nextInt();
        
        char grid[][] = new char[n][m];
        for(int i = 0; i < n; i++){
            String[] s = in.nextLine().trim().split("");
            // for(int j = 0; j < m; j++)out.print(grid[i][j] +" ");
            for(int j = 0; j < m; j++){
            // out.print(s[j]+" ");
            grid[i][j] = s[j].charAt(0); //Integer.parseInt(s[j]);
            }
        }
        int delRow[] = {-1, 0, +1, 0};
        int delCol[] = {0, +1, 0, -1};
        boolean vis[][] = new boolean[n][m];
        int rooms = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if((grid[i][j] == '.') && !vis[i][j]){
                    rooms++;
                    dfs(i, j, vis, grid, delRow, delCol, n, m);
                }
            }
        }
        out.println(rooms);
    }
    public static void dfs(int ro, int co, boolean[][] vis, char[][] grid, int[] delRow, int[] delCol, int n, int m){
        vis[ro][co] = true;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{ro, co});
        while(!q.isEmpty()){
          int[] cell = q.poll();
          int Row = cell[0];
          int Col = cell[1];
          for(int i = 0; i < 4; i++){
            int row = Row + delRow[i];
            int col = Col + delCol[i];
            if(boundaryCheck(row, col, n, m) && grid[row][col] == '.' && !vis[row][col]){
              vis[row][col] = true;
              q.offer(new int[] {row, col});
            } 
          }
        }
        
    }
    public static boolean boundaryCheck(int row, int col, int n, int m){
        return row >= 0 && row < n && col >= 0 && col < m;
    }
}
