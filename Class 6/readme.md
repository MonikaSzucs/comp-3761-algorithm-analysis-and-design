# Class 6

## Reminder
- Design means pseudocode and implement means java code?

## wording
- position means +1


## Space-time tradeoff
- `space` refers to the memory consumed by an algorithm to complete its execution.
- `Time` refers to the required time for an algorithm to complete the execution.
- Best algorithm to solve a problem is one that 
• Requires less memory and
• Takes less time to complete

> In practice it is not always possible 

- We have to sacrefice one at the cost of the other
- if space is our constraint, then we have to choose an algorithm that requires less space at the cost of more execution time. (example: Bubble sort)

- if time is our constraint then we have to choose an algorithm that takes less time to complete its execution at the cost of more space. (example: Mergesort)

## Space-for-time tradeoffs varieties
1. input enhancement: preprocessess the input to store some info to be used later in solving the problem
- comparison counting sort
- distribution counting sort
- string matching

2. Pre-structuring: using extra space to facilitate faster access to the data
- hasing
- hash function
- collision handling
- efficency of hashing

## Comparison Counting Sort
`Idea`: for each element of  a list to be sorted, count the total number of elements smaller than this element and record the results in a table.

- Move each input element to it’s corresponding position

```
121 9106    213 7185 6 9978 6111 43 8290 136    input
2   8       4   6    0 9    5    1  7    3      Count

6 43 121 136 213 6111 7185 8290 9106 9978 output
```

```
Algorithm ComparisionCountingSort A([0..n-1])
    for i  0 to n-2
        for j  i+1 to n-1
            if input[i] < input[j]
                Count[j]++
            else
                Count[i]++
for i  0 to n-1
    output[Count[i]]  input[i]
```

- Efficiency:
-- it is O(n2)
--- But of  course we have other sorts (mergesort, heapsort) that are O(nlogn)

## Distribution Counting Sort
Sort a known range of  numbers
- Playing cards
- People by birth date or age
- Seinfeld episodes from best to worst... 
-- trick scenaio, they are all amazing

### Distribution Counting Sort Concept
1. Sum the occurrence of each number (There are three 1’s, five 2’s, etc)
2. Reserve a spot for each set of  occurrences in return array
3. Fill in return array with the values

```
Source 4 1 3 4 3    Return  1 3 3 4
                            1’s 3’s 4’s
```

pg 28

```
Algo DistributionCountingSort (A[0.. n-1])
    for j <- 0 to u-l do
        C[j] <- 0
    for i <- 0 to n-1 do
        C[A[ i]-l] <- C[A[ i]-l] + 1
    for j <- 1 to u-l do
        C[j] <- C[j-1] + C[j]
    for i n-1 downto 0 do 
        j <- A[ i]- l
        S[C[ j] -1] <- A[ i]
        C[ j] <- C[ j] –1
    return S
```
u = largest number in ‘A’
l = lowest number in ‘A’
n = length of ‘A’

- Initialize array ‘C’ to all 0’s
- Sum the frequency of  each  number
- Reserve index in ‘S’ for each set of  numbers
- Decrement reserved count and  add to array ‘S’

- there are 4 general steps/4 for loops

### Distribution Counting Sort- example
A:

u = largest number in ‘A’
l = lowest number in ‘A’

u :4
l: 1

‘C’ length: u  - l+1 = k = 4

### Loop 1: initialization
A: 4,1,3,4,3
C: 0,0,0,0

for j <- 0 to u-l
    do C[j] <- 0

Initialize array ‘C’ to all 0’s

### Loop 2: count
A: `4`,1,3,4,3
C: 0,0,0,1

Sum the frequency of  each number

for i <- 0 to n-1
    do C[A[ i]-l] <- C[A[ i]-l] + 1

Sum the frequency of  each number
A: 4,`1`,3,4,3
C: 1,0,0,1

for i <- 0 to n-1
    do C[A[ i]-l] <- C[A[ i]-l] + 1

Sum the frequency of  each number
A: 4,1,`3`,4,3
C: 1,0,1,1

for i <- 0 to n-1
    do C[A[ i]-l] <- C[A[ i]-l] + 1

Sum the frequency of  each number
A: 4,1,3,`4`,3
C: 1,0,1,2

for i <- 0 to n-1
    do C[A[ i]-l] <- C[A[ i]-l] + 1

Sum the frequency of  each number
A: 4,1,3,4,`3`
C: 1,0,2,2

