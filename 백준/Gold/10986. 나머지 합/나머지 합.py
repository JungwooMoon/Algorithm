import sys

input = sys.stdin.readline
print = sys.stdout.write

n, m = map(int, input().split())

arr = [0] * (n+1)
div = [0] * m
cnt = 0
values = list(map(int, input().split()))
for i in range(1, n+1):
    val = values[i-1]
    arr[i] = arr[i-1] + val
    remainder = arr[i] % m
    if (remainder == 0):
        cnt = cnt + 1
    div[remainder]= div[remainder] + 1

for i in range (m):
    if (div[i] > 1):
        cnt += div[i] * (div[i] -1) // 2

    
print(str(cnt))