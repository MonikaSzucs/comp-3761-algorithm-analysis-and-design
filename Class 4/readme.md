# Class 4

## Quiz Questions
### Question 1
What is the basic operation in the code or psudocode shown below?

Algorithm MinDistance (A[0..x-1])
// Input: An array A[0..x-1] of numbers
dmin = infinity
for i = 0 to x-1 do
    for j = 0 to x-1 do
        if i != j and |A[i] – A[j]| < dmin then
            dmin = |A[i] – A[j]|
return dmin

> Note the vertical bars mean `absolute value` ie `positive value of`
> note a single = is used for assignment

Answer:
- the basic operation is the 
```
if i != j and |A[i] – A[j]| < dmin then
```
- this is a comparison of dmin

## Question 2
On which line are you most likely to find the basic operation in the java snippet shown below?

1. int sum = 0;
2. int []a = new int[n];
3. int []b = new int[m];
4. for (int i = 0; i < n; i++)
5.      for (int j = 0; j < m; j++)
6.          sum += a[i] / b[j];

Answer:
- line 6

## Question 3
top n-1 sigma bottom i = 1 (n+2)
What is the closed form for the summation shown above?

((n-1) - 1 + 1)n + ((n-1) - 1 + 1)2
n^2 - n + 2n - 2
n^2 + n - 2

## Question 4
n sigma i = 0 (n+1)
What is the closed form for the summation shown above?
(n - 0 + 1)n + (n - 0 + 1)1
n^2 + n + n + 1
n^2 + 2n + 1

## Question 5
n sigma i=2 (2)  + (n-1) sigma i = 0 (n)
What is the closed form for the summation shown above?
(n-2+1)2 + ((n-1)-0+1)n
2n - 2 + n^2
n^2 + 2n - 2

## Question 6
n-1 sigma i=1 (2i)
What is the closed form for the summation shown above?
2 * sigma i

2 * ((n-1 + 1)(n-1 -1+1))/2
n*(n-1)
n^2 - n

## Question 7
Consider the algorithm below. What is the output if the input is A[0,1,4,-1,2]?

Algorithm Secret(A[0..n-1])
// Input: An array A[0..n-1] of real numbers
minval = A[0]
maxval = A[0]
for i = 1 to n-1 do
    if A[i] < minval then
        minval = A[i]
    else if A[i] > maxval then
        maxval = A[i]
return (mixval - manval)

Note: a single = is used to indicate assigned in the above algo

Answer:
4 - (-1) = 5

## Question 8
Consider the algorithm below. What is the output if the input is A[-2,-1,0,1,2]?

Algorithm Secret(A[0..n-1])
// Input: An array A[0..n-1] of real numbers
minval = A[0]
maxval = A[0]
for i = 1 to n-1 do
    if A[i] < minval then
        minval = A[i]
    else if A[i] > maxval then
        maxval = A[i]
return (mixval - manval)

Note: a single = is used to indicate assigned in the above algo

Answer:
2 - (-2) = 4

## Question 9
Consider teh algorithm below. What is the output if the input is A[2,1,4,1,2]?

Algorithm Secret(A[0..n-1])
// Input: An array A[0..n-1] of real numbers
minval = A[0]
maxval = A[0]
for i = 1 to n-1 do
    if A[i] < minval then
        minval = A[i]
    else if A[i] > maxval then
        maxval = A[i]
return (mixval - manval)

Note: a single = is used to indicate assigned in the above algo

Answer:
4 - 1 = 3

## Question 10
Big of what is the big O of each? {use ^ for poers and 1 for big of of constant time}

20n^3 + 500n + 4
answer: n^3

n(2n+1)
answer: n^2

log(45) + 2
answer: 1

# Divide and Conquer (Chapter 5)
## This week
- divide and conquer technique
- count a specific key in an array
- master theorem
- Merge sort

## Divide and Conquer technique
A well known algorithm design technique

1. `Divide` instance of problem into two or more smaller instances
2. `Solve` smaller instances (usually recursively)
3. Obtain solution to orginal (larger) instance by `combining` these solutions

- easier to go recursive way

## A Natural Question
- how is this different from decrease and conquer technique?
- think of the fake coin problem:
-- we discarded half the coins at each step
-- so we didn't do any work on those "sub problems"

- for divide and conquer..
-- you need to solve all of the sub problems

## Exercise Divide and Conquer
Algo: findMinValue(A[1..n], s, e)
if s = e then
    return A[s]
mid <- floor((s + e) / 2)
lmin <- findMinValue(A[], s, mid)
rmin <- findMinValue(A[], mid+1, e)
if lmin < rmin
    return lmin
return rmin

## A Natural Question
- how is this different from decrease and conquer technique
- think of the fake coin problem:
-- we discarded half the coins at each step
-- so we didn't do any work on those "sub problems"

- for divide and conquer..
-- you need to solve all of the sub problems

## Count a specific key in an array
Problem
- count the number of times a specific key appears in an array
For example
- if input array is A=[2,7,6,6,2,4,6,9,2] and key=6..
should return the value 3

Design an algorithm using divide and conquer technique

## Solution Question 5-1
Algorithm CountKey(A[], L, R, Key)
// Input: A[] is an array A[0..n-1] from indices L and R (L <= R)
// Output: A count of the number of time Key exists in A[L..R]
1. if L = R
2.      if (A[L] = Key) return 1
3.      else return 0
4. else
5.      lCount <- CountKey(A[], L, Floor((L+R)/2), Key)
6.      rCount <- CountKey(A[], floor((L+R)/2)+1, R, Key)
7.      return lCount + rCount

