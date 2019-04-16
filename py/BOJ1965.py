n = int(input())
box = list(map(int, input().split()))

dp = [1 for _ in range(len(box)+1)]

# 현재위치 보다 이전에 있는 박스들 중
# 현재박스의 사이즈보다 작은 상자들 중
# 최대값에다가 1을 더한 값이 현재위치의 최대값
for i in range(1, n):
    for j in range(0, i):
        if box[j] < box[i] and dp[j]+1 > dp[i]:
            dp[i] = dp[j] + 1

print(max(dp))
