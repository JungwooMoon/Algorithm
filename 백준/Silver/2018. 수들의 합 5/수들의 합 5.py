import sys

input = sys.stdin.readline
print = sys.stdout.write

n = int(input())
cnt = 1
start, end = 1, 1
sum_val = 1
while end < n:
    if (sum_val == n):
        cnt += 1
        end += 1
        sum_val += end
    elif (sum_val < n):
        end += 1
        sum_val += end 
    else:
        sum_val -= start
        start += 1
        
            
                    
            
            
print(str(cnt))