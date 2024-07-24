#include <bits/stdc++.h>
using namespace std;

const int MOD = 1e9 + 7;

//----------------- RECURSION-------------------------

/*
int helper(int target, vector<int>& coins, int n){

    if(target == 0) return 1;
    int pick = 0;
    for(int index = 0; index < n; index++){
        if(target >= coins[index]) pick = (pick + helper(target - coins[index], coins, n)) % MOD;
    }
    return pick;
}

void solve(){
    int n, sum; cin>>n>>sum;
    vector<int> coins(n);
    for(int i = 0; i < n; i++) cin>>coins[i];
    cout<< helper(sum, coins, n);
}

int main(){
    solve();
}
*/


//---------------MEMOIZATION----------------------------
/*
int helper(int target, vector<int> &coins, int n, vector<int>& dp)
{
    if (target == 0)
        return 1;
    if(dp[target] != -1) return dp[target];
    int pick = 0;
    for (int index = 0; index < n; index++)
    {
        if (target >= coins[index])
            pick = (pick + helper(target - coins[index], coins, n, dp)) % MOD;
    }
    return dp[target] = pick;
}

void solve()
{
    int n, sum;
    cin >> n >> sum;
    vector<int> coins(n);
    for (int i = 0; i < n; i++)
        cin >> coins[i];
    vector<int> dp(sum + 1, -1);
    cout << helper(sum, coins, n, dp);
}

int main()
{
    solve();
}

*/

//-----------------TABULATION-------------------------

void solve()
{
    int n, sum;
    cin >> n >> sum;
    vector<int> coins(n);
    for (int i = 0; i < n; i++)
        cin >> coins[i];
    vector<int> dp(sum + 1, 0);
    dp[0] = 1;
    for(int target = 1; target <= sum; target++){
        for(int index = 0; index < n; index++){
            if(target >= coins[index]) dp[target] = (dp[target] + dp[target - coins[index]]) % MOD;
        }
    }
    cout << dp[sum];
}

int main()
{
    solve();
}