#include <bits/stdc++.h>
using namespace std;

int main(){
    int n; cin>>n;
    map<int, int> mp;
    for(int i = 0; i < n; ++i){
        int a, b; cin>>a>>b;
        mp[a]++;mp[b + 1]--;
    }
    int mx = 0, sum = 0;
    for(auto it: mp){
        sum += it.second;
        mx = max(mx, sum);
    }
    cout<<mx;
}