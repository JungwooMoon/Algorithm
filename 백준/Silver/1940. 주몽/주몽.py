import sys

input = sys.stdin.readline
print = sys.stdout.write

n = int(input())
m = int(input())

arr = list(map(int, input().split()))

arr.sort()

s = 0
e = n-1
cnt = 0

while s != e:
    sum = arr[s] + arr[e]
    if (sum == m):
        cnt += 1
        e -= 1
    elif (sum > m):
        e -= 1
    else:
        s += 1
        
        
print(str(cnt))