for i <- 0 to n-1
    do C[A[ i]-l] <- C[A[ i]-l] + 1

### Loop 3: compute running sum
```
A: 4,1,3,4,3
C: 1,0,2,2
     ^
    j|
C: 1,1,2,2
```
Reserve index in ‘S’ for each set of 
numbers

for j <- 1 to u-l
    do C[j] <- C[j-1] + C[j]

```
A: 4,1,3,4,3
C: 1,1,2,2
       ^
      j|
C: 1,1,3,2
```

for j <- 1 to u-l
    do C[j] <- C[j-1] + C[j]

```
A: 4,1,3,4,3
C: 1,1,3,2
         ^
        j|
C: 1,1,3,5
```

for j <- 1 to u-l
    do C[j] <- C[j-1] + C[j]

### Loop 4: re-arrange
```
A: 4,1,3,4,3
C: 1,1,3,2
        
C: 1,1,3,5
S: _,_,3,_,_
```

Decrement reserved count and add to array ‘S’

for i <- n-1 downto 0
    do  j <- A[ i]- l
        S[C[ j] -1] <- A[ i]
        C[ j] <- C[ j] –1

```
A: 4,1,3,4,3
C: 1,1,3,2
        
C: 1,1,3,5
S: _,_,3,_,4
```

```
A: 4,1,3,4,3
C: 1,1,3,2
        
C: 1,1,3,5
S: _,3,3,_,4
```

```
A: 4,1,3,4,3
C: 1,1,3,2
        
C: 1,1,3,5
S: 1,3,3,_,4
```

```
A: 4,1,3,4,3
C: 1,1,3,2
        
C: 1,1,3,5
S: 1,3,3,4,4
```

### Entire loop

Algo DistributionCountingSort (A[0.. n-1])
    for j <- 0 to u-l do                O(u)
        C[j] <- 0
    for i 0 to n-1 do                  O(n)
        C[A[ i]-l] C[A[ i]-l] + 1
    for j 1 to u-l do                  O(u)
        C[j] C[j-1] + C[j]
    for i n-1 downto 0 do              O(n)
        j A[ i]- l
        S[C[ j] -1] A[ i]
        C[ j] C[ j] –1
    return S                            O(n+u)

u = largest number in ‘A’
n = length of ‘A’

O(n+u)

### Distribution Counting Sort
Analysis
- As long as the range of  valid input values is roughly less than or equal to the number of  input values (n), the algorithm is O(n)
- this is very good efficiency, better than mergesort

## String Matching: reminder
`Pattern`: a string of  m characters to search for
`Text`: a (long) string of  n characters to search in
- `Brute force algorithm`:
1. Align pattern at beginning of  text
2. Moving from left to right, compare each character of  pattern to the corresponding character in text until
-- All characters are found to match (successful search); or
-- A mismatch is detected
3. While pattern is not found and the text is not yet exhausted, realign pattern one position to the right and repeat step 2.
- `Time Complexity: O(n-m+1)× m`

### Input Enhancement in String Matching
How can we improve string matching by using the concept of  input enhancement?
- `key observation`: each time we have a “mismatch” (ie: a pattern char doesn’t  match the corresponding text char), we `may be able to shift more than one character` before starting to compare again

Pattern P   B A R B E R
text T      M A B R B I E N T A E R B

- Comparing the chars from right to left
- There is no “I” in BARBER, so we should shift the pattern  all the way past the “I”
- Determines the umber of  shifts by looking at the character of  the text that is aligned against the last character of  the pattern

### String Matching: Key Observation
- Consider, as an example, searching for the pattern BARBER in some text:
- Starting with the last R of the pattern and moving right to left if a mismatch occurs shift to right by looking at character c

#### String Matching: Input Enhancement Cases
`Case1`: If  there is no character c in the pattern
- shift the pattern by its entire length because ‘S’ isn’t in BARBER

`Case2`: If  there are occurrences of  character c in the pattern but it is not the last one there
- shift to align the rightmost occurrence of  c in the pattern with 
the c in the text

`Case3`: If  c is the last char in the pattern, and occurs only once in the pattern
- shift the pattern by its entire length because ‘R’ appears only 
once in the pattern.

`Case4`: if  c  the last char in the pattern, and occurs multiple times in the pattern
- shift to align the rightmost occurrence of ‘R’ in the pattern 
with the ‘R’ in the text

