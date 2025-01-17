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
Given a set of 3 items {a,b,c} how many different subsets can we make?
subsets are:
{a,b,c}, {a,b}, {a,c}, {b,c}, {a}, {b}, {c}

## Summations
- substitutei in formula for everything in between start and end then add results
- sum of a constant
- Changing the start and end
* We don't always start from ` and end at n

### Sum of sums
- two parts added together

### Constant rule
- you can move the constant in front for any sum

## sum of sums
- you work from the inside to out

## Algorithm
1. Time efficency
- how lot it takes to check each array element for example
2. space efficeny
- amount of memory

- A well thought out algorithm can run much faster
- there cnabe a big variation in efficiency

## Question to ask Tutor
* Question: How can we make teh recursive approach run in almost the same time?


## How to determine efficiency?
- can do it experimentally
- The problem with that pproach is that it is `time consuming` and `expensive` and it is not `accurate`
- want to `estimate` efficency `before` writing code

1. running time of an algorithm depends on the input size - size of `n` in f(n)
2. The efficiency for any algorithm depends on number of instructiosn executed - ex nested for loops vs single operations

## The fundamental concept we use to analyze algorithmic efficiency
- count the number of basic operation executed for an input of size n

- basic operation is generally the most executed statement outside of the iterator (i or j) (operations/comparisons)

## Multiplication of two matricies
input size measure:
- matrix dimensions or total number of elements

basic operation
- multiplication of two numbers

## Best and worst case
- worst case
C(n) - maximum over inputs of size n
- best case
C(n) - minimum over inputs of size n

## Question to ask
Example 7 in powerpoint
page 39

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
When you try to put togeter the sigma the content of the sigma (the most inner sigma) the content  is always 1 because by defintion baisc operation sit eh one single statement that will be executed most of the time. Any given solution/algorithm you analyse you shoudl analyze only identify which line it is only 1 line
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

 
 
