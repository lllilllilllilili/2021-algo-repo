def solution(files):
    answer = []
    result = []
    for idx, file in enumerate(files):
        name = ''
        nums = ''
        flag = False
        for x in file:
            if flag and not x.isdigit(): break
            if x.isdigit():
                flag = True
                nums += x
            else:
                name += x


        realNum = int(nums)
        result.append([name.lower(), realNum, idx, file])

    result.sort()
    for r in result: answer.append(r[3])

    return answer


solution(["img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"])
