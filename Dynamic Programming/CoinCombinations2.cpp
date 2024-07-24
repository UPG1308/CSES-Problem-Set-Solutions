#include <bits/stdc++.h>
using namespace std;

const int MOD = 1e9 + 7;

// ---------------------RECURSION----------------------
/*
int helper(int ind, int target, vector<int>& coins){
    if(ind == 0) return target % coins[0] == 0? 1: 0;
    int pick = 0, notPick = 0;
    if(target >= coins[ind]) pick = helper(ind, target - coins[ind], coins);
    notPick = helper(ind - 1, target, coins);
    return (pick % MOD + notPick % MOD) % MOD;
}

void solve(){
    int n, sum;
    cin>>n>>sum;
    vector<int> coins(n);
    for(int i = 0; i < n; i++) cin>>coins[i];
    cout<<helper(n - 1, sum, coins);
}
int main(){
    solve();
}
*/

//----------------------MEMOIZATION---------------------------
/*
int helper(int ind, int target, vector<int> &coins, vector<vector<int>>& dp)
{
    if (ind == 0)
        return target % coins[0] == 0 ? 1 : 0;
    if(dp[ind][target] != -1) return dp[ind][target];
    int pick = 0, notPick = 0;
    if (target >= coins[ind])
        pick = helper(ind, target - coins[ind], coins, dp);
    notPick = helper(ind - 1, target, coins, dp);
    return dp[ind][target] = (pick % MOD + notPick % MOD) % MOD;
}

void solve()
{
    int n, sum;
    cin >> n >> sum;
    vector<int> coins(n);
    for (int i = 0; i < n; i++)
        cin >> coins[i];
    vector<vector<int>> dp(n, vector<int>(sum + 1, -1));
    cout << helper(n - 1, sum, coins, dp);
}
int main()
{
    solve();
}
*/


//----------------------TABULATION----------------------

void solve()
{
    int n, sum;
    cin >> n >> sum;
    vector<int> coins(n);
    for (int i = 0; i < n; i++)
        cin >> coins[i];
    vector<vector<int>> dp(n, vector<int>(sum + 1, 0));
    for(int target = 0; target <= sum; target++) dp[0][target] = target % coins[0] == 0?1:0;
    for(int ind = 1; ind < n; ind++){
        for(int target = 0; target <= sum; target++){
            int pick = 0, notPick = 0;
            if(target >= coins[ind]) pick = dp[ind][target - coins[ind]] % MOD;
            notPick = dp[ind - 1][target] % MOD;
            dp[ind][target] = (pick + notPick) % MOD;
        }
    }
    cout << dp[n - 1][sum]<<endl;
}
int main()
{
    solve();
}