# Chapter 2
- `time efficency` is calso called `time complexity` indicated how fast an algorithm in question runs.
- `space efficiency` also called `space complexity` refers to the amount of memory units required by the algorithm in addition to the space needed for its input and output. 

## Measuring input's size
- almost all algorithms run longer on larger inputs
- it takes longer to sort larger arrays, multiply larger matrices, and so on

`basic operation` 
- the most important operation of the algorithm. This is the operation contribution to the most of the total running time, and computer the number of times the basic operation is executed.
- its the most time consuming
- the most time consuming in operation is division, then multiplation, then addition, then subtraction

`order of growth` - the efficenty analysis framework ignores multilicative constants and concetrates on teh count's orther of grwoth to whichin a constant multiple for large-size inputs

- Algorithms that require an exponential number of operations are practical for solving only problems of very small sizes.
- n! grows faster but it is slower
- log(n) grows slower but it is faster

- The logarithmic function (log 𝑛) grows slowly. Even for very large 𝑛, logn increases at a much slower rate than functions like 𝑛 or  𝑛^2.  Algorithms that require logarithmic operations can handle very large inputs and still perform efficiently.

- On the other hand, factorial growth (𝑛!) is extremely fast. 𝑛! increases very rapidly even for relatively small values of n. For example, 100! is an astronomically large number, and its growth rate is much faster than that of logn. Even for moderately large 𝑛, the factorial function becomes impractical for computation.

`worst-case efficiency` - of an algorithm is its efficincy for the worse-case input of size n, which is an input (or inputs) of size n for which the algorithm runs the longest among all possible inputs of that size.

`best-case efficency` - an algorithm is its efficency for the best-case input of size n, which is an input (or inputs) of size n for which teh algorithm runs teh fastest among all possible inputs of that size.

`average-case efficency` - to analyze the algorithm's average case efficency, we must make some assuptions about possible inputs of size n.

`amortized efficency` - It applied not to a single run of algorithm but rather to a sequence of operations performed on the same data structure.

## Recap
- Both time and space efficiencies are measured as functions of the algorithm’s input size.
- Time efficiency is measured by counting the number of times the algorithm’s basic operation is executed. Space efficiency is measured by counting the number of extra memory units consumed by the algorithm.
- The efficiencies of some algorithms may differ significantly for inputs of the same size. For such algorithms, we need to distinguish between the worst-case, average-case, and best-case efficiencies.
- The framework’s primary interest lies in the order of growth of the algorithm’s running time (extra memory units consumed) as its input size goes to infinity

## Homework
### Question 2 pg 50
2. a. Consider the definition-based algorithm for adding two n × n matrices.
What is its basic operation? How many times is it performed as a function
of the matrix order n? As a function of the total number of elements in the
input matrices?
C = A + B
where c = a ​+ b

n x n = n^2

C = n^2 + n^2 = 2n^2 -> it will still be n^2
The basic operation is n^2 times even though the total number of elements in two input matricies is 2n^2

2. b. Answer the same questions for the definition-based algorithm for matrix
multiplication.

c subscript(ij) = top(k=1) ∑ bottom(n) = a subscript(ik) x b subscript(kj)
​
n^2 x n = n^3
n^3 - n^2
th enumber of basic operations is n^3 for n^3 - n^2

### Question 5 pg 60
smallest to largest order of growth
ln^2(n) < 5lg(n+100)^10 < n^(3/2) < 0.001n^4 + 3n^3 + 1 < 3^n < 2^(2n) < (n-2)! 

### question 5,6 pg 68

5. 
line 1  ALGORITHM Secret(A[0..n − 1])
            //Input: An array A[0..n − 1] of n real numbers
line 2      minval ← A[0]; maxval ← A[0]
line 3      for i ← 1 to n − 1 do
line 4          if A[i] < minval
line 5              minval ← A[i]
line 6          if A[i] > maxval
line 7              maxval ← A[i]
line 8      return maxval − minval

5. a What does this algorithm compute? the difference between the largest and smallest number
5. b what is its basic operation?
line 4 if A[i] < minval
line 6 if A[i] > maxval
both are the operation and depending which one runs more often
5. c how many times is the basic operation executed
There are two comparisons
A[i] < minval
A[i] > maxval
The total number of basic operations is 2 x (n - 1) = 2n - 2 = n

5. d what is the efficency class of this algorithm?
The number of basic operations is 2n-2 which is linear in terms of n.
the algorithm perform sa constant amount of work (2 comparisons) for each element in the array (except for the first one)
The time complexity is O(n) where n is the size of the input array
The efficiency class of the algorithm is O(n)

5. e suggest an improvement, or a better alhorithm altogether, indicate its effienct class. If you cannot dit, try to prove that, in fact, it cannot be done.

The algorithm is already really efficent for the task it performs. To compute the range of an array, you need to examine each element at least once to determine the minimum and maximum values. Hence, this algorithm performs a linear scan of the array which is optimal in terms of time complexity for this specific task. 

6. Question

line 1  ALGORITHM Enigma(A[0..n − 1, 0..n − 1])
            //Input: A matrix A[0..n − 1, 0..n − 1] of real numbers
line 2      for i ← 0 to n − 2 do
line 3          for j ← i + 1 to n − 1 do
line 4              if A[i, j ] =/= A[j, i]
line 5                  return false
line 6      return true


6. a What does this algorithm compute?
This algorithm computes to see if the matrix is symmetric or not. If it is not symetric then the algorithm returns false. If the matrix is symmetric then it returns true.

6. b. What is its basic operation?
The basic operation is line 4 A[i,j] =/= A[j,i].

6. c. How many times is the basic operation executed?
(n-1)-(i+1)+1 = n-i-1
(n-2)-0+1 = n-1
((n-2+1)-0+1)(n-2)/2 = n(n-1)/2
(n-2)-0+1 = n-1

The total number of basic operations is n(n-1)/2 and the time complexity is O(n^2)

6. d. What is the efficiency class of this algorithm?
The efficiency of the algorithm is O(n^2)

6. e. Suggest an improvement, or a better algorithm altogether, and indicate its efficiency class. If you cannot do it, try to prove that, in fact, it cannot be done.
The algorithm performs a comparisonf ro each pair of elements  A[i,j] and 𝐴[𝑗,𝑖], and checks for symmetry.\The algorithm is already optimal in terms of its complexity of O(n^2)
no improvement is needed