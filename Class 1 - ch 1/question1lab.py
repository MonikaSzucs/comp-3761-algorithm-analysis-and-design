A= [42, 17, 18, 23, 37, 9]
n=len(A)
Count= [0, 0, 0,0,0,0]
for i in range(0,n-2+1):
    for j in range(i+1,n-1+1):
        if A[i] < A[j]:
            Count[j]=Count[j]+1
        else:
            Count[i]=Count[i]+1
    print(i)
    print(Count)