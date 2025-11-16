import sys

input = sys.stdin.readline
print = sys.stdout.write

n = int(input())
    
arr = list(map(int, input().split()))
    
arr.sort()
cnt = 0
for i in range(n):
    s, e = 0, n-1
    while s < e:
        if s == i:
            s += 1
            continue
        if e == i:
            e -= 1
            continue
                
        sum = arr[s] + arr[e]
        
        if (sum == arr[i]):
            cnt += 1
            break
        elif (sum < arr[i]):
            s += 1
        else:
            e -= 1

print(str(cnt))