The adding part is bigO(1)
a = 2
n/b = n/2  -> b = 2
F(n) = 1

CountKey looks familiar..
- whats the difference between binary search adn CountKey?

- we have to search both sides
-- in binary search, one half gets ignored if out of bounds
-- in CountKey, both sides are searched to get sum

## Analysis of dvide and conquer algorithms
T(n) = aT(n/b) + F(n)

b is about sub problem size
usually a and b are the same value but not always

## What is a and b for question 5-1?
n/b = n/2 so b = 2

n/b = n/2  =>  b = 2

7n/108 = n/b ->   108/7 = b

Fn how much time and big O of combining part - part of putting together
Tn - total time to solve size n problem

## Master Theorem
T(n) = aT(n/b) + F(n)

1) if n^logb(a) < F(n) then T(n) = O(F(n))
2) if n^logb(a) > F(n) then T(n) = O(n^logb(a))
3) if n^logb(a) = F(n) then T(n) = O(n^logb(a) * log n) or O(F(n) * log n)

Count Keys: T(n) = 2T(n/2) + 1 -> T(n) = ?
big O is n
a = 2
b = 2
n^logb(a) = n^log2(2) = n
F(n) = 1

conclusion: T(n) = O(n)

## Example
binarySearch(a[],k,start,end)
    if end < start
        return not found
    middle <- flour((start + end)/2)
    if k = a[middle]
        return found
    if k > a[middle]
        return binarySearch(a[],k,middle+1,end)
    else if k < a[middle]
        return binarySearch(a[],k,start,middle-1)

- with recursive operation we cannot work it out with basic operations because we dont see a loop
- we need sub problem - how many times you call yourself
a = 1
b = 2

- how many times you hit the return you only hit one ot the other so its 1
n/b = n/2  -> b = 2

- `in decrease and conquer F(n) is always equal to 1`

n^logb(a) = n^log2(1) = n^0 = 1
F(n) = 1

1 = 1 so 
T(n) = O(log n)

## Example
Alg(n)
    Alg(n/2)
    Alg(n/2)
    Alg(n/2)
    Alg(n/2)
    for each i in n
        for each j in n
            for each k in n
                do something

a = 4   // a is how many times you call yourself
n/b = n/2 -> b = 2   // b is 2 because each function call is n/2
F(n) = n^3 // we have 3 loops

n^logb(a) = n^log2(4) = n^2
big O is n^2

n^3 > n^2 our conclusion is the begger one  so T(n) = O(n^3)


## Example
T(n) = 4T(n/2) + n => T(n) = ?
a = 4
n/b = n/2 -> b = 2
F(n) = n
n^logb(a) = n^log2(4) = n^2
n^2 > n so T(n) = O(n^2)

## Example
T(n) = 4T(n/2) + n^2 => T(n) = ?
a = 4
n/b = n/2 -> b = 2
F(n) = n^2
n^logb(a) = n^log2(4) = n^2
T(n) = O(n^2 * log n)

## Pseudocode of merge sort
Algorithm MergeSort(A[0..n-1])
// Sort Array: A[0..n-1] by recursive mergesort
// Input: An array A[0..n-1] of orderable elements
// Output: Array A[0..n-1] sorted in nondecreasing order
if n > 1
    copy A[0..floor(n/2)-1] to B[0..floor(n/2)-1]
    copy A[floor(n/2)..n-1] to C[0..floor(n/2)-1]
    MergeSort(B[0..floor(n/2)-1])
    MergeSort(C[0..floor(n/2)-1])
    Merge(B,C,A)

## Merging
Implementation of Merge(B,C,A)
- important two sorted arrays (B and C) and merge it into an empty array (A)

- Example
B = {3 8 9} C = {1 5 7}
merge(B,C,A) = A = {1,3,5,7,8,9}

- must put the next smallest element into the merged list at each point
- each next-smallest could come from either list

## Pseudocode of Merge
Algorithm Merge(B[0..p-1], C[0..q-1], A[0..p+q-1])
// Merges two sorted arrays into one sorted array
// Input: Arrays B[0..p-1] and C[0..q-1] both sorted
// output: Sorted arrays A[0..p+q-1] of the elements of B and C
i <- 0; j <- 0; k <- 0
while i < p or j < q do
    if B[i] <= C[j]
        A[k] <- B[i]; i <- i + 1
    else A[k] <- C[j]; j <- j + 1
    k <- k + 1
if i = p  // this is used to copy over the remainder in one or the other arrays
    copy C[j..q-1] to A[k..p+q-1]
else copy B[i..p-1] to A[k..p+q-1]

Can this be optimized? (hint i or j maxes out?)
- merge function is a helper function
- it will loop through condition

basic operation?
if B[i] <= C[j] line 4 comparison
the number of items in B and C could be unlimited numbers we call O(n)

What is the a, b and f(n)
F(n) = n  - there is a loop so its not just 1 for the answer 
a = 2  
- 2 sub problems
b = 2 
- 2 different sections of the problem since we are talking about half

n^(logb(a)) = n^(log2(2)) = n^1 = n

n == n so 
O(nlogn)



