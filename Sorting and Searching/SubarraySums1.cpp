#include<bits/stdc++.h>
using namespace std;
#define ll long long

int main(){
    ll n, k; cin>>n>>k;
    vector<ll> arr(n, 0);
    for(int i = 0; i < n; ++i) cin>>arr[i];
    ll sum = 0ll, count = 0ll;
    for(ll begin = 0, end = 0; end < n; ++end){
        sum += arr[end];
        while(sum > k) sum -= arr[begin++];
        if(sum == k) count++;
    }
    cout<<count;
}