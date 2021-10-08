### [LCS](https://www.acmicpc.net/problem/9251)

ACAYKP
CAPCAK
문자를 하나씩 늘려가면서 비교합니다.

1. 글자가 같으면
   두 글자가 추가되기 전 가장 큰 길이 +1을 저장합니다.
   `matrix[i][j] = matrix[i-1][j-1]+1`

2. 글자가 다르면
   기존 문자열로 만들 수 있는 최대 길이를 갖게 됩니다.
   `matrix[i][j] = max(matrix[i][j-1], matrix[i-1][j]`
