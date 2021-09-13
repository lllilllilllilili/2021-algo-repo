def convert_notation(n, base) : 
    T = "0123456789ABCDEF"
    if base == 0 :
        return '0'
    ret = ''
    while base > 0 :
        ret = T[base%n] + ret
        base = base // n
    return ret
    
def solution(n, t, m, p):
    answer = ''
    string = ''
    for i in range(t*m) :
        string+=convert_notation(n, i)
   
    for i in range(p-1, len(string), m) :
        if len(answer) == t : break
        answer+=string[i]
         
    print(answer)
    return answer