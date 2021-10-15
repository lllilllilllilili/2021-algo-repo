from itertools import combinations
#n, k = map(int, input().split())

n = 3
k = 6
if k < 5:
    print(0)
else:
    k -= 5
    nece_chars = {'a', 'n', 't', 'i', 'c'}
    input_chars = []
    alpha = {ky: v for v, ky in enumerate(
        (set(map(chr, range(ord('a'), ord('z')+1)))- nece_chars))}

    #print(set(map(chr, range(ord('a'), ord('z')+1))) )
    cnt = 0
    input_chars = []
    #입력
    #input_chars에는 무엇이 들어갈까?
    for _ in range(n):
        tmp = 0
        tmp2 = 0
        ## 의미
        for c in set(input())-nece_chars :
            # alpha[c] = 숫자
            #print(c)
            tmp |= (1<<alpha[c])
            tmp2 |= alpha[c]
            print("alpha", tmp)
            print("1<<alpha", tmp2)
            print(tmp)
        #입력 받아오는것을 공통 단어를 제외하고 tmp에 넣음 (
        input_chars.append(tmp)
        #print("next")


    power_by_2 = (2**i for i in range(21))
    print("power_by_2",power_by_2)
    print("input_chars", input_chars)
    #
    for comb in combinations(power_by_2, k) :

        test = sum(comb)
        print(test)
        ct = 0
        for cb in input_chars :
            if test & cb == cb:
                ct +=1