#include <bits/stdc++.h>
using namespace std;
#define ll long long

ll stoneGame(vector<int> &piles)
{
    int N = piles.size();

    // dp[i+1][j+1] = the value of the game [piles[i], ..., piles[j]]
    ll dp[N + 2][N + 2];
    memset(dp, 0, sizeof(dp));

    for (int size = 1; size <= N; ++size)
        for (int i = 0, j = size - 1; j < N; ++i, ++j)
        {
            int parity = (j + i + N) % 2; // j - i - N; but +x = -x (mod 2)
            if (parity == 1)
                dp[i + 1][j + 1] = max(piles[i] + dp[i + 2][j + 1] * 1ll, piles[j] + dp[i + 1][j] * 1ll);
            else
                dp[i + 1][j + 1] = min(-piles[i] + dp[i + 2][j + 1] * 1ll, -piles[j] + dp[i + 1][j] * 1ll);
        }

    return dp[1][N];
}
void solve()
{
    int n;
    cin >> n;
    vector<int> arr(n, 0);
    ll sum = 0;
    for (int i = 0; i < n; i++)
    {
        cin >> arr[i];
        sum += arr[i];
    }
    cout << (stoneGame(arr) + sum) / 2;
}
int main()
{
    int t = 1;
    while (t--)
        solve();
    return 0;
}