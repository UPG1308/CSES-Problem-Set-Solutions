#include <bits/stdc++.h>
using namespace std;
#define ll long long

int main(){
    int n, k; cin>>n>>k;
    vector<ll> arr(n, 0ll);
    for(int i = 0; i < n; ++i) cin>>arr[i];
    map<ll, ll> mp;
    ll sum = 0ll, ans = 0ll;
    mp[0] = 1ll;
    for(int i = 0; i < n; ++i){
        sum += arr[i];
        if(mp.count(sum - k)) ans += (mp[sum - k]);
        mp[sum]++;
    }
    cout<<ans;
}