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




