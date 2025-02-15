# Notes

`Algorithm`: is a sequence of unambiguous instructions for solving a problem, i.e., for obtaining a required output for any legitimate input in a finite amount of time.

- The nonambiguity requirement for each step of an algorithm cannot be compromised.
- The range of inputs for which an algorithm works has to be specified carefully.
- The same algorithm can be represented in several different ways.
- There may exist several algorithms for solving the same problem.
- Algorithms for the same problem can be based on very different ideas and
can solve the problem with dramatically different speeds.

`Euclid’s algorithm` is based on applying repeatedly the equality
gcd(m, n) = gcd(n, m mod n),

 let us introduce a simple algorithm for generating consecutive primes not
exceeding any given integer n > 1. It was probably invented in ancient Greece
and is known as the `sieve of Eratosthenes`

Obviously, p . p should not be greater than n, and therefore p cannot exceed
√n rounded down (denoted √n

using the so-called `floor function`)

`ceiling` - closest whole number above x
`floor` - closest while number below x

## Permutations
`permutation` - is an arrangement in which order matters. ABC differs from BCA.

How amny `permutations` are there on a collection of 3 items of  A, B, C?
ABC
ACB
BAC
BCA
CAB
CBA

permuatations for a set n elements n!

## Subsets
Given a set of 3 items {a,b,c} how many different `subsets` can we make?
subsets are:
{a,b,c}, {a,b}, {a,c}, {b,c}, {a}, {b}, {c}

## Summations
- substitute i in formula for everything in between start and end then add results
- sum of a constant
- Changing the start and end
* We don't always start from 1 and end at n

### Sum of sums
- two parts added together

### Constant rule
- you can move the constant in front for any sum

## sum of sums
- you work from the inside to out

## Algorithm
1. Time efficency
- how lot it takes to check each array element for example
2. space efficency
- amount of memory

- A well thought out algorithm can run much faster
- there can be a big variation in efficiency

## Question to ask Tutor
* Question: How can we make the recursive approach run in almost the same time?


## Lesson 1
## Learning Outcomes
Algorithm Intro
- Origins, Time/Space Efficiency
Efficiency
- Basic Operations
- How to use Basic Operations to gauge efficiency 
Seven examples to put above into practice
Order of  Growth
- Types
- Big Oh

## What is an algorithm
inputs -> finite, ordered list of steps -> outputs

## What is an algorithm?
- how to cook a meal
- receipi- how to find your way home

## Example
- pseudocode of algo

Find the largest element in the array

```
ALGO find(A[0..n-1])
    m <- A[0]
    for i <- 1 to n-1 do
        if A[i] > m
            m <- A[i]
    return m
```

## Time Efficiency
Is find a time-efficient algorithm?
- Seems good
-- To find the largest, you need to check each array element  exactly once

```
ALGO find(A[0..n-1])
    m <- A[0]
    for i <- 1 to n-1 do
        if A[i] > m
            m <- A[i]
    return m
```

Is find a space-efficient algorithm? (amount of  memory )
- Again... it seems reasonable
- One temp variable introduced

- How about sorted array?
- Is find efficient for sorted array?

## Why do we care?
Think about computing the nth Fibonacci number:
- 0, 1, 1, 2, 3, 5, 8, 13, ...
- f(n) = f(n-1) + f(n-2)

```
Algo: fib( n )
    if n ≤ 1 
        return n
    else
        return fib( n-1 ) + fib( n-2 )
```

Now look at a different algorithm
```
Algo: fib2( n )
    F[0] ¬0; F[1] ¬1;
    for i ¬2 to n do
        F[i] ¬F[i-1] + F[i-2]
    return F[n]
```

## Difference
First approach (Recursive)
- Recursively calls the Fib function over and over again
Second approach (Iterative)
- Stores successive results so we don’t have to re-compute them ...
Second approach is much much faster.
- For n = 30 
- Running time of  first approach = 5957 microsecond 
- Running time of  second approach = 7 microsecond
Bonus: How can we make the Recursive Approach run in almost the same time?

## So?
- Fib is a basic example of  why we care about 
algorithm efficiency
- A well thought out algorithm can run much faster
- There can be big variation in efficiency

## How to determine efficiency?
- can do it experimentally
- The problem with that approach is that it is `time consuming` and `expensive` and it is not `accurate`
- want to `estimate` efficency `before` writing code

1. running time of an algorithm depends on the input size - size of `n` in f(n)
2. The efficiency for any algorithm depends on number of instructiosn executed - ex nested for loops vs single operations

- We define the basic operation of  an algorithm as the statement that gets executed most frequently.  Typically excluding the iterator (‘i’) assignments/comparisons.

## Basic Operations
- This is the fundamental concept we use to analyze algorithmic efficiency:
count the number of  basic operation executed for an input of  size n

- Using this idea, we would say for find 
- f(n) =n-1
- Because we don’t count instructions that are not basic operations

## The fundamental concept we use to analyze algorithmic efficiency
- count the number of basic operation executed for an input of size n

- basic operation is generally the most executed statement outside of the iterator (i or j) (operations/comparisons)

## Insertion Sort
```
1.  Loops (A[0..n-1])
2.      for i <- 1 to n-1 do
3.          v <- A[i]
4.          j <- i-1
5.          while j >= 0 and A[j] > v do
                A[j+1] <- A[j]
                j<-j-1
            A[j+1] <- v
```

