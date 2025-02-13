# Class 5
## Lab 3
- just finished marking and will review in todays class

Binary search:
- decrease and conquer
- decrease by factor
- we only care about one side

Divide and conquer
- we do care about both halfs

### Notes
- you can put your solution i a loop its in decrease in conquer
- divide and conquer cannot usually be written in a loop

`Sequencial search (linear search)`
vs
`binary search`

|                                   |   consider both demention (n - how many words in wordlist.txt  / m - how many words to check)   | Only consider (n - how many words in wordlist.txt / 1 - discuss one word to check) |
| --------------------------------- |:-----:| -------:|
| Sequencial search (linear search) |   O(m*n)   |    O(n)    |
| binary search                     |   O(m*log n)   |    O(log n)    |
|                      |   acceptable   |   Acceptable     |

# Transform and conquer (Chapter 6)
This technique solves a problem by transformation to
1. `instance simplification`
- a more convient instance of the same problem
- total effiency solution because sorting becomes the bottle neck

2. `representation change` 
- a different representation of the same instance
- not talking about sorting it
- we put data into another type of data structure so that it will make things simpler. So it will make searching faster.

## Agenda
1. instance simplication (pre-sorting)
- checking elements unqiueness in an array
- computing a mode
2. Represntation change
- heap
-- implementation
-- insert and delete
-- construction
- heap sort

### Element Uniqueness in an Array
Brute force algorthm
- compare all pairs of elements
- efficeny (n^2)
-- all elements are unique
- you will be given a list of arrays they are all unique. 

Algo UniqueVal(a[0..n-1]) 
  for i <- 0 to n-1 do
    for j <- i + 1 to n-1 do
      if a[i] = a[j]

- we want to check if there are duplicates

Can we setup sigma to setup bigO?
(n-1)sigma(i<-1)  (n)sigma(j<-i+1) 1
(n-1)sigma(i<-1) (n-i-1+1)

nsigma(1) - sigma i
n(n-1) - ((n-1)(n))/2
n(n-1) / 2 = n^2/2 - n/2
big O(n^2)

- What is the better implementation?
- instance simplication (presorting)
`stage1` - sort by efficient sort algorithm (ex mergesort)  O (nlogn)
`stage2` - scan array to check pair of adjacent elements O(n)

nlog(n) this is better

## Element uniqueness in an array
ALGO PresortElementUniqueness(A[0..n-1])
  // solves the element unqiueness problem by sorting the array first
  // input: an array A[0..n-1] of orderable elements
  // output: returns "true" if A has no equal elements ""false" otherwise sort 
  sort the array A
  for i <- 0 to n-2 do
    if A[i] = A[i+1] return false
  return true

- what is the efficeny?
- sort? + scanning array?
O(nlogn) + O(n)
O(nlogn)

### Computing a mode
- a mode is a value that occurs most often in a given list of number
5,1,6,7,6,5,7,6
mode = 6

- if there is more than one that is the most frequent so the same number of times either one you choose is fine.

- this means you will need two loops
- when youahve two loops both are about n it matters how big the number is. If it is a fixed number then it doesn't count. This means Big O will be 1000n but is bigO(n) since we drop the 1000 constant

## Midterm
- he will give two loops and you have to tell him if its a big O(n^2) and why


### How do you solve this using brute force?
- we will use different counters
- think of an array - there is a slort for corresponding index 
- index will help find corresponding value
- big O for this would be O(n^2)
- you need tow loops for each element in array you need to scan over element in array to count how many accurance of it.
- another point is you cannot say because its two loops is n^2 when you have two loops make sure its both to the n but if one is a fixed number then it doesn't count towards the n
> This is a midterm question

## Computing a Mode
brute force
- scan the list
- computer the frequencies of all distict values
- find the value with the largest frequency

Efficiency (worst case):
- A list with no equal elements

- creating count list: 0 + 1 + 2 + ... + n - 1 = O(n^2)
- finding max: O(n)
Effiency of worst case: O(n^2)

## Midterm
- solve a problem with more than one solution
- you will solve based on different categories
- solving this with decrease and conquer part a
- part b divide and conquer

- he can also give part a solve with divide and conquer part b use transform and conquer
- maybe  you will need to solve problem with the two different types of transform and conquer - presorting and more specific representation change

### Computing a mode
- sort the input
- all equal values will be adjacent to each other
- find the longest run of adjacent equal values in the sorted array because after sorting its all together

ALGO PresortMode(A[0..n-1])
  // computes the mode of an array by sorting it first
  // Input: An array A[0..n-1] of orderable elements
  // Output: the array's mode
  sort the array A  // this ig O(nlogn)
  i <- 0              // current run begins at position i
  modefrequency <- 0  // highest frequency seen so far
  while i <= n-1 do
    runlength <- 1: runvalue <- A[i]
    while i + runlength <= n-1 and A[i + runlength] = runvalue
      runlength <- runlength + 1
    if runlength > modefrequency
      modefrequency <- runlength 
      modevalue <- runvalue
    i <- i + runlength
  return modevalue


### Is Pre-sorting Always better?
Problem: search for a given K in A[0..n-1]

Presorting-based algorithm
- stage 1: sort the array by an efficent sorting algorithm
- stage 2: Apply binary search

Efficeny: O(nlogn) + O(logn) = O(nlogn)
Good or bad? (sequencial search is O(n))
Why do we have our dictionaries, telephone dictionaries, etc sorted

## Sample Problem
- You're running a hospital
- patients are coming in with different priority
- How do you quickly decide who to treat next?
- [Radio Lab Podcast](http://www.radiolab.org/story/playing-god/)

### Simple implementation
7,5,8,1,9
Arraylist
- insert O(1)
- deleteMax O(n)

Sorted arraylist
9,8,7,5,1
- insert O(logn + n)  // logn is for binary search
- deleteMax O(n)

## Representation Change
Idea 
- given an array (not sorted)
- We want to Transform the array to a new data structure (make a `heap` out of it) (or called `priority queue`)

Efficiency of heap
- insert an item O(logn)
- delete an item with max priority O(logn)

### Heap definition
- almost complete binary tree
-- filled on all levels, except last, where filled from left to right
- every parent is great than (or equal to) child

- each node should not have more than 2 children
- complete tree all leaf nodes (nodes have no children) - on same level then on that level there is no missing leaf

- that is a `heap` because one leaf node is missing because it is almost complete but not yet
- missing node must be from right to left
- if we want to remove a leaf we need to remove the lowest leaf (lowest level) at the most right first

- a `complete binary tree` is when you have all the leaf nodes. Nothing is missing.
- missing leaf node must be from right to left

- `binary search tree` is different because we want the highest number at the top

## Two types of heaps
`maxheap` 
- parent greather than or equal to child
`minheap`
- opposite so every parent is smaller than or equal to children
- min value will be at root

- in the powerpoint we are looking at maxheap
- both have same common shape

## Heap or no heap Example PP Page 39
A. No, shape
B. no, value
C. Yes Heap
D. no, shape - short start nodes on left side of tree
E. no, shape and value - last node should be connected to 4 first - shape and value - 7 cannot be below 6
F. Yes, heap

### Heap properties
- max element is in root
- heap with N elements has height = floor(log2N)

- dont count root towards height

N = 6
height = 2
```
      9
    /   \
   5     8
  / \   / 
 2   4 6
 ```

### Heap Implementation
- we will start at index 1 for the root and nothing in index 0
So for the tree above we will have

```
0 1 2 3 4 5 6
  9 5 8 2 4 6
```
- use an array: no need for explicit parent or child pointers

Teachers example: 
```
Parent(i) = floor(i/2)
Left(i) = 2(i)
Right(i) = 2i + 1
```

Ekams Example
```
left = 2i+1  => 2i= (left-1) =>  i= (left-1)/2 => left/2+1/2 => left/2
right = 2i+2  => i=(right-2)/2 => right/2 - 2/2 => right/2 -1
```

### Heaps
draw the tree representation of this heap
- only end up with index 1

|     |    |     |    |    |    |    |    |    |    |    |    |    |    |
|:--- |:--:|:--: |:--:|:--:|:--:|:--:|:--:|:--:|:--:|:--:|:--:|:--:|:--:|
|Index|  1 |  2  |  3 |  4 |  5 | 6  |  7 |  8 |  9 | 10 | 11 | 12 | 13 |
|Value| 17 |  11 | 12 |  9 |  8 | 10 |  5 |  1 |  4 |  6 |  2 |  3 |  7 |

```
          17
       /      \
     11        12
    /   \      / \
   9     8   10   5
  / \   / \  / \  
 1   4 6   2 3  7
```

### Heap insertion
- insert into next available slot
- bubble up until it's heap ordered (heapify)

- logn
- each swap is based on level of tree
- height of tree is log(n)
- efficiency of O(logn)

- there is no index 0 in the array

### Delete max from Heap
- exchange root with right most leaf
- delete element
- bubble root down until it's heap ordered
- if you need to remove a mode you remove the right most leaf 

- need to compare with the larger childen bubbling down 1:55:00

## Heap Construction
Step 0: Initialize the structure with keys in the order given
Step 1: Starting with the last(right most) parental node, fix the heap rooted at it, if it doesn't satisfy the heap condition: Keep exchanging it with its largest child until the heap condition holds
Step 2: Repeat step 1 for the preceding parental node

- tree height is logn

## Example of Heap Construction
- Construct a heap for the list 2,9,7,6,5,8
Step 0: initialize the structure with keys in the order given
Step 1: starting with the last(rightmost) parental node, fix the heap rooted at it, if it doesn't satisfy the heap condition: keep exchanging it with its largest child until the heap condition holds

Construct a heap for the list 2,9,7,6,5,8

## HeapSort
How can we use a Heap sort to sort an arbitrary array?
1. transform the array into a heap (construct a heap)
2. call RemoveMax to get all array elements in sorted order

## Example of sorting by Heapsort
Sort the list 2,9,7,6,5,8 by heapsort

Stage 1 (heap construction)
2 9 `7` 6 5 8
2 `9` 8 6 5 7
`2` 9 8 6 5 7
9 `2` 8 6 5 7
9 6 8 2 5 7

Stage 2 (remove max)
9 6 8 2 5 7
7 6 8 2 5
8 6 7 2 5
5 6 7 2
7 6 5 2
2 6 5
6 2 5
5 2
5 2

1. exchange root with rightmost leaf
2. delete element
3. bubble root down until its heap ordered

## Analysis of Heapsort
Stage 1: build heap for a given list of n keys 
O(nlogn)
Stage 2: Repeat operation of root remove n-1 times (fix heap)
O(nlogn)

