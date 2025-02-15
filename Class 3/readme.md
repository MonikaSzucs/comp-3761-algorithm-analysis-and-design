# Class 3 - Decrease and Conquer

## There are two types of decrease by conquer
1. decrease by one
2. decrease by half

## Topics we will cover:
1. introduction to decrease and conquer
2. decrease by one
- insertion sort
- generating permutations
- generating subsets
3. decrase by half
- binary search
- fake coin problem

Only if the question asks for big O then you drop the constants. If it is just asking for the basic operation you need to show the entire equation with constants

Lab 2 asking for analysis of big O
among the three solutions you ahve a conslusion
when you observe on your machine it may not match your conclusion

## Lab 2
- can submit word or pdf
- take the extra step to analyize why it does not match based on what is observed and what is the actual - I know its already about the crosspoint
- its really small and simple don't over think it

## Decrease and Conquer
1. reduce problem instance ot smaller instance of the same problem and solve smaller instance
2. Extend solution of smaller instance to obtain solution to original instance

Can be implements:
- top-down (Recursive)
- bottom-up (iterative)

## Top-down pg 5
n
n-1
n-2
n-3
...
...
1

## Example Top-down (Resucrsive)
Factorial(n)
    if n = 1 then
        return 1
    else
        return Factorial(n-1) * n

Factorial(5) = ?

4x3x2x1 * 5
3x2 * 4
2x1 * 3
1*2
1

- for any decrease and conquer solution, you could either write it out as a iterative way or a recursive way

## Bottom up (Iterative) pg 6
Factorial(n)
    F <- 1
    for i<-1 to i <-n
        F<- F * i
    return F

Factorial(5) = ?

F = 120
F = 24
F = 6
F = 2
F = 1

- you save solve a problem with their recursive or Iterative

To find big O for today we will use Iterative

For any decrease and conquer solution you can write it out as Iterative way or recursive way so you dont need to worry about it

## Decrease by One
- insertion sort

- by one means a constant - so it can be the number 1,2,3 etc 
- can also be called `decreased by a constant`

## Powerpoint slide 9
1. problem of size n 
convert to
2. sub problem for size n-1
to
3. solution to the subproblem
then bring step 1 and 3 together to the: 
4. solution to the original problem

### Example Decrease by one (insertion sort) pg 10
```
Loops(A[0..n-1])
    for i <- 1 to n-1 do
        v <- A[i]
        j <- i-1
        while j>=0 and A[j]>v do
            A[j+1] <- A[j]
            j <- j-1
        A[j+1] <- v
```
n
n-1
n-2
n-3
...
...
1

## 1.1 Insertion sort (resursive)
### Example
InsertionSort(A,n)
    if n > 1
        InsertionSort(A, n-1)
        key <- A[n-1]
        i = n-2
        while i >= 0 and A[i] > key
            A[i+1] <- A[i]
            i <- i - 1
        A[i+1] <- key

- it tried to compare with the previous one
5,2,4,6,1,3
5
5,2
2,5,4
2,4,5,6
2,4,5,6,1
1,2,4,5,6,3
1,2,3,4,5,6

** recursive decrease

## Exercise Decrease and conquer with iterative way (loops)
Requirement: find and return the minimum value in A[]. Write it in looping
- Algo: find Min (A[0..n-1])

- your remaining to do is one less when you initialized it at line 2
1 Min(A[0..n-1])
2    x <- A[0] // we need the initial value in order to start comparing
3    for i <- 1 to n-1 (do)  // the A[0] is already handled outside the loop so start at 1 
4        if x > A[i] (then)
5            x <- A[i]
6    return x

Which line is the basic operation? if x > A[i] (then) the comparison line 4
What is the big O? O(n)
How many times is you operation executed? 
answer: n-1-1+1 = n-1
- we skip index 0 because we already put it in min <- A[0] we already handled it outside the loop so we actually start at 1

## Decrease by one - Generating Permutations
To find all permutations of n objects
- find all permutations of n-1 of those objects
- insert the remaining object into all possible positions of each permutations of n-1 objects


Example to find all permutations fo 2 objects A,B,C
- find all permutations of 2 objects say B and C:
BC and CB
- insert the remaining object A into all possible positions in each of the permutations of B and C:
ABC BAC BCA and ACB CAB CBA

### Example find all permutations
ABC     ACB CAB CBA ABC BAC BCA
BC      CB BC
B       B

generatePermutations (n elements a1, a2, ..., an)
    if n = 1
        return a1
    if n > 1
        permutations <- generatePermutation(n-1 of elements a1, a2, .., a(n-1))
        for each p in permutations
            insert an before a1
            for i <- to i <- n - 1
                insert a sub(n) after a sub(i)

What is the bigO for this? n!

## Exercise Decrease and Conquer with Iterative way (loops)
Requirements: find and return the count of given value K in A[]
- arrow means assign points to left
- one equal means checking

Algo: findMin(A[0..N-1], k)
    count <- 0;
    for i <- 0 to n-1 do        
        if A[i] = k             // one equal is same as double equal in actual checking
        count <- count + 1
    return count

