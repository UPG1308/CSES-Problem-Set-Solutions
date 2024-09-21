#include <bits/stdc++.h>
using namespace std;


int main(){
    int n; cin>>n;
    pair<int, int> events[n];
    for(int i = 0; i < n; ++i){
        int start, end; cin>>start>>end;
        events[i] = {end, start};
    }
    sort(events, events + n); // sorts by first element (ending time)
    int currentEventEnd = -1; // end of event currently attending
    int ans = 0;              // how many events were attended?
    for (int i = 0; i < n; i++)
    { // process events in order of end time
        if (events[i].second >= currentEventEnd)
        { // if event can be attended
            // we know that this is the earliest ending event that we can attend
            // because of how the events are sorted
            currentEventEnd = events[i].first;
            ans++;
        }
    }
    cout << ans << endl;
}