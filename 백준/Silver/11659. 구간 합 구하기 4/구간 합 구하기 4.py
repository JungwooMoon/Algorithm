import sys

input = sys.stdin.readline
print = sys.stdout.write

n, m = map(int, input().split())

arr = list(map(int, input().split()))
sum_value = [0]
for i in range(1, n+1):
    sum_value.append(sum_value[i-1] + arr[i-1])

for i in range(m):
    a, b = map(int, input().split())
    
    print(str(sum_value[b] - sum_value[a-1]) + "\n")