so does it mean if in our code we have a for loop and a if inside, we consider it is decrease and conq??
- no

- if you have two loops its it still decrease and conquer? Yes because its not about how many loops you have. Its more about the remaining problem size. The remaining problem size shrinked by 1 which is decrease and conquer.

- after each loop its to do has one less. what you ahve to check is one less

- after we check out current i then the current i will increment so its one less
- its not about how amny loops you have its more about the remaining problem size. The remaining problem size shrinked by 1

## Generating subsets
What is  a subset?
For {a,b,c}
To find al subsets of n objects
- find all subsets of n-1 of those objects
- for each subsets copy it and insert the remaining object to the subset
- Example find all subsets of {A,B,C}

{A,B,C}     {},{B},{C},{BC},{A},{AB},{AC},{ABC}
{B,C}       {},{B},{C},{BC}
{B}         {},{B}
{}          {}


## Generate permutations
generateSubsets(n elements a1, a2, .., an)
if n = 0
    return empty set
if n>0
    subsets <- generateSubsets(n-1 elements a1, a2,...a(n-1))
    for each subset s in subsets
        clone s
        insert a(n) to the s

- populate two sets - shows decrease and conquer for the last two lines


# Decrease by half
- make the porblem `smaller by some constant factor`
- typically the constant facor is two, ie we divide the problem in half. It could be 1/3, 1/4 but as long as each iteration its always  aporportion you are using called decreased by half or `decreased by constant factor` or `decreased by factor`

## binary search
binart search, k =1
sorted array
- we are trying to find whether or not the target value is in there or if you are finding the index for it.
- your input array much we sorted for binary search

linear or sequenial search we just scan it. It is also decrease and coquer but decreases by 1.
- for decrease by half - if it is existing in the array then it will either be before or after the middle position. We can know and narrow down faster then sequencial search
- finary search works by dividing the sorted array (ie the solution space) in half each time and searching in the half

## psuedocode
- you try attempt to write pseudocode implement

- dont use a for loop do a while loop because you dont know how many times it needs to run
- start and end are the index

## Iterative solution
binarySearch(a[],k,start,end)
    while start ≤ end do
        mid ← (start + end) / 2
        if a[mid] = k then
            return mid
        else if a[mid] < k then
            start ← mid + 1
        else
            end ← mid – 1
    return -1

## Recursive solution
binarySearch(a[],k,start,end)
    if end < start
        return not found
    middle <- floor((start+end)/2)
    if k = a[middle]
        return found
    if k > a[middle]
        return binarySearch(a[], k, middle+1, end)
    else if k < a[middle]
        return binarySearch(a[],k,start,end)

## Binary search effiiency
- each step you decrease by half

## binary search efficency
- time efficency
-- worst case effiency
--- C(n) = log2(n+1)
--- so binary search is O(logn)
    this is VERY fast Ex C(1000000) = 20
- optimal for searching a sorted array
- limitations: must be sorted array

- if we don't know if it is sorted then we have to treat it as not sorted
- can we sort it then do binary search? thats not a good idea
- for linear search or sequencial search its BigO(n)
- for any sorting itself without binary search is already bigO(nlogn) its slower than sequenctial search
- if we dont know if it is sorted then it is not sorterd then we should choose sequencial search or linear search

## Decrease by half - Fake coin problem
Assume that you have `n identical looking coins`, but` one is fake (weighs less)` you also have a balance scale, and can compare any two sets of contains.
Design an efficent `Decrease by a constant Factor` algorithm that finds the fake coin.

- put half of the coins on each side and see which side has the lighter coin
- then you move to lighter half and put a reserved coin back to there

Can we do better?

`Q1` assum that n=2 how many time swill you need to wrigh the coin?
- one wright conparisons are needed

`Q2` Assume that n=4 how many times will you need to wrigh the coins? give tow answers, one for the best case and one for the worst case.
worst case: 2 weight comparisons are needed.
best case: 2 weight comparisons are needed

`Q3` Assign that n=8 how many times will you need to weight the coins? Give two answers, one for the best case and one for the worst case
Worst case: 3 weight comprisons are needed
best case: 3 weight comparisons are needed
> log2n

`Q4` Assume that n=9. How many times will you need to weigh the coins? Give two answers, one more the best case and one for the worst case.
Worst case: 3 weight comparisons are needed
best case: 1 weight comparisons are needed
> log2n

`Q5` Write the psudocode for your solution to this problem
fakeCoint(n coins):
    if n=1 the coin is fake
    else
        if n is odd
            remove first coin c0 and set aside
        else
            divide remaining coins into two piles c1 and c2 each with [n/2] coins
        weigh the two piles
        if they weigh the same
            c0 is the fake
        else
            discard the heavier pile and set n=[n/2]
        fakeCoin(remaining pile)


## Fake coin problem
- this solution is O(log2n)
-- it involves dividing the problem in half every time
- is there a better solution?
-- hint: yes it runs in O(log2n)
-- divide into 3 piles, weigh two of them
-- if different
--- continue with the lighter one (1/3 of the original)
-- if same
--- continue with the unweighted pile (1/3 of the original)

- the base doesn't matter

