#include <bits/stdc++.h>
using namespace std;

int main(){
    int n, k; cin>>n>>k;
    vector<int> arr(n, 0);
    for(auto &i: arr) cin>>i;
    map<int, int> map;
    bool found = false;
    for(int i = 0; i < n; ++i){
        if(map.count(k - arr[i])){
            cout<<map[k - arr[i]] + 1<<" "<<i + 1;
            found = true;
            break;
        }
        
        map[arr[i]] = i;
    }
    if(!found)
        cout << "IMPOSSIBLE";
     return 0;
}