
import math

maxCost = math.inf
end = [0, 0]

dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]
# 상, 하, 좌, 우

def indexCheck(x, y, n):
    if x>n-1 or x<0 or y>n-1 or y<0:return False
    return True

def isVertical(now, next):
    if now[0]==next[0]: return 1
    return -1


def findRoad(now, board, visited,cost,n):
    global maxCost

    if [now[0], now[1]] == end:
        maxCost = min(cost, maxCost)
        return

    for i in range(4):
        next = [now[0]+dx[i], now[1]+dy[i], 0]
        if not indexCheck(next[0], next[1], len(visited)):continue
        if board[next[0]][next[1]]: continue
        if cost > visited[next[0]][next[1]][n]: continue
        visited[next[0]][next[1]][n] = cost
        next[2] = isVertical(now, next)
        oriCost = cost

        if now[2]!=0 and now[2]!=next[2]:
            n=1
            cost += 600
        else:
            cost += 100
            n=0
        if cost < maxCost: findRoad(next, board, visited, cost, n)

        cost = oriCost


def solution(board):
    global end, maxCost
    maxCost = math.inf
    visited = [[[math.inf, math.inf] for _ in range(len(board))] for _ in range(len(board))]
    visited[0][0][0] = 0
    visited[0][0][1] = 0
    now = [0, 0, 0, 0]
    end = [len(board)-1, len(board)-1]
    findRoad(now, board, visited, 0, 0)
    return maxCost

solution([[0,0,0],[0,0,0],[0,0,0]])
solution([[0, 0, 1, 0], [0, 0, 0, 0], [0, 1, 0, 1], [1, 0, 0, 0]])
solution([[0,0,0,0,0,0,0,1],[0,0,0,0,0,0,0,0],[0,0,0,0,0,1,0,0],[0,0,0,0,1,0,0,0],[0,0,0,1,0,0,0,1],[0,0,1,0,0,0,1,0],[0,1,0,0,0,1,0,0],[1,0,0,0,0,0,0,0]])
