def matrixMultiplication(a, b) :
    if len(a[0]) != len(b) :
        raise Exception("Matrices cannot be multiplied!")
    else :
        rows, cols = (len(a), len(b[0]))
        c = [[0 for i in range(cols)] for j in range(rows)]
        for i in range(rows) :
            for j in range(cols) :
                for k in range(len(b)) :
                    c[i][j] = c[i][j] + a[i][k] * b[k][j]
        return c

arr1 = [[12, 7, 3],
    [4, 5, 6],
    [7, 8, 9]]

arr2 = [[5, 8, 1, 2],
    [6, 7, 3, 0],
    [4, 5, 9, 1]]

res = matrixMultiplication(arr1, arr2)

for element in res :
    print(element)