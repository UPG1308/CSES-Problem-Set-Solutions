#include <bits/stdc++.h>
using namespace std;
#define ll long long

int main(){
    int n; cin>>n;
    vector<ll> arr(n, 0ll);
    for(int i = 0; i < n; ++i) cin>>arr[i];
    map<ll, ll> mp;
    ll sum = 0ll, ans = 0ll;
    mp[0] = 1ll;
    for(int i = 0; i < n; ++i){
        sum += arr[i];
        if(mp.count((sum % n + n) % n)) ans += (mp[(sum % n + n) % n]);
        mp[(sum % n + n) % n]++;
    }
    cout<<ans;
}