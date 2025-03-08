## Midterm

2. Given the big-o of Merge Sort and Heapsort are the same, what is that big-Oh of them and explain conditions of when you would use one vs the other....


3. sorting n items using Sequencital sort tehn find an item with binary search. What is the big O? O(n^2)

Sorting n items using Merge sort, then finding the kth largest value (where k is an integer parameter). O(nlogn)

4. Consider this claim: "For any input of size n where n is paticularly large, it  is guaranteed that a hash map will always perform as O(1) for an inset." Discuss the merit of this claim. Justify your answer with scenarios where it is true or false.

Nest loops, O(n^2)?
It is commonly assumed that when you see two nested loops the complexity is O(n^2). Ex:
```
for i <- 0 to n do
    for j <- 0 to n do
        <come code here>
```

In pseudocode, show two separate examples of an algorithm with two nested loops is not O(n^2). Use the example above or create two new nested loops with different signatures. The example does nto need to be useful algorithm, just a different Big O.

(type int eh algorithm and the big O of it in the next sections - now provided electronically)

Notes: do not spend much time on this, i'm expecting 3-6 lines of pseudocode off the top of your head

5. first example of nested loop that is not bigO(n^2)



9. What does this larogithm do?

1. ALGO Mystery(A[0..n-1])
2. //Input A list A[0..n-1] of real numbers
3. for i <- 0 to n-2 do
4.  min <- i
5.  for j <- i+1 to n-1 do
6.      if A[j] < A[min]
7.          min <- j
8.      swap()
9.  return

Answer: sorting

10. What line does the basic operation occur
line number line 6


11. Setup a summation that counts the number of times the basic operation is executed (in the worst case) in this algo. Solve your summation to closed form. (use camera icon to submit picture you written response - only photos will be graded)
top(n-2) sigma bottom (0) top(n-1) sigma bottom(i+1)


12. What is the big o?
O(n^2)
b/c selection sort ends up with n^2

13. You need to create a map that associates each student in acertian class with their year of birth. You want to use a hasing table to store this information, you need to store the following key: value pairs

aba:2000
bob:2001
ra:2002
da:2003

You can assume that all keys are strings of letters, but they can be of any length and use all letters of the alphabet

Devise a hasing function 'hascode(key)' that assigns the above keys to the buckets in a 8-lement hash table (m=8). Provide details psudocode for your hashing function.

Note: Your answer should be written on paper and a photo should be taken of submission. Types answers will not be graded.


14. Calculate hash for each pair above. Draw the 8-element hash table resulting from hasing of the aboe keys. Using your hashing function function with separate chaining.

Notes: your answer should be written on


15. What is the average case efficency ofr your pseudocode above? What is the worst case effiency? Under what conditions would your algorithm execute the average vs worst case? Justify your answer.


16. You work for BCIT who would liek to accept the best students from various presenting their top candidates. Your hob is to create an algorithm to identify the best candidates from teh schools in on elist such that the top students can be accepted.

Where'm' is the number of students and 'n' is the total amount of students applying to BCIT from all schools


Your goal:
- implement mergeStudents(A[m][]) is the list (many lists of students from each school)

Hint: a fast execution would be O(nlogm) where m is the number of schools (number of arrays) and n is the total amount of students applying (all the nubers from every array)
not the anove case n = 12

Add pseudocode for your solution here.

In the algo you design below, you need to be as effienct as possible. Partial marks will be giaven for less effienct algo.

Your answer should be written on paper and a photo should be taken of submission. 

Typed answer will not be graded.


17. What is the big O effiency of your algo in the above and why?


