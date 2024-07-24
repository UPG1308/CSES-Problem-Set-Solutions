#include <bits/stdc++.h>
using namespace std;

// ------------------------RECURSION--------------------------
/*
int helper(int height, int width){
    int ans = 1e8;
    if(height == width) return 0;
    else{
        for(int cut = 1; cut < height; cut++) ans = min(ans, 1 + helper(cut, width) + helper(height - cut, width));
        for(int cut = 1; cut < width; cut++) ans = min(ans, 1 + helper(height, cut) + helper(height, width - cut));
    }
    return ans;
}
void solve(){
    int a,b; cin>>a>>b;
    cout<<helper(a, b);
}
int main(){
    solve();
}
*/

// ------------------------------MEMOIZATION--------------------------------
/*
int helper(int height, int width, vector<vector<int>>& dp)
{
    int ans = 1e8;
    if(dp[height][width] != -1) return dp[height][width];
    if (height == width)
        return 0;
    else
    {
        for (int cut = 1; cut < height; cut++)
            ans = min(ans, 1 + helper(cut, width, dp) + helper(height - cut, width, dp));
        for (int cut = 1; cut < width; cut++)
            ans = min(ans, 1 + helper(height, cut, dp) + helper(height, width - cut, dp));
    }
    return dp[height][width] = ans;
}
void solve()
{
    int a, b;
    cin >> a >> b;
    vector<vector<int>> dp(a + 1, vector<int>(b + 1, -1));
    cout << helper(a, b, dp);
}
int main()
{
    solve();
}
*/

//------------------------------------------TABULATION-------------------------------

void solve()
{
    int height, width;
    cin >> height >> width;
    vector<vector<int>> dp(height + 1, vector<int>(width + 1, 0));
    for (int currHeight = 1; currHeight <= height; currHeight++)
    {
        for (int currWidth = 1; currWidth <= width; currWidth++)
        {
            int ans = 1e8;
            if (currHeight == currWidth)
                dp[currHeight][currWidth] = 0;
            else
            {
                for (int cut = 1; cut < currHeight; cut++)
                    ans = min(ans, 1 + dp[cut][currWidth] + dp[currHeight - cut][currWidth]);
                for (int cut = 1; cut < currWidth; cut++)
                    ans = min(ans, 1 + dp[currHeight][cut] + dp[currHeight][currWidth - cut]);
                dp[currHeight][currWidth] = ans;
            }
        }
    }
    cout << dp[height][width];
}
int main()
{
    solve();
}