top(n-1) sigma bottom(i=0) top(i-1) sigma bottom(j=0) 1
((n-1)n) /2

## Multiplication of two matricies pg 34
input size measure:
- matrix dimensions or total number of elements

basic operation
- multiplication of two numbers

```
ALGO MatrixMultiplication(A[0..n-1], B[0..n-1])
    for i <- 0 to n-1 do
        for j<-0 to n-1 do
            C[i,j] <- 0.0
            for k<-0 to n-1 do
                C[i,j] <- C[i,j] + A[i,k] * B[k,j]
    return C
```
C(n) = top(n-1) sigma bottom (i=0) top(n-1) sigma bottom(j=0) top(n-1) sigma bottom(k=0) 1 = n^3

## Calculating Sum pg 35
Input size measure:
- Number n
Basic operation: 
- Addition

```
1.  Example3 (n)
2.      0 <- sum
3.      i <- n
4.      while i >= 1
5.          sum <- sum+1
6.          i <- i/2
7.      return sum
```

C(n) = logn

## Best and worst case
- worst case
C(n) - maximum over inputs of size n
- best case
C(n) - minimum over inputs of size n

## Example 7pg 37 Searching for Key
Problem: Searching for key in a list of  n items
Input size measure:
- Number of list’s items,  i.e. n
Basic operation: 
- Key comparison

```
ALGO SequentialSearch(A[0..n-1], k)
    i<- 0
    while i < n and A[i] != K do
        i <- i + 1
    if i<n return i
    else return -1
```
worst: n
best: 1

## Which to use: Best, worst
- we will focus on `worst-case` analysis in this course
- unless otherwise sepcified, you should always analyze the worst case
- in some situations best case = worst case
- consider the algorithm to find the largest lement in an unordered array

## Example
For the computing n! (n factorial) determine:
1. its basic operation
2. basic operation count

## Example 2 in ppt
How many times is the basic operation executed for input size n?
first what is the content? answer is 1
When you try to put together the sigma the content of the sigma (the most inner sigma) the content  is always 1 because by defintion baisc operation the one single statement that will be executed most of the time. Any given solution/algorithm you analyse you should analyze only identify which line it is only 1 line
- always identify 1 line ONLY so the answer is 1
content is always 1

- Big 0n when we analyse effiencey we only care about worst case because best case is better it doesn't mean solution is better. It depends on worst case which solution is better. We care about worst case.
- when the conditions leaves the loop its called `early exit`

## Diagram order of growth
1. value of function
- how many times your function is executed
- this will take more time
2. increasing n
- we want the largest n

## Order of growth
1 < log sub(2)n < n < nlog sub(2)n < n^2 < n^3 < 2^n < n!

## Example:
which line here is the basic operation?

line 1   for i in range (0,20):
line 2      if i%2==0:
line 3          count++


just my 2 cents:
you will notice that  each lab question start asking you "what this algo does?" so take that as a starting point when you analyze which line of code  is the basic operation. 
in your example, step1, the purpose is to find the number of even number. and which line of code determine it ? Its line 2.
step2,  accourding to week1's slide, think about which line of code operates the most frequently? its still line 2 right.
Step3, which line of codes has the most complexity of operations? its still line 2 considering its more complex than just counting.  hope it makes sense


Answer Line 2 if i%2==0:


If-checking (Line 2) will be executed 20 times
If-block (Line 3) only run 10 times
You should be able to easily tell between Line 2 and Line 3 which operation is MORE frequent.

So you should choose the more frequent one to be your basic operation.

## General Strategy for Analysis of  Non-recursive Algorithms
This strategy is taken from page 62 of  your textbook:
1. Decide on a parameter indicating the inputs size.
2. Identify the algorithms basic operation.
3. Check whether the number of  times the basic operation is executed depends only on the size of  the input.
• if  it depends on some other property, the best/worst/average case efficiencies must be investigated separately
4. Set up a sum expressing the number of  times the basic operation is executed.
5. Use standard formulas and rules of  sum manipulation to find a closed form formula c(n) for the sum from step 4 above.
6. Determine the efficiency class of  the algorithm using asymptotic notations
 
## Big O in pictures
- Set of  all functions whose rate of  growth is the same as or lower than that of  g(n).

## find the max element in a list
Problem: Input size measure:
- Number of list’s items,  i.e. n
Basic operation: 
- Comparison

```
ALGO MaxElement(A[0..n-1])
    maxval <- A[0]
    for i <- 1 to n-1 do
        if A[i] > maxval
            maxval <- A[i]
    return maxval
```

C(n) = top(n-1) sigma bottom(i=1) 1 = n-1
O(n)


## Element uniqueness problem: pg 53
```
ALGO UniqueElements(A[0..n-1])
    // determines whether all the elements in a fiven array are distinct
    // Input: An array A[0..n-1]
    // Output: returns "true" if all the elements in A are distinct and "false" otherwise
    for i<-0 to n-2 do
        for j<- i+1 to n-1 do
            if A[i]=A[j] return false
    return true
```

- Parameter for input size: n, the size of  the array
•Basic operation: Comparison in the innermost loop
•Worst case efficiency count... nested loop
top(n-2) sigma bottom(i=0) top(n-1) sigma bottom(j=i+1) 1

O(n^2)
