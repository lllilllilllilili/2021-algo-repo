import sys
n = input()
arr = list(map(int, input().split()))

#평균
avg = round(sum(arr)/len(arr))
answer = int(1e9)

new_arr = []
print(avg)
print(arr)
for idx, value in enumerate(arr) :
    # tuple로 넣었는데 new_arr[0][1] 참조가 되네
    new_arr.append((abs(avg-value),idx))

new_arr.sort(key=lambda x : (x[0], -x[1]))
print(new_arr)
print(new_arr[0][1])

a=66.0
a+=0.5
print(int(a))