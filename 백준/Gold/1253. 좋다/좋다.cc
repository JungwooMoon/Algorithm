#include <bits/stdc++.h>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    
    int n;
    cin >> n;
    vector<long> v(n);
    
    for (int i = 0; i < n; i++) {
        cin >> v[i];
    }
    
    sort(v.begin(), v.end());
    
    int cnt = 0;
    
    for (int i = 0; i < n; i++) {
        int s = 0;
        int e = n-1;
        while(s < e) {
            if (s == i) {
                s++;
                continue;
            } else if (e == i) {
                e--;
                continue;
            }
            long long sum = v[s] + v[e];
            if (sum == v[i]) {
                cnt++;
                break;
            } else if (sum < v[i]) {
                s++;
            } else {
                e--;
            }
        }
    }
    
    cout << cnt;
    
    
}