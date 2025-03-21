# Quiz 3
1. Consider the following insertions operations to add elements into Max heap. Give the array representation of the resulting heap after all the insert operations.

heap.add(10)
heap.add(8)
heap.add(11)
heap.add(5)
heap.add(9)
heap.add(15)

Give your answer in the form of an array named H with no whitespace, for example:

H=[10,8,11,5]

[11,8,10]
[11,8,10,5]
[11,9,10,5,8]
Answer: 
H=[15,9,11,5,8,10]

```
    15
   /  \
  9   11
 / \   / 
5   8 10
```

2. Heap can store duplicate items?
true

3. A Max heap contains 5 items, with no duplicates. Consider this heap as it would be stored in an array. In which array element will you find the largest item?

H[1]
- reserved index 0 so really the root of heap is index 1
- index 1 should have the largest item at the top

4. Consider the array H=[null,7,6,6,1,2,3]
which one of the following statements is correct?
- this array repersents a valid heap

```
        7
       / \
     6     6
    / \  /  \
   1   2 3
```
- check if child is smaller than parent if so then it is ok.

5. The Distribution Counting Sort is a general purpose sorting algirthm.
False

6. Distrubtion sort only works for input draw from a finite range of  values
true

7. Distrubtion counting sort works for input that contains duplicate values
true

8. distrubtion counting sort could be used to sort the birthdays of all teh grade 1 students in North America
true

9. Consider Horspool's algorithm as explained in your text. Assume the alphabet {a,b,c,d,e}. Construct the shift table for the patter P=`"CABAE"`

Show your answer a shift vector S[], for example: S=[2,3,3,2,1] would indicate that an A will shift 2 posns, B will shift 3, C will shift 3 etc

last car: (only showing once) pattern.length (n)
            (not just once) based on second last occurence: len - index - 1

other char in Pattern: right most occurance: len - i - 1

answer: S=[ 5-3-1=1,  5-2-1=2,  5-0-1=4,  5,  5]
            A,        B,        C,        D,  E // we dont have letter D in `CABAE` so its the length

10. Consider Horspool's algorithm as explained in your text. ASsume the alphabet {a,b,c,d,e}. Construct the shift table for the patter P=`"BAECD"`

Show your answer a shift vector S[], for example: S=[2,3,3,2,1] would indicate that an A will shift 2 posns, B will shift 3, C will shift 3 etc

last car: (only showing once) pattern.length =5
            (not just once) based on second last occurence: len - index - 1

other char in Pattern: right most occurance: len - i - 1

answer: S=[ 5-1-1=3,  5-0-1=4,  5-3-1=1,  5,  5-2-1=2]
            A,        B,        C,        D,  E

11. Consider Horspool's algorithm as explained in your text. ASsume the alphabet {a,b,c,d,e}. Construct the shift table for the patter P="BBEAC"

Show your answer a shift vector S[], for example: S=[2,3,3,2,1] would indicate that an A will shift 2 posns, B will shift 3, C will shift 3 etc

answer: S =[5-3-1=1,  5-1-1=3,  5,  5,  5-2-1=2]
            A,        B,        C,  D,  E

12. Consider Horspool's algorithm as explained in your text. ASsume the alphabet {a,b,c,d,e}. Construct the shift table for the patter P="DCBAE"

Show your answer a shift vector S[], for example: S=[2,3,3,2,1] would indicate that an A will shift 2 posns, B will shift 3, C will shift 3 etc

answer: S=[ 5-3-1=1,  5-2-1=2,  5-1-1=3,  5-0-1= 4,   5]
            A,        B,        C,        D,          E

13. You need to store some numbers in a hash table. Collisions are handled by the closed hashing method (no chaining). The table has `4 buckets`, and the hash function is `KmodN`, where N is the number of buckets.

The commands to store the items are shown below and ar eexecuted in teh order given.

Which bucket will the number 16 be stored?

hashtable.add(12)
hashtable.add(14)
hashtable.add(16)

[0] 12 // 12/4 = 0
[1] 16 // 16/4 = 0
[2] 14 // 14/4 = 2
[3]

answer is index 1
- on the exam there will be a question on closed chaining

14. You need to store some numbers in a hash table. Collisions are handled by the closed hashing method (no chaining). The table has `4 buckets`, and the hash function is `KmodN`, where N is the number of buckets.

The commands to store the items are shown below and ar eexecuted in teh order given.

Which bucket will the number 12 be stored?

hashtable.add(0)
hashtable.add(4)
hashtable.add(8)
hashtable.add(12)

[0] 0 // 0/4 = 0
[1] 4 // 4/4 = 0
[2] 8 // 8/4 = 0
[3] 12 // 12/4 = 0

answer is index 3

15.  You need to store some numbers in a hash table. Collisions are handled by the closed hashing method (no chaining). The table has `4 buckets`, and the hash function is `KmodN`, where N is the number of buckets.

The commands to store the items are shown below and ar eexecuted in teh order given.

Which bucket will the number 8 be stored?

hashtable.add(2)
hashtable.add(4)
hashtable.add(6)
hashtable.add(8)

[0] 4 // 4/4 = 0
[1] 8 // 8/4 = 0
[2] 2 // 2/4 = 2
[3] 6 // 6/4 = 2

answer is index 1

16. You need to store some numbers in a hash table. Collisions are handled by the closed hashing method (no chaining). The table has `4 buckets`, and the hash function is `KmodN`, where N is the number of buckets.

The commands to store the items are shown below and ar eexecuted in teh order given.

Which bucket will the number 14 be stored?

hashtable.add(12)
hashtable.add(14)
hashtable.add(16)
hashtable.add(20)

[0] 12 // 12/4 = 0
[1] 16 // 16/4 = 0
[2] 14 // 14/2 = 2
[3] 20 // 20/4 = 0

answer is index 2
