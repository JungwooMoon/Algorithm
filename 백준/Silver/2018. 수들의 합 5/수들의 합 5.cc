#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    
    int n;
    cin >> n;
    int e;
    int cnt = 1;
    for (int i = 1; i <= n/2; i++) {
        e = i+1;
        int sum = i;
        while(sum <= n) {
            sum += e;
            if (sum == n) cnt++;
            e++;
        }
    }
    cout << cnt;
    return 0;
}