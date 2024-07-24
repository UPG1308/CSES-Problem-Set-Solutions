#include <bits/stdc++.h>
using namespace std;

const int MAX = 1e9 + 7;
/*
int helper(int num)
{
    if (num == 0)
        return 0;
    int ans = MAX;
    int lastDigit = num % 10;
    if (lastDigit == 0)
        lastDigit = 9;
    for (int digits = 1; digits <= lastDigit; digits++)
    {
        if (num >= digits)
            ans = min(ans, 1 + helper(num - digits));
    }
    return ans;
}
void solve()
{
    int n;
    cin >> n;
    cout << helper(n);
}
int main()
{
    solve();
}
*/

int helper(int num, vector<int>& dp)
{
    if (num == 0)
        return 0;
    if(dp[num] != -1) return dp[num];
    int ans = MAX;
    int lastDigit = num % 10;
    if (lastDigit == 0)
        lastDigit = 9;
    for (int digits = 1; digits <= lastDigit; digits++)
    {
        if (num >= digits)
            ans = min(ans, 1 + helper(num - digits, dp));
    }
    return dp[num] = ans;
}
void solve()
{
    int n;
    cin >> n;
    vector<int> dp(n + 1, -1);
    cout << helper(n, dp);
}
int main()
{
    solve();
}