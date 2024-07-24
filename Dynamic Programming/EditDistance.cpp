#include <bits/stdc++.h>
using namespace std;

const int inf = 1e7;

//-------------------------------------RECURSION--------------------------------
/*
int helper(int ind1, int ind2, string &s, string &t)
{
    if (ind1 < 0 && ind2 < 0)
        return 0;
    if (ind1 < 0)
        return ind2 + 1;
    if (ind2 < 0)
        return ind1 + 1;
    int ans = inf;
    int deleteOperation = inf, replaceOperation = inf, insertOperation = inf;
    if (s[ind1] == t[ind2])
        return helper(ind1 - 1, ind2 - 1, s, t);
    else
    {
        deleteOperation = min(deleteOperation, 1 + helper(ind1 - 1, ind2, s, t));
        replaceOperation = min(replaceOperation, 1 + helper(ind1 - 1, ind2 - 1, s, t));
        insertOperation = min(insertOperation, 1 + helper(ind1, ind2 - 1, s, t));
    }
    return min(min(deleteOperation, replaceOperation), min(ans, insertOperation));
}
void solve()
{
    string s, t;
    cin >> s >> t;
    int n = s.size(), m = t.size();
    cout << helper(n - 1, m - 1, s, t);
}
int main()
{
    solve();
}
*/

//------------------------------MEMOIZATION------------------------------
/*
int helper(int ind1, int ind2, string &s, string &t, vector<vector<int>>& dp)
{
    if (ind1 < 0 && ind2 < 0)
        return 0;
    if (ind1 < 0)
        return ind2 + 1;
    if (ind2 < 0)
        return ind1 + 1;
    if(dp[ind1][ind2] != -1) return dp[ind1][ind2];
    int ans = inf;
    int deleteOperation = inf, replaceOperation = inf, insertOperation = inf;
    if (s[ind1] == t[ind2])
        return helper(ind1 - 1, ind2 - 1, s, t, dp);
    else
    {
        deleteOperation = min(deleteOperation, 1 + helper(ind1 - 1, ind2, s, t, dp));
        replaceOperation = min(replaceOperation, 1 + helper(ind1 - 1, ind2 - 1, s, t, dp));
        insertOperation = min(insertOperation, 1 + helper(ind1, ind2 - 1, s, t, dp));
    }
    return dp[ind1][ind2] = min(min(deleteOperation, replaceOperation), min(ans, insertOperation));
}
void solve()
{
    string s, t;
    cin >> s >> t;
    int n = s.size(), m = t.size();
    vector<vector<int>> dp(n, vector<int>(m, -1));
    cout << helper(n - 1, m - 1, s, t, dp);
}
int main()
{
    solve();
}
*/

//---------------------------------------TABULATION------------------------------

int helper(int ind1, int ind2, string &s, string &t, vector<vector<int>> &dp)
{
    if (ind1 < 0 && ind2 < 0)
        return 0;
    if (ind1 < 0)
        return ind2 + 1;
    if (ind2 < 0)
        return ind1 + 1;
    if (dp[ind1][ind2] != -1)
        return dp[ind1][ind2];
    int ans = inf;
    int deleteOperation = inf, replaceOperation = inf, insertOperation = inf;
    if (s[ind1] == t[ind2])
        return helper(ind1 - 1, ind2 - 1, s, t, dp);
    else
    {
        deleteOperation = min(deleteOperation, 1 + helper(ind1 - 1, ind2, s, t, dp));
        replaceOperation = min(replaceOperation, 1 + helper(ind1 - 1, ind2 - 1, s, t, dp));
        insertOperation = min(insertOperation, 1 + helper(ind1, ind2 - 1, s, t, dp));
    }
    return dp[ind1][ind2] = min(min(deleteOperation, replaceOperation), min(ans, insertOperation));
}
void solve()
{
    string s, t;
    cin >> s >> t;
    int n = s.size(), m = t.size();
    vector<vector<int>> dp(n + 1, vector<int>(m + 1, 0));
    for (int ind1 = 0; ind1 <= n; ind1++)
        dp[ind1][0] = ind1;
    for (int ind2 = 0; ind2 <= m; ind2++)
        dp[0][ind2] = ind2;
    for (int ind1 = 0; ind1 < n; ind1++)
    {
        for (int ind2 = 0; ind2 < m; ind2++)
        {
            if (s[ind1] == t[ind2])
                dp[ind1 + 1][ind2 + 1] = dp[ind1][ind2];
            else
            {
                dp[ind1 + 1][ind2 + 1] = 1 + min(min(dp[ind1][ind2 + 1], dp[ind1][ind2]), dp[ind1 + 1][ind2]);
            }
        }
    }
    cout << dp[n][m];
}
int main()
{
    solve();
}
