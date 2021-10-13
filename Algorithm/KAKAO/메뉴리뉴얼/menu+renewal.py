combis = {}
def solution(orders, course):
    global combis
    answer = []

    origin = orders[:]

    for couse in course:
        combis = {}
        for order in orders:
            if len(order) < couse: continue
            comb(order, couse, [], [0]*len(order), 0, 0)
        if combis:
            maxValue = max(combis.values())
            if maxValue < 2: continue
            for k, v in combis.items():
                if v==maxValue:
                    answer.append(k)

    answer.sort()
    return answer

def comb(order, courseSet, result, visitied, s, depth):
    global combis
    if depth == courseSet:
        result.sort()
        res = ''.join(result)
        if combis.get(res): combis[res] += 1
        else: combis[res]=1
        return
    else:
        for i in range(s, len(order)):
            if not visitied[i]:
                visitied[i] = 1
                comb(order, courseSet, result+[order[i]], visitied, i+1, depth+1)
                visitied[i] = 0


solution(["XYZ", "XWY", "WXA"], [2, 3, 4])