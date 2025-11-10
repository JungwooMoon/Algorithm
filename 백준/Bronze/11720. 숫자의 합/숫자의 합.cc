#include <iostream>
#include <vector>
#include <algorithm>
#include <string>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    
    int n;
    cin >> n;
    string nums;
    cin >> nums;
    int sum = 0;
    for (int i = 0; i < n; i++) {
        sum += nums[i] - '0';
    }
    
    cout << sum;
    
}