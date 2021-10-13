def solution(n, k, cmd):
#   주석은 예제1을 예시로 합니다.
    answer = ''
    nodes = {0: [n-1, 1]}
   
    for i in range(1, n):
        if i == n-1:
            nodes[i] = [i-1, 0]
        else :
            nodes[i] = [i-1, i+1]
    
    # print(nodes)
    del nodes[2]
    for i in range(n):
        print(nodes.get(i));
# {0: [7, 1], 1: [0, 2], 2: [1, 3], 3: [2, 4], 4: [3, 5], 5: [4, 6], 6: [5, 7], 7: [6, 0]}
    stack = []
    cmds = cmd
    for cmd in cmds:
        if len(cmd) > 1 :
            c, x = cmd.split(' ')

#             D 2
#             U 3
#             D 4
#             U 2
            
            cnt = 0
            print(c, x)
            if c == 'D':
                while cnt < int(x) : 
                    k = nodes[k][1]
                    cnt += 1
            else :
                while cnt < int(x) : 
                    k = nodes[k][0]
                    cnt += 1
        else :
            # 현재 선택된 행을 삭제한 후, 바로 아래 행을 선택합니다. 단, 삭제된 행이 가장 마지막 행인 경우 바로 윗 행을 선택합니다.
            if cmd == 'C':
                nodes[nodes[k][0]][1] = nodes[k][1]
                nodes[nodes[k][1]][0] = nodes[k][0]
                stack.append([k, nodes[k]])
                tmp = nodes[k]
                print("here")
                print(nodes[k])
                del nodes[k]
                if tmp[1] == 0:
                    k = tmp[0]
                else :
                    k = tmp[1]
            # 가장 최근에 삭제된 행을 원래대로 복구합니다. 단, 현재 선택된 행은 바뀌지 않습니다.
            else : 
                #k, nodes[k]
                curr_node, val = stack.pop()
                prev_node, next_node = val
                nodes[curr_node] = [prev_node, next_node]
                nodes[prev_node][1] = curr_node
                nodes[next_node][0] = curr_node
        result = ''
        for i in range(n):
            print(nodes.get(i))
    return answer