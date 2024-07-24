#include <bits/stdc++.h>
using namespace std;

const int MOD = 1e9 + 7;

// -------------------RECURSION---------------------------------
/*
int helper(int row, int col, vector<vector<char>>& grid){

    if(row == 0 && col == 0) return 1;
    if(row < 0 || col < 0 || grid[row][col] == '*') return 0;
    int up = 0, left = 0;
    up = helper(row - 1, col, grid) % MOD;
    left = helper(row, col - 1, grid) % MOD;
    return (up + left) % MOD;
}
void solve(){
    int n; cin>>n;
    vector<vector<char>> grid(n, vector<char>(n));
    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++) cin>>grid[i][j];
    }
    cout<<helper(n - 1, n - 1, grid);
}
int main(){
    solve();
}
*/

//--------------------------MEMOIZATION-----------------------------------------

/*
int helper(int row, int col, vector<vector<char>> &grid, vector<vector<int>>& dp)
{
    if (row == 0 && col == 0)
        return 1;
    if (row < 0 || col < 0 || grid[row][col] == '*')
        return 0;
    if(dp[row][col] != -1) return dp[row][col];
    int up = 0, left = 0;
    up = helper(row - 1, col, grid, dp) % MOD;
    left = helper(row, col - 1, grid, dp) % MOD;
    return dp[row][col] = (up + left) % MOD;
}
void solve()
{
    int n;
    cin >> n;
    vector<vector<char>> grid(n, vector<char>(n));
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < n; j++)
            cin >> grid[i][j];
    }
    vector<vector<int>> dp(n, vector<int>(n, -1));
    if(grid[0][0] == '*'){cout<<"0\n"; return;}
    cout << helper(n - 1, n - 1, grid, dp);
}
int main()
{
    solve();
}
*/

//------------------------------------TABULATION----------------------------------

void solve()
{
    int n;
    cin >> n;
    vector<vector<char>> grid(n, vector<char>(n));
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < n; j++)
            cin >> grid[i][j];
    }
    vector<vector<int>> dp(n + 1, vector<int>(n + 1, 0));
    if (grid[0][0] == '*')
    {
        cout << "0\n";
        return;
    }
    dp[1][1] = 1;
    for(int row = 1; row<= n; row++){
        for(int col = 1; col <= n; col++){
            if(grid[row - 1][col - 1] == '*' || (row == 1 && col == 1)) continue;
            dp[row][col] = (dp[row - 1][col] % MOD + dp[row][col - 1] % MOD) % MOD;
        }
    }
    cout << dp[n][n];
}
int main()
{
    solve();
}