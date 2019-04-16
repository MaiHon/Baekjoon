def dfs(x, y):
    # 시작항 (0,0)에 다르면 1리턴
    if x==0 and y==0:
        return 1

    # 만약 방문한적 있는(Optimal값 구한곳) => Optimal값 리턴
    if chk[y][x] != -1:
        return chk[y][x]

    # Optimal값 구해지지 않았고, 시작항도 아니면
    # 0으로 초기화 후에 4방향 확인
    chk[y][x] = 0
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]

        # 인덱스 범위를 벗어나지 않는 선에서
        # 만약 탐색하는 지점이 현재지점보다 작은 값이라면 계속 진행
        if nx<0 or nx>=N or ny<0 or ny>=M: continue
        if board[ny][nx] < board[y][x]: continue

        chk[y][x] += dfs(nx, ny)

    return chk[y][x]

# M, N값 받기
M, N = map(int, input().split())


# 보드값 받기
board = []
for _ in range(M):
    board.append(list(map(int, input().split())))

# 경로갯수 어레이 만들기: 초기값 -1
# chk[y][x]는 (0,0)에서 (y,x)까지 이동할 수 있는 경로의 수
chk = [[-1]*N for i in range(M)]

dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]

ans = dfs(N-1, M-1)
print(ans)