### The Strategy
- How can we use this observation for input enhancement?
- Strategy:
-- we are going to create a “shift table”. 
--- It will have one entry for each possible value in the input alphabet
-- shift table will indicate the number of  positions to shift the pattern to aling the next 
possible match

### The Shift Table
How to construct the shift table:
- it will have a size equal to the number of  elements in the input alphabet (so we have to  know this in advance!)
Value in table = 
- distance from c’s rightmost occurrence in pattern (length – index – 1)
- pattern’s length m, if  last character in pattern

Example: assume our pattern is IDIGDAB  (m=7)
Value in table = 
- distance from c’s rightmost occurrence in pattern (m – index in pattern – 1)
- pattern’s length m, if  last character in pattern

Example: assume our pattern is IDIGDAB  (m=7)
`Value in table` = 
- distance from c’s rightmost occurrence in pattern (m – index in pattern – 1)
- pattern’s length m, if  last character in pattern

### Extra example
TEAM // last letter is M so it will be given a position of 3

A   E   M   T   *
1   2   4   3   4


total (t) = 4
A = 4-2-1 = 1
E = 4-1-1 = 2
M = 4-3-1 = 4 // is the last character in the pattern
T = 4-0-1 = 3

### Using the shift table ...
Example: there is a mismatch on the first compare, so we lookup table[“D”], which returns 2, so we shift by 2 ..

Pattern P   I D I G D A B
text T      I B A G H J D A B A D A B
                I D I G D A B

Example: there is a mismatch, so we lookup table[“B”], which  returns 7, so we shift by 7 .

text T  I B A G H J D A B A D A B
            I D I G D A B

- We look up ‘B’ not ‘J’ because B  is the last letter compared to the pattern.
- In other words, there is no B in  the rest of  the pattern, so move the entire length

`Note`: the algorithm is spelled out in detail in your textbook. 
(it is called Horspool’s algorithm)
- A great video can be found here: https://youtu.be/PHXAOKQk2dw

## Fast Storage of Keyed Records
`Goal`: want some way to do fast storage/lookups/retrieval of   information, based on an arbitrary key
eg: 
    key = A00043526
    value = Jimmy 
Let’s consider traditional data structures ...

`Array`: How would you use an array (or arrays) to store this
- use either 2 1D arrays or 1 2D array or an array of  objects
-- store key in a sorted array (for fast retrieve)
-- use the second array (or column) to store the record or a pointer to the record ... or ...
- alternatively, create an object ‘Employee’, and store in an array of objects

### Using Sorted Array

Inserting a new element ... eg:    insert(A00099999, “foo”)
nserting a new element ... eg:  insert(A00099999, “foo”)

find location 
- (use binary search)
- O(logn) operation

Inserting a new element ... insert(A00099999, “foo”)

find location 
- (use binary search)
- O(logn) operation
create space 
- (move existing elements)
- O(n) operation

Inserting a new element ... eg:insert(A00099999, “foo”)

find location 
- (use binary search)
- O(logn) operation
create space 
- (move existing elements)
- O(n) operation
put the new element
- direct access to array
- O(1) operation
Overall efficiency is:
O(logn)+O(n)+O(1) = O(n)


- Search operation is 𝑶(𝒍𝒐𝒈𝒏)
- Retrieval is 𝑶(𝒍𝒐𝒈𝒏)
- Deletion is 𝑶(𝒏)

### What if  we use an unsorted Array:
- Insertion will be much faster – O(1)
- Searching, retrieve will be slower – O(n)
- Deletion will be the same O(n)

- So how to get better performance ... ?
-- Hashing

## Hashing
- Each item has a `unique key`.
- Use a large array called a `Hash Table`.
- Use a `Hash Function` that maps keys to a index in the Hash Table

f(key) = index

## Hash Functions
Common hash function for `numerical keys`

`Example`
assume m=5
Insert into hash table (10, Bob)

10 -> key mod 5 -> 0
10/5 = 2 Remainder 0 this means it will map to index 0

What do we do if  our key is not a number?
• `answer`: map it to a number!

`Example`
assume m=5
Insert into hash table (Emily, 6046321)

Example
    assume m=5
    Insert into hash table (Emily, 6046321)
        ord(e) +ord(m) + ord(i) + ord(l)+ ord(y)=
        5+ 13+ 9 + 12+ 25 = 64

64 -> key mode 5 -> 4

64 % 5 = 12 remainder 4

- Sample Hash function for the keys that are not number

