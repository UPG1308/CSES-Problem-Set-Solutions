#include <bits/stdc++.h>
using namespace std;

const int MAX = 1e7;
// ------------------ RECURSION-----------------------

/*
int helper(int ind, int target, vector<int> &coins)
{
    if (ind == 0)
        return (target % coins[ind] == 0) ? target / coins[ind] : MAX;
    int pick = MAX, notPick = MAX;
    if (target >= coins[ind])
        pick = 1 + helper(ind, target - coins[ind], coins);
    notPick = helper(ind - 1, target, coins);
    return min(pick, notPick);
}
void solve()
{
    int n, sum;
    cin >> n >> sum;
    vector<int> coins(n);
    for (int i = 0; i < n; i++)
        cin >> coins[i];
    int ans = helper(n - 1, sum, coins);
    cout << ((ans < MAX) ? ans : -1) << endl;
}

int main()
{
    solve();
}
*/
//------------------------MEMOIZATION----------------------------------
/*
int helper(int ind, int target, vector<int> &coins, vector<vector<int>>& dp)
{
    if (ind == 0)
        return (target % coins[ind] == 0) ? target / coins[ind] : MAX;
    if(dp[ind][target] != -1) return dp[ind][target];
    int pick = MAX, notPick = MAX;
    if (target >= coins[ind])
        pick = 1 + helper(ind, target - coins[ind], coins, dp);
    notPick = helper(ind - 1, target, coins, dp);
    return dp[ind][target] = min(pick, notPick);
}
void solve()
{
    int n, sum;
    cin >> n >> sum;
    vector<int> coins(n);
    for (int i = 0; i < n; i++)
        cin >> coins[i];
    vector<vector<int>> dp(n, vector<int>(sum+1,-1));
    int ans = helper(n - 1, sum, coins, dp);
    cout << ((ans < MAX) ? ans : -1) << endl;
}

int main()
{
    solve();
}
*/


//-------------------------------TABULATION---------------------------
void solve()
{
    int n, sum;
    cin >> n >> sum;
    vector<int> coins(n);
    for (int i = 0; i < n; i++)
        cin >> coins[i];
    vector<vector<int>> dp(n, vector<int>(sum + 1, 0));
    for (int target = 0; target <= sum; target++)
        dp[0][target] = (target % coins[0] == 0) ? target / coins[0] : MAX;
    for (int ind = 1; ind < n; ind++)
    {
        for (int target = 0; target <= sum; target++)
        {
            int pick = MAX, notPick = MAX;
            if (target >= coins[ind])
                pick = 1 + dp[ind][target - coins[ind]];
            notPick = dp[ind - 1][target];
            dp[ind][target] = min(pick, notPick);
        }
    }
    cout << ((dp[n - 1][sum] < MAX)?dp[n - 1][sum]:-1) << endl;
}

int main()
{
    solve();
}