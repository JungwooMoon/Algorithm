#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    
    long n, m;
    cin >> n >> m;
    long cnt = 0;
    vector<long> v(n+1, 0);
    vector<long> div(m, 0);
    for (long i = 1; i <= n; i++) {
        long val;
        cin >> val;
        v[i] = v[i-1] + val;
        long remainder = v[i] % m;
        div[remainder] = div[remainder] + 1;
        if (remainder == 0) cnt++;
    }
    
    for (long i = 0; i < m; i++) {
        if (div[i] > 1) {
            cnt += div[i] * (div[i]-1) / 2;
        }
    }
    
    cout << cnt;
    
    
    
    
    
    
    
    return 0;
}