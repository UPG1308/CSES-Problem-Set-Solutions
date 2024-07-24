#include <bits/stdc++.h>
using namespace std;

const int MOD = 1e9 + 7;

//---------------RECURSION------------------
/*
int helper(int n){
    if(n == 0) return 1;
    int ans = 0;
    for(int i = 1; i <= 6; i++){
        if(n >= i) ans = (ans + helper(n - i)) % MOD;
    }
    return ans;
}
void solve(){
    int n; cin>>n;
    cout<<helper(n)<<endl;
}
int main(){
    solve();
}
*/

//------------------MEMOIZATION-----------------------
/*
int helper(int n, vector<int>& dp)
{
    if (n == 0)
        return 1;
    if(dp[n] != -1) return dp[n];
    int ans = 0;
    for (int i = 1; i <= 6; i++)
    {
        if (n >= i)
            ans = (ans + helper(n - i, dp)) % MOD;
    }
    return dp[n] = ans;
}
void solve()
{
    int n;
    cin >> n;
    vector<int> dp(n + 1, -1);
    cout << helper(n, dp) << endl;
}
int main()
{
    solve();
}
*/


// TABULATION
int helper(int n, vector<int> &dp)
{
    if (n == 0)
        return 1;
    if (dp[n] != -1)
        return dp[n];
    int ans = 0;
    for (int i = 1; i <= 6; i++)
    {
        if (n >= i)
            ans = (ans + helper(n - i, dp)) % MOD;
    }
    return dp[n] = ans;
}
void solve()
{
    int n;
    cin >> n;
    vector<int> dp(n + 1, 0);
    dp[0] = 1;
    for(int sum = 1; sum <= n; sum++){
        for(int diceValue = 1; diceValue <= 6; diceValue++){
            if(sum >= diceValue) dp[sum] = (dp[sum] + dp[sum - diceValue]) % MOD;
        }
    }
    cout << dp[n] << endl;
}
int main()
{
    solve();
}
