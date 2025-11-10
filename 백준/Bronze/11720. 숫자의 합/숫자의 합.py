import sys

input = sys.stdin.readline
print = sys.stdout.write

n = int(input())
nums = input().strip()
sum = 0
for i in range(n):
    sum += int(nums[i])
    
print(str(sum))