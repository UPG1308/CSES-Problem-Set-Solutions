#include <bits/stdc++.h>
using namespace std;

//--------------------------RECURSION---------------------------------------------

/*
int helper(int ind, int cost, vector<int>& prices, vector<int>& pages){
    if(ind < 0) return 0;
    int pick = 0, notPick = 0;
    if(cost >= prices[ind]) pick = pages[ind] + helper(ind - 1, cost - prices[ind], prices, pages);
    notPick = helper(ind - 1, cost, prices, pages);
    return max(pick, notPick);
}

void solve(){
    int n, budget; cin>>n>>budget;
    vector<int> prices(n), pages(n);
    for(int i = 0; i < n; i++) cin>>prices[i];
    for(int i = 0; i < n; i++) cin>>pages[i];
    cout<<helper(n - 1, budget, prices, pages);
}

int main(){
    solve();
}
*/
//---------------------------------------MEMOIZATION-------------------------------------------
/*
int helper(int ind, int cost, vector<int> &prices, vector<int> &pages, vector<vector<int>>& dp)
{
    if (ind < 0)
        return 0;
    if(dp[ind][cost] != -1) return dp[ind][cost];
    int pick = 0, notPick = 0;
    if (cost >= prices[ind])
        pick = pages[ind] + helper(ind - 1, cost - prices[ind], prices, pages, dp);
    notPick = helper(ind - 1, cost, prices, pages, dp);
    return dp[ind][cost] = max(pick, notPick);
}

void solve()
{
    int n, budget;
    cin >> n >> budget;
    vector<int> prices(n), pages(n);
    for (int i = 0; i < n; i++)
        cin >> prices[i];
    for (int i = 0; i < n; i++)
        cin >> pages[i];
    vector<vector<int>> dp(n, vector<int>(budget + 1, -1));
    cout << helper(n - 1, budget, prices, pages, dp);
}

int main()
{
    solve();
}
*/

//-----------------------------------TABULATION-----------------------------------------------

int helper(int ind, int cost, vector<int> &prices, vector<int> &pages, vector<vector<int>> &dp)
{
    if (ind < 0)
        return 0;
    if (dp[ind][cost] != -1)
        return dp[ind][cost];
    int pick = 0, notPick = 0;
    if (cost >= prices[ind])
        pick = pages[ind] + helper(ind - 1, cost - prices[ind], prices, pages, dp);
    notPick = helper(ind - 1, cost, prices, pages, dp);
    return dp[ind][cost] = max(pick, notPick);
}

void solve()
{
    int n, budget;
    cin >> n >> budget;
    vector<int> prices(n), pages(n);
    for (int i = 0; i < n; i++)
        cin >> prices[i];
    for (int i = 0; i < n; i++)
        cin >> pages[i];
    vector<vector<int>> dp(n, vector<int>(budget + 1, 0));
    for (int cost = 0; cost <= budget; cost++)
    {
        if (prices[0] > cost)
            continue;
        dp[0][cost] = pages[0];
    }

    for (int ind = 1; ind < n; ind++)
    {
        for (int cost = 0; cost <= budget; cost++)
        {
            int pick = 0, notPick = 0;
            if (cost >= prices[ind])
                pick = pages[ind] + dp[ind - 1][cost - prices[ind]];
            notPick = dp[ind - 1][cost];
            dp[ind][cost] = max(pick, notPick);
        }
    }
    cout << dp[n - 1][budget];
}

int main()
{
    solve();
}
