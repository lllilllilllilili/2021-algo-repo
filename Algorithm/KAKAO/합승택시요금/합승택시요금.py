import heapq, math

def dij(start, graph):
    distances = {node: math.inf for node in graph}
    distances[start] = 0

    q = []
    heapq.heappush(q, [distances[start], start])

    while q:
        current_d, node = heapq.heappop(q)
        if distances[node] < current_d: continue

        for near_node, d in graph[node].items():
            weighted_d = current_d+d
            if weighted_d < distances[near_node]:
                distances[near_node] = weighted_d
                heapq.heappush(q, [weighted_d, near_node])

    return distances


def solution(n, s, a, b, fares):
    answer = 0
    graph = {}
    for i in range(len(fares)):
        if graph.get(fares[i][0]):
            graph[fares[i][0]][fares[i][1]] = fares[i][2]
        else:
            graph[fares[i][0]] = {}
            graph[fares[i][0]][fares[i][1]] = fares[i][2]

        if graph.get(fares[i][1]):
            graph[fares[i][1]][fares[i][0]] = fares[i][2]
        else:
            graph[fares[i][1]] = {}
            graph[fares[i][1]][fares[i][0]] = fares[i][2]

    middle_routes= dij(s, graph)
    min_d = math.inf
    for k in middle_routes.keys():
        res = middle_routes[k]
        mid_to_end = dij(k, graph)
        res += mid_to_end[a]
        res += mid_to_end[b]
        if res < min_d:
            min_d = res
    # 다익스트라를 3번 구하면 됨
    # 출발지 - 각 경유지 최소 거리
    # 경유지 - A , B 도착지까지 최소 거리
    return min_d

solution(6,4,6,2,[[4, 1, 10], [3, 5, 24], [5, 6, 2], [3, 1, 41], [5, 1, 24], [4, 6, 50], [2, 4, 66], [2, 3, 22], [1, 6, 25]])
