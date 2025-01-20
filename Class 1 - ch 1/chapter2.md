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
