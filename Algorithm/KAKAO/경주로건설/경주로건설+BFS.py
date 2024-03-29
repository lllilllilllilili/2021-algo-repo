import math
from collections import deque

def indexCheck(x, y, n):
    if x>n-1 or x<0 or y>n-1 or y<0:return False
    return True

def isVertical(now, next):
    if now[0]==next[0]: return 1
    return -1

def solution(board):
    global end, maxCost
    maxCost = math.inf
    visited = [[[math.inf, math.inf] for _ in range(len(board))] for _ in range(len(board))]
    now = [0, 0, 0, 0]
    end = [len(board)-1, len(board)-1]
    visited[0][0][0] = 0
    visited[0][0][1] = 0
    dx = [0, 0, -1, 1]
    dy = [1, -1, 0, 0]
    # 상, 하, 좌, 우
    q = deque([now])
    while q:
        temp = q.popleft()
        for i in range(4):
            next_x = temp[0]+dx[i]
            next_y = temp[1]+dy[i]

            if not indexCheck(next_x, next_y, len(board)): continue
            if board[next_x][next_y]: continue

            next = [next_x, next_y, isVertical(temp[:2], [next_x, next_y]), temp[3]]
            if temp[2]!=0 and temp[2]!=next[2]:
                if visited[next_x][next_y][0] < temp[3]+600:continue
                visited[next_x][next_y][0] = temp[3] + 600
                next[3] += 600
            else:
                if visited[next_x][next_y][1] < temp[3]+100: continue
                visited[next_x][next_y][1] = temp[3] + 100
                next[3] += 100
            if [next_x, next_y]==end and next[3] < maxCost:
                maxCost = next[3]
                continue
            q.append(next)

    return maxCost

solution([[0,0,0],[0,0,0],[0,0,0]])
solution([[0, 0, 1, 0], [0, 0, 0, 0], [0, 1, 0, 1], [1, 0, 0, 0]])
solution([[0,0,0,0,0,0,0,1],[0,0,0,0,0,0,0,0],[0,0,0,0,0,1,0,0],[0,0,0,0,1,0,0,0],[0,0,0,1,0,0,0,1],[0,0,1,0,0,0,1,0],[0,1,0,0,0,1,0,0],[1,0,0,0,0,0,0,0]])
