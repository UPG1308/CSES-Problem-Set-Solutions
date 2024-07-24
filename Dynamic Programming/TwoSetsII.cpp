#include <bits/stdc++.h>
using namespace std;

const int MOD = 1e9 + 7;

//-------------------------RECURSION---------------------------
/*
int helper(int ind, int target, vector<int> &arr)
{
    if (ind == 0)
    {
        if (target == 0 || arr[0] == target)
            return 1;
        return 0;
    }
    int pick = 0, notPick = 0;
    if (target >= arr[ind])
        pick = helper(ind - 1, target - arr[ind], arr);
    notPick = helper(ind - 1, target, arr);
    return (pick + notPick) % MOD;
}
void solve()
{
    int n;
    cin >> n;
    int sum = n * (n + 1) / 2;
    if (sum & 1)
    {
        cout << "0";
        return;
    }
    int subsetSum = sum / 2;
    vector<int> arr;
    for (int i = 1; i <= n; i++)
        arr.push_back(i);
    cout << helper(n - 1, subsetSum, arr) / 2;
}
int main()
{
    solve();
    return 0;
}
*/

int helper(int ind, int target, vector<int> &arr, vector<vector<int>> &dp)
{
    if (ind == 0)
    {
        return (target == 0 || arr[0] == target) ? 1 : 0;
    }
    if (dp[ind][target] != -1)
        return dp[ind][target];
    int pick = 0, notPick = 0;
    if (target >= arr[ind])
        pick = helper(ind - 1, target - arr[ind], arr, dp);
    notPick = helper(ind - 1, target, arr, dp);
    return dp[ind][target] = (pick + notPick) % MOD;
}
void solve()
{
    int n;
    cin >> n;
    int sum = n * (n + 1) / 2;
    if (sum & 1)
    {
        cout << "0";
        return;
    }
    int subsetSum = sum / 2;
    vector<int> arr;
    vector<vector<int>> dp(n, vector<int>(subsetSum + 1, -1));
    for (int i = 1; i <= n; i++)
        arr.push_back(i);
    cout << helper(n - 1, subsetSum, arr, dp) / 2;
}
int main()
{
    solve();
    return 0;
}
