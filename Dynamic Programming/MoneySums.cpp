// #include <bits/stdc++.h>
// using namespace std;



// int helper(int ind, int target, vector<vector<int>>& dp, vector<int>& arr){
//     if(ind == 0){
//         return (arr[0] == target)  || (target == 0);
//     }
//     if(dp[ind][target] != -1) return dp[ind][target];
//     int pick = 0, notPick = 9;
//     if(target >= arr[ind]) pick = helper(ind - 1, target - arr[ind], dp, arr);
//     notPick = helper(ind - 1, target, dp, arr);
//     return dp[ind][target] = pick || notPick;
// }
// void solve(){
//     int n; cin>>n;
//     vector<int> arr(n);
//     for(int i = 0; i < n; i++) cin>>arr[i];
//     int sum = 0; accumulate(arr.begin(), arr.end(), sum);
//     vector<vector<int>> dp(n, vector<int>(sum + 1, -1));
//     helper(n - 1, sum, dp, arr);
//     int count = 0;
//     for(int i = 0; i <= sum; i++) count += dp[n - 1][i];
//     cout<<count<<endl;
//     for(int i = 0; i <= sum; i++){
//         if(dp[n - 1][sum]) cout<<(i)<<" ";
//     }
//     cout<<endl;
// }
// int main(){
//     solve();
//     return 0;
// }

#include <bits/stdc++.h>
using namespace std;

void solve()
{
    int n, sum = 0;
    cin >> n;
    vector<int> arr(n);
    for (int i = 0; i < n; i++)
    {
        cin >> arr[i];
        sum += arr[i];
    }
    vector<vector<bool>> dp(n, vector<bool>(sum + 1, false));
    int count = 0;
    dp[0][arr[0]] = dp[0][0] = true;
    for (int i = 1; i < n; i++)
    {
        for (int target = 0; target <= sum; target++)
        {
            bool pick = false, notPick = false;
            if (target >= arr[i])
                pick = dp[i - 1][target - arr[i]];
            notPick = dp[i - 1][target];
            dp[i][target] = pick or notPick;
        }
    }
    for (int i = 1; i <= sum; i++)
        count += dp[n - 1][i];
    cout << count << endl;
    for (int i = 1; i <= sum; i++)
    {
        if (dp[n - 1][i])
            cout << (i) << " ";
    }
    cout << endl;
}
int main()
{
    solve();
    return 0;
}