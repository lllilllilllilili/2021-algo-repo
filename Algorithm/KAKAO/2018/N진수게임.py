import string
change_num = string.digits + string.ascii_lowercase
def convert_num(num, base):
    q, r = divmod(num, base)
    if not q: return change_num[r]
    else: return convert_num(q, base) + change_num[r]

def solution(n, t, m, p):
    answer = ''
    length = m*t
    nums = ''
    i = 0
    while len(nums) < length:
        nums += str(convert_num(i, n))
        i+=1

    for x in range(len(nums)//m):
        answer += nums[x*m+(p-1)]
    answer = answer.upper()
    return answer

#solution(2, 4, 2, 1)
solution(16, 16, 2, 1)
#solution(16, 16, 2, 2)
