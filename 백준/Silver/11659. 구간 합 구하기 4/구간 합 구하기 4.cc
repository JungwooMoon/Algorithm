#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    
    int n, m;
    cin >> n >> m;
    vector<int> v(n);
    for (int i = 0; i < n; i++) {
        cin >> v[i];
    }
    vector<int> sum(n+1, 0);
    for (int i = 1; i < n+1; i++) {
        sum[i] = sum[i-1] + v[i-1];
    }
    
    int a, b;
    while(cin >> a >> b) {
        cout << sum[b] - sum[a-1] << "\n";
    }
}