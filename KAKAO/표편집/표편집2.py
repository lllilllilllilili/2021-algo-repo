import heapq  
def solution(n, k, cmd):
    answer = ''
    left, right, delete = [], [], []
    for i in range(n) :
        heapq.heappush(right, i)
   
    for i in range(k) :
        #print(heapq.heappop(right))
        #음수를 붙여주는 이유 : 최댓값이 맨 앞에 오게 할려고 나중에 다시 -를 붙여서 양수로 전환 
        heapq.heappush(left, -heapq.heappop(right))
    
    print(left)
    print(right)
    
    for c in cmd:
        if len(c) > 1:
            move = int(c.split()[-1])
            if c.startswith("D"):
                #right 0번째 인덱스 위치가 k의 위치임
                for _ in range(move):
                    if right:
                        heapq.heappush(left, -heapq.heappop(right))
            else :
                for _ in range(move):
                    if left:
                        heapq.heappush(right, -heapq.heappop(left))
        elif c == "C":
            delete.append(heapq.heappop(right))
            # 값이 삭제되면 가장 최근에 삭제된 값을 복구하기 위한 형태
            if not right:
                heapq.heappush(right, -heapq.heappop(left))
        elif c == "Z":
            repair = delete.pop()
            
            #전체 값을 구하는데 left 도 포함되어 있기 때문에
            #값이 right[0] = k위치보다 작아지면 left에 넣어야댐
            if repair < right[0]:
                heapq.heappush(left, -repair)
            else :
                heapq.heappush(right, repair)
    result = []
    while right:
        result.append(heapq.heappop(right))
    while left:
        result.append(-heapq.heappop(left))
    
    print(result)
    print(set(result))
    answer = ["O" if i in result else "X" for i in range(n)]
    
    return "".join(answer)