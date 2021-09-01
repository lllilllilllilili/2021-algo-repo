def solution(s):
    answer = []
    sets = s[2:-2]
    sets = sets.split('},{')
    nums = {}
    all_nums = []
    for i in range(len(sets)):
        sets[i] = list(map(int,sets[i].split(',')))
        set_key = len(sets[i])
        nums[set_key] = sets[i]
        all_nums += sets[i]
    all_nums = set(all_nums)

    visited = {}
    for a_n in all_nums: visited[a_n] = 0

    for k in sorted(nums.keys()):
        for x in nums[k]:
            if visited[x]: continue
            else:
                visited[x] = 1
                answer.append(x)

    return answer

# 충격적인 다른분 풀이... 
# 가장 많이 나온 원소 순대로 정렬하면.. 되는 거여뜸...

import re
from collections import Counter

def solution2(s):

    s = Counter(re.findall('\d+', s))
    return list(map(int, [k for k, v in sorted(s.items(), key=lambda x: x[1], reverse=True)]))



solution("{{2},{2,1},{2,1,3},{2,1,3,4}}")
solution("{{4,2,3},{3},{2,3,4,1},{2,3}}")
