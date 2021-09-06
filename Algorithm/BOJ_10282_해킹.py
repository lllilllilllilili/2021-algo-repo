import sys
import heapq

input = sys.stdin.readline
INF = int(1e9)

t = int(input())


def dijkstra(start) :
    q = []
    heapq.heappush(q, (0, start))
    distances[start] = 0
    while q :
        dist, now = heapq.heappop(q)
        if distances[now] > dist:
            continue
        for next_node, next_cost in graph[now] :
            cost = dist + next_cost
            if distances[next_node] > cost :
                distances[next_node] = cost
                heapq.heappush(q, (cost, next_node))

for _ in range(t):
    n, d, c = map(int, input().split())
    graph = [ [] for _ in range(n+1)]
    distances = [INF] * (n+1)
    result = []
    for _ in range(d):
        a, b, s = map(int, input().split())
        graph[b].append((a, s))
    dijkstra(c)

    for distance in distances :
        if distance < INF:
            result.append(distance)

    print(len(result), max(result))

