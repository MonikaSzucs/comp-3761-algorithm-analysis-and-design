# Class 2

# Example 1
If we have a if block then a else if - if we need to compare between if and else if then what will run more freqeunetly is the if. There is no condition for checking the if because it has to.

if we have a if then a loop inside then the loop will run more then the if 

if...
      for...
The for will run more times since if condition only runs once. For is n times but if is 1.

# Example 2
- forloop then if inside
for ....
    if...


## Example 3
for ...
    statement A
    statement B
    statement C

They will ideally run the same times. Statement A B or C but on midterm or exam always go with the first one

## Example 4
nested loops
for ...
      for ....
             statement A
- choose statement A. The inner loop runs more times.

## Example 5
Which line to choose for basic operation
for ...
      for ....
             statement A
for ...
      statement B

- Statement A. because statement A will run more times.

## Example 6
for i <- 1  to 10
      for j <- 1 to 100
             statement A
for k <- 1 to n
      statement B

- statement A will always run 1000 times which is lower and smaller than B because statement B is a super big postitive number which will be bigger than 1000 times. Statement B can run n number of times which can be super big.


- look at the most inner loop and if its about n
- statement A is most inner loop from last example but its not about n
- but if one level is about n then its one level

- I find the most inner loop then choose next line of the for loop

- when i ask for `basic operation and which line you must show both`
- We only have one line for the basic operation.

Does the AND operation count towards the basic operation?
- no the logical and usually not focus on `comparison` and `assignment` 
- you are on the wrong direction if you are using AND
- dont choose the line of the loop choose the line after it.
- when we have two possible solution the way we choose which one is better we are looking for - we are considering the worst case which one is still better

- `Early exit` when you have a if condition to leave the loop this is a good thing. When we decide which algo to use we only consider the worst case. The early exist is the `best case` = early exit
- Any early exist should be ignored

- we evaluate using the worst case

Ex
loops(A[0..n-1])
      for i <- 1 to n-1 do
            v <- A[i]
            j <- i-1
            while j>=0 and A[j]>v do
                  A[j+1] <- A[j]          // this is the basic operation
                  j <- j-1
            A[j+1] <- v
A[J] is coming from the user and we have no control so we can ignore it because it could be a early exit

The operation is assign value

### Calculation from above equation time 33:26 class 2
top(n-1) sigma bottom(i<-1) · top(0) sigma bottom(j<-i-1) 1
top(n-1) sigma bottom(i<-1) · top(i-1) sigma bottom(0) 1 // we can swap the top and bottom. i is the constant, i will be solved later

top(n-1) sigma bottom(i<-1) · (i-1) - 0 + 1 = top(n-1) sigma bottom(i<-1) i

top(n-1) sigma bottom(i<-1) i = ((n-1)(n-1 + 1))/2 = ((n-1)n)/2

This is O(n^2) (we can ignore constant and non significant terms)

### Some options to choose from: ***
- assignent
- comparison

## Best and Worst Case
For some algorithms efficeny depends on form of input
Worst case: C sub(worst)(n) - maximum over inputs of size n
Best case: C sub(best)(n) - minimum over inputs of size n

If they fall in teh same worst case? How do we choose but we can chosoe either way but we can also choose the average case then.

## pg 31 powerpoint
assign value line 6 A[j+1] <- A[j]


## Example
n(n-1) / 2 
(n^2)/2 - n/2 -> drop the least significant term and also the term = n^2
the big O is the n^2
O(n^2)

---
n/2 = O(n)

- if you dont know the average case you can also calculate the average effeciency between best and worst
(best + worst) / 2
(n + 1) / 2 = O(n)

- its not great if you get 2^n or n! because it will be too slow. 

## Order of growth
1 < log sub(2)n < n < nlog sub(2)n < n^2 < n^3 < 2^n < n!

- if your solution doesn't get impacted by how many times something is imputed then it will be O(1) this is just a constant

## Pg 41
- sometimes you will need to figureout the crosspoint to make sure you choose the input size bigger than it. Or else something lower then it you will have the wrong conclusion. 

- lower time is better for usthe y axis is time

## WHATS BETTER ** IMPROTANT pg 44 of powerpoint add infrom of log(n)
Whats better to log(n) is 1






# Chapter 3
`brute force` 
- the most `straight forward` approach for solving a problem
- no formal defintion
- not really trying to be efficent
- typically these are easy to implement
- "force" comes from using computer pwoer not intellectual power or "just do it"

- ex if you forgot your 3 digit password you need to guess the numbers from 000 -> 999 until you get it open. So you will check maybe 1000 different numbers

- brute force is not always the most effienct solution

## Brute Force Example
What is a brute force vs sophisticated solution for the following?
1. finding a name in a phone book
2. calculating a fibonnacci number 

## Selection Sort 1:00:00
1. scan the array to find the smallest element
2. swap it with the first element (That index is now sorted)
3. Repeat for the second smallest element
4. Generally: on pass i, find the smallest element in A[i..n-1] and swap it with A[i]

## Sort
- we swap using a index

When you are asked to get 
Selection sort is  O(n^2)
- it will then find the fixed position from left to right

## question find the number in the array
Write an algo to figure out the minimum value of a given array
Line 1  findMin(A[1..n])
Line 2      min <- A[1]             //  min <- 0 is bad
Line 3      for i <- 2 to n-1 do
Line 4          if A[i] < min
Line 5              min <- A[i]
Line 6      return min

pay attention what is given to you 
findMin(A[1..n]) // this means it starts at 1  `IMPORTANT FOR EXAMS`

## Question find the index
Algo: findMinIndex (A [1..n])
Starts at 1
Line 1  findMin(A[1..n])
Line 2      min <- 1            //  not A[1]
Line 3      for i <- 2 to n do
Line 4          if A[i] < A[min]
Line 5              min <- i  // not A[i]
Line 6      return min

- most inner loop and choose the line below it. this mean we choose line 4 it runs more times


## Another Question
Algo: findMinIndex (A [0..n-2])
Line 1  for i <-0 to n-2 do
Line 2      min <- i           
Line 3      for j <- i+1 to n-1 do
Line 4          if A[j] < A[min]
Line 5              min <- j  
Line 6      swap A[i] and A[min]

upper(n-2) sigma lower(i<- 0) upper(n-1) sigma lower(j<- i+1) 1

upper(n-2) sigma lower(i<-0) n-1 - (i+1) + 1 = upper(n-2) sigma lower(i<-0) n-i-1
upper(n-2) sigma lower(i<-0) n-i-1 = then apply the forumla end up with n^2

## Bubble sort
- the bubble sort makes multiple passes through a list. 
- In each pass of the list, the algorithm compares adjacent items and exchanges those that are out of order. 
- Each pass through the list places the next largest value in its proper place. 
- In essence, each item bubbles up to the location where it belongs

- button sort end up in O(n^2)
- the double for loop is like a brute force
- it will then find the fixed position from right to left

Algorithm BubbleSort(A[0..n-1])
line 1      for i<-0 to n-2 do 
line 2            for j<-0 to n-2-i do
line 3                  if a[j+1] < A[j]
line 4                        swap A[j] and A[j+1]
O(n^2)

- brute force are NOT better efficency

## String matching
- finding a word through a paragraph. Pattern is the specific word we are trying to find

input
- pattern: A string of m characters to search for
- text: A longer string of n characters to search in

problem
- find a substring in the text that matches the pattern

## page 25 of powerpoint lesson 2 String matching finding comparison
- 3rd comparison a and c dont match is the mismatch
- next we did 4 comparison
- next we did 5 comparison
- next we did `9` comparison TOTAL - this is the final answer *** ON QUIZ/MIDTERM

##
The outer loop shows you the  n-m+1 is the max alignment

for i<-0 to n-m do
      j<-0
      while j < m and P[j] = T[i+j] do
            j<-j+1
      if j=m return i
return -1

max alignment is. for each alignment how much will you end up with?
(n-m+1) * m

for each alignment how much will you end up with?

## pg 25  1:40:00
m = 4  the length of the patern abaa
n = 13 the length of the text
the last alignment  does not count the last few values in the n 
possible align matching is  10

13 - 4 + 1 = 10 

- always do m comparison

worst case running time
O((n-m+1)m)

- there are m comparisons for each shift int eh worst case (inner loop)
- there are n-m+1 shifts (outer loop)
- So the worst case runnign tiem is O((n-m+1)m)
- in the example for previous slide we have (13-4+1)4 comparisons in total
- n is always bigger than m

## brute force optimization
- generate a list of all potential solutions to the problem in a systematic manner
- evaluate potential solutions one by one, disqualifying infeasible ones, and keeping track of the best one found so far
- when search ends, announce the solution(s) found

## password cracking
- what is the brute force mechnaism fro figuring out someone's password?
-- guess very posibilitiy
- what is the complexity of it?
m = number of characters to choose from (26 for lowercase alphabet)
n = character length
Complexity = m^n 
password of 7 characters would take 26^7 (8,031,810,176) guesses


## knapsack problem
- we have a certain backpack that can carry a certain weight. We can carry some food that weights a certain much and costs a specific amount
how much can you carry? for best optimization

- capacity of W = 16
item        weight      value
1           2           $20
2           5           $30
3           10          $50
4           5           $10

- generate all possible `subset` so of the n items
- compute total weight of each subset
- identify feasible subsets
- find the subset of the largest value
{2,2,2,2,2,2,2,2}, {5,5,2,2,2} and so on...

- brute force is the only option for this knapsack proble

2^n (worst one) possible combinated - loop through if they are over the weight limit
we want to figureout the biggest value
- we dont have a better solution so we can only use this solution with very low value of n
big O(2^n) - this is a very slow solution

## comments on brute force
- Brute force (exhustive search algorithm) run in a realistic amount of time only on very small instances
- in many cases, exhustive search or its variable is the only known way to get exact solution

## Brute force strengths and weaknesses
### Strength
- wide applicability
- simplicity
- yields reasonable algorithms for some important problems
-- matrix mult
-- sorting
-- searching
-- string matching

### Weakness
- rarely yeilds effienct algorithms
- some brute-force algorithms are unacceptably slow
- not as constructive as some other design techniques

- with sorting it is actually slower


## Which one is the basic operation
- you can only choose ONE line
- choose the next line of the most inner loop