```
h <- 0                      // input is a string S of length s
for i <- 0 to s-1 do        // ci is the char in ith posn i of S
h <- h + ord(ci)            // ord(ci) is the relative posn ...
                            // ... of ci in the alphabet
hashcode <- h mod numBuckets // map sum of posns into range
```

- the actual hashcode depends on the number of  buckets

## Collisions
- Collisions occur when different keys are mapped to the same bucket

1. Insert into hash table (30, Jimmy)
index  = 30 mod 25 = 5 
2. Insert into hash table (105, Anthony )
index = 105 mod 25 = 5

## Collisions Handling

Two way to handle collision:
1. Separate Chaining
2. Closed Hashing 

### Collisions Handling (Separate Chaining)
- Each bucket in the table point to a list of  entries that map there

1. Insert into hash table (30, Jimmy)
index  = 30 mod 25 = 5 
2. Insert into hash table (105, Anthony )
index = 105 mod 25 = 5

0
1
2
3
4
pos 5 -> 30 Jimmy -> 105 Anthony

#### Separate Chaining Exercise 1
- Use the hash function h(i) = i mod 7
- Draw the Separate chaining hash table resulting from inserting following keys and values:
(44, name1)
(12, name2)
(23, name3)
(16, name4)
( 5,  name5)
(28, name6)

0 -> 25 name 6
1
2 -> 44 name1 -> 23 name3 -> 6 name4
3
4
5 -> 12 name2 -> 5 name5
6

### Closed Hashing
It works like this:
- compute the hash
- if  the bucket is empty, store the value in it
- if  there is a collision, linearly scan for next free bucket and put the key there
-- note: treat the table as a circular array
> Note: important - with this technique the size of  the table must be at least n (or there would not be enough room!)

1. Insert into hash table (30, Jimmy)
index  = 30 mod 25 = 5 
2. Insert into hash table (105, Anthony )
index = 105 mod 25 = 5

#### Closed Hashing Exercise
- Use the hash function h(i) = i mod 10
- Draw the hash table resulting from inserting following key and values:
(44, name1)
(12, name2)
(13, name3)
(88, name4)
(23, name5)
(16, name6)
(22, name6)

### Efficiency of  Hashing
What is the efficiency of  the hashtable structure?
- add(key, value)      ... is  𝑶(𝟏)  
- value   get(key)    ... is  𝑶(𝟏)
- delete(key)          ... is 𝑶(𝟏)
- of  course there could always be a degenerate case, where every insert causes a collision ... in this case we would end up with O(n)

- conclusion : implementation of  the hashing function is important
-- it must distribute the keys evenly over the buckets

#### Hash Functions
- the efficiency of  hashing depends on the quality of  the hash function

A “good” hash function will 
1. distribute the keys uniformly over the buckets
2. produce very different hashcodes for similar data

- hashing of  numbers is relatively easy, as we just distribute them over the buckets 
with     
- key mod numBuckets

#### Hashing Strings
most keys are Strings, and Strings are a bit trickier
- consider the algo (from the book):
h <- 0
for i <- 0 to s-1 do
    h <- h + ord(ci) // ord(ci) is the relative posn of char i
code <- h mod numBuckets

- Is that a good hash function? (think about anagrams)
-- sample: assume numbuckets = 99
--- hash("dog")  = 26
--- hash("god")  = 26
--- hash("add")  = 9
--- hash("dad")  = 9

#### Better String Hash Function
a better hashcode algorithm for strings

```
alpha  <- |alphabet| // size of the alphabet used 
h <- 0
for i <- 0 to s-1 do
    h <- h + (ascii(ci) * alpha^(i))
code <- h mod numBuckets
```

- Assuming alpha = 128 (number of  ascii codes)
- Assuming numbuckets = 99
-- dog  = 64
-- god  = 46
-- add  = 26
-- dad  = 65

Java’s String.hashCode()
- No need to memorize this.

```
public int hashCode() { 
    int h = 0;             // the final hashcode
    int off = 0;           // offset in to the string
    char val[] = value;    // put the string in an array of char
    int len = count; 
    if (len < 16) { 
        for (int i = len ; i > 0; i--) { 
            h = (h * 37) + val[off++]; 
        } 
    } else { // only sample some characters 
        int skip = len / 8; 
        for (int i=len ; i>0; i-=skip, off+=skip) { 
            h = (h * 39) + val[off]; 
        } 
    } 
    return h; 
}

```

### Java’s String.hashCode()
- Java’s hashcode() produces the following results ...
• dog  = 9
• god  = 90
• add  = 50
• dad  = 59

