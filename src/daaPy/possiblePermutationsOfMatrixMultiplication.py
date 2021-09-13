def findPossiblePermutations(n) :
    val = 0
    k = 1
    if (n == 1) :
        return 1
    while(k != n) :
        val = val + findPossiblePermutations(k) * findPossiblePermutations(n - k)
        k = k + 1
    return val

n = int(input("Enter Number : "))
print(findPossiblePermutations(n))