# Input처리함수
def getInput():
    n, k = map(int, input().split())
    coin = []

    # 각각의 동전 값을 a함수에 넣어줌
    for i in range(n):
        coin.append(int(input()))

    # 0 ~ k까지의 리스트 생성 후에
    # 1번부터 시작하기 위해서 0번째 인덱스에 1 할당
    d = [0] * (k+1)
    d[0] = 1

    return n, k, coin, d

# 실행
n, k, coin, d = getInput()

for i in range(1, n+1):
    for j in range(coin[i-1], k+1):
        d[j] += d[j-coin[i-1]]

print(d[k])
