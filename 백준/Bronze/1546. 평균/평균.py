import sys

input = sys.stdin.readline
print = sys.stdout.write

n = int(input())
arr = list(map(int, input().split()))

max_val = max(arr)
total = sum([(x / max_val) * 100.0 for x in arr]);

print(str(total / n))

