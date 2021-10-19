n,m = map(int,input().split())

tempDict = {}

for i in range(1, n+1):
    for j in range(1, m+1) :
        key = i + j
        if key in tempDict :
            tempDict[key] += 1
        else :
            tempDict[key] = 0

tempDict = sorted(tempDict.items(), key=lambda x : x[1], reverse = True)


comp = tempDict[0][1]
answer = []
for item in range(0, len(tempDict)) :
    if tempDict[item][1] != comp :
        break
    else :
        answer.append(str(tempDict[item][0]))


print(' '.join(answer))