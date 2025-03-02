# Class 8 Data Structures
## Exam
- pseudo code questions
- 7 questions with sub questions
- photo 4


## Data Structures
- Often… the way you organize the data affects the performance of your algorithm

- A data structure is a particular way of storing and organizing data
-- Part of algorithm design is choosing the right data structure

> if we keep everything sorted then big O should be the same as binary search

- if in an interview they ask to improve the code it doesn't necessarily mean to change the code. There is not one better the other. To have better big O its about better data structure.

Big O array (worst case)
insert/deletion     O(n) - requires moving
searching this is sorted order   O(nlogn)

why is it nlogn b/c of the second step we need to move everything. When its an array we need to make that space to move things. 

- best case we insert at the end. When its decending its the smallest at the end this is big O(1)

- is the insertion or removal is at the beginning or end its O(1)

- it is possible we delete the first one so we need to move everything over.

- when you go to job interview is think of starting with hashmap or hashtable because its all insertion/delete is O(1) or O(n)

- Whether or not you have a collion depends on construction. How you build the type. It is additional step on how to set it up. 

- at a job interview if you don't know how to solve it then try to say hashtable or hashmap then you can work it backwards.

- Data stucture is about how you are organizing your data

## Fundamental Data Structures
- Linear Data Structure
-- Array
-- Linked list
-- Stack
-- Queue
- Set  
- Dictionary (Map)
- Tree
- Graph

## Arrays
> always has to be consecutive memory. That is how you can access each slot very easily O(1) - ti is consevutive memory because we know the starting memory. 

A sequence of n items of the same type, accessed by an index

| 0 | 1 | 2 | n |
| :---: | :---: | :---: | :---: |
| Item[0] | Item[1] | ... | Item[n-1] |

`The good`:
Each item accessed in same constant time
`The bad`:
Size is fixed for arrays
Insertion / deletion in an array is time consuming – all the elements following the inserted element must be shifted appropriately

if the array is full what will we do with insertion?
- we cannot resize but we can create a new array and copy over the data. 
- when you define that class/data structure you need to keep track of the current size. When you use up the space you need to create a new array and also copy over the data. 

Do we do shallow copy or deep copy?
- it depends on the data we are holding
- depends on nature of how we will use the data

## Linked Lists
- not fixed size

(singly) A sequence of zero or more elements called nodes, consisting of data and a pointer
- each node has a pointer or reference (one only)


Item 0 -> Item 1 -> ... Item n-1

(doubly) Pointers in each direction
- each node has two pointers or references (two only)

Item 0  <-> item 1 <-> ... Item n-1

Linked list provides following two advantages over arrays
- Dynamic size based on number of elememnts
- Ease of insertion/deletion – O(1) - this is at the head

** if we want to insert in a specific order then it will need to find the position and it will be O(n) - the finding will take more time

Linked lists have following drawbacks: 
- Random access is not allowed.
- Search and access is time consuming – O(n)

### Linked Lists
Data structures

#### Average Case
| search | insert | delete |
| :---: | :---: | :---: |
| O(n) | O(1) | O(1) | 

#### Worst Case
| search | insert | delete |
| :---: | :---: | :---: |
| O(n) | O(1) | O(1) | 

## Stack
- Like a stack of plates
- Last-in-first-out (LIFO)

pg 10

- the insert/add operation is called Push
- the delete/remove operation is called Pop
- peek without touching the element in the bucket we aren't doing anything to it we just want to see what is it. It will return the element on the top.

Example:
- Analysis of languages (e.g. properly nested brackets) 
- Properly nested: (())
- Wrongly nested: (() 

## Example 
```
CheckBalancedParenthesis(exp)
1.  n <- length(exp) 
    Create a stack s
2.  for i <- 0 to n-1 do
3.      if (exp[i] is ‘(‘ ) do
4.          Push (exp[i])
5.      else if (exp[i] is ‘)‘ )
6.          if(s is empty or dose not pair with exp[i])
7.          return False
8.      else
9.          pop()
10. If (s is empty)
11.     return true
12. else
13.     return false
```

### Average Case
| search | insert | delete |
| :---: | :---: | :---: |
| O(n) | O(1) | O(1) | 

### Worst Case
| search | insert | delete |
| :---: | :---: | :---: |
| O(n) | O(1) | O(1) | 

## Queues
- Like a line up
- First-in-first-out (FIFO)
- peek method to check the value in the queue
- `enqueue` - adds to the end of the queue
- `dequeue` - removes from the top of the queue

### Average Case
| Access | search | insert | delete |
| :---: | :---: | :---: | :---: |
| O(n) | O(n) | O(1) | O(1) | 

### Worst Case
| Access | search | insert | delete |
| :---: | :---: | :---: | :---: |
| O(n) | O(n) | O(1) | O(1) | 

On what case will we use average case?
- When they have same worst case then you can use the average case
- we never need to look at best case

We are asked to define a stack or queue? How can we do this?
How to implement a stack?
How to implement a queue?
- can use linked lists or array

- When you are asked to defined your own stack or queue then you can setup a linkedlist or array.

it is spelled dequeue() NOT deque
- `deque` means a a double sided queue so dont use this spelling

Linear data Structure
- Array vs LinkedList    how we organize data in memory separate memory storage using a pointer and reference. Each data note will have a data part and pointer part. `physical data structure`.

Stack and Queue -`logical data structures` because we are talking about thier behaviour. We are talking about stack, push, pop, enqueue, dequeue etc - we can use array or arry list to implement them

## Set
- a Set is just like a Set in math, ie: set = { 1, 2, 3, 4 }
- the key thing to remember:
-- sets cannot contain duplicate items
- order doesn't remember

- all we can really do with a set is:
-- add things into it
-- take things out of it
-- check if it contains something
-- iterate over the Set (examine each item, one-by-one)

- logical data structure only focuses on the behaviour
- can use contains method like in lab 6

- we cannot do random access.

## Set in java
- there are a few different ways to implement Set

-- HashSet:
--- HashSet is the fastest implementation, but it is `unordered`

|  | add | contains | next | notes |
| :---: | :---: | :---: | :---: | :---: |
| HashSet | O(1) | O(1) | O(h/n) | h is the table capcity | 

-- TreeSet
--- TreeSet is slower, but maintains a `sorted order`
|  | add | contains | next |
| :---: | :---: | :---: | :---: |
| treeSet | O(logn) | O(logn) | O(logn) |

- lab 6 question 3 you will be expected to use other data structure 1:24:00

### Example 
{}, add 1, add 2, add 3, add 4
{}, add 2, add 4, add 1, add 3

- These two results are the same because they have the same elements it doesn't matter about the order
- for both cases when you traverse it, the value is sorted.

## Map
- a `Map` is a lookup table that takes a `key` and returns a `value` the most common implementation is as a hashtable (hashmap)

## Map (As a Balanced Tree)
- tree implementations, using `red-black trees` 

## Trees
- A connected, acyclic graph
-- Usually we think of trees as having a root
- Representing data in a tree can speed up your algorithms in many natural problems

- may have multiple separate parts

### Question
1:31:00
This is a graph btu not a tree. Why?
- they must be asyclic with no cycle.

- if we have a tree through and another node that is not connected then it is not a tree it is a graph and it is called a `forest`. It is not cyclic. It can be seen as multiple trees together being a graph

- tree is not limited to direction it doesn't have to have a direction.
- there should only be one root

## Binary tree implementation
- pg 24

- when they have two points - no two notes pointing to each other we are talking about a tree here

## Tree Node Implementation
```
public class Node {
    public int data;      
    public Node left;    
    public Node right; 
    
    public Node(int d) {
        data = d;
    }
}
```

## Graphs
- collection of nodes and edges
```
G = (V,E)
V is a set of vertices
E is a set of edges
```

## Degree
In-degree(v) – Number of edges facing towards node ‘v’
Out-degree(v) – Number of edges facing outwards from ‘v’

## Representing Graphs
Adjacency matrix pg 30
Adjacency lists pg 31

## Representing Graphs
1. Adjacency matrix
- Or Weight Matrix for weighted graphs

2. Adjacency lists
- A list of vertices connected to each vertex

3. Which one to use?
- Depends on the nature of the graph (sparse or not)
- Depends on the algorithm

## Properties
Connected graph
- A graph where there is a path connecting each pair of vertices

Bi-partite graph
- Vertices can be divided into two separate sets u and v, so that all edges go from set u to set v

Cyclic graph
- A graph containing at least one cycle
- (must have 3 vertices)

Acyclic graph
- A graph containing no cycles

## Graph Algorithm
- Many real-world problems require processing of each vertex (or edge) in a graph
-- Routing a message on a network
-- Web crawling
-- Social network
-- Network broadcast
-- Garbage collection

## Graph Traversal Algorithms
- Graph traversal algorithms give a method for systematically processing all vertices

> Idea: "visit" all the vertices, one at a time, marking them as we visit them

Two approaches:
- Depth-First Search (DFS)
- Breadth-First Search (BFS)

## Depth First Search
- Visits all vertices by always moving away from the last vertex visited (if possible)
-- Backtracks if there are no more adjacent vertices
- Implementation often uses a stack of vertices being processed
- “Re-draws” graph in a tree-like fashion
- the statement "visit node v" should be replaced by whatever you are doing  
- the output is typically a “DFS Tree”, which is a tree containing all the edges that are used to visit node
- edges that are in G, but not in the DFS Tree are called “back edges”

### Algorithm
```
DFS(G):
    init all visited values to false
    for each vertex v in V    // where G = {V,E}
        if v has not been visited
            dfs(v)

dfs(v)
    visit node v
    for each vertex w in V adjacent to v
        if w has not been visited
            dfs(w)
```

Notes: 
- To trace the operation algorithm we use a stack. 
- When we make a recursive call (eg (dfs(v)), we push v onto the stack). 
- When v becomes a dead-end (ie: no more adjacent unvisited neighbors) it is popped off the stack. 
- Typically we break ties for next unvisited neighbor by using alphabetical order.

page 41
> DFS: a b f e g c d h

## Uses of DFS
DFS is commonly used to:
- find a spanning tree 
- find a path from v to u (ie: get out of a maze)
- find a cycle
- find all connected components

## Efficency of DFS
the basic operation is:
```
    for each vertex w in V adacent to v
        if w has not been visited
            dfs(w)
```
- we can see that this operation will be performed once for each vertex that occurs in the underlying graph structure
-- therefore the #basic ops depends on the size of the structure used to implement the graph
- basically we need to visit each element of the data structure exactly once. so the efficiency must be:
- O(|V|^2) - for adjacency matrix
- O(|V|+|E|) for adjacency lists

## Breadth-first Search (BFS)
- Visits graph vertices by moving across to all the neighbors of last visited vertex
- Instead of a stack, BFS uses a queue
- Similar to level-by-level tree traversal
- “Redraws” graph in tree-like fashion (with tree edges and cross edges for undirected graph)

Informally:
- for each vertex v in V
- visit all vertices adjacent to v
- when all vertices have been visited, visit all vertices 2 hops away
- continue in this way until all have been visited 

- the statement "visit node v|w" can be replaced by whatever you are doing
- use a queue (FIFO) to determine which vertex to visit next
- edges that are in G, but not in the resulting BFS tree are called cross-edges

```
BFS(G):
    init all visited flags to false
    for each v in V
        if v has not been visited
            bfs(v)
bfs(v)
    visit node v
    initialize a queue Q
    add v to Q
    while Q is not empty
        for each w adjacent to Q.head
            if w has not been visited
                visit node w
                add w to Q
        remove Q.head from Q
```

BFS Example 47

## Notes on BFS
- BFS has same efficiency as DFS and can be implemented with graphs represented as:
-- adjacency matrices: O(V2)
-- adjacency lists: O(|V|+|E|)

- Yields single ordering of vertices (order added/deleted from queue is the same)

- Really the same as DFS

- But… with some judgment… there are applications where BFS seems better:
-- Finding all connected components in a graph
-- Traversing all nodes within one connected component (friends in facebook)
-- Finding the shortest path (number hops) between two connected vertices

Example pg 50 & 51 & 52

## Problems
- In many problems… we need to traverse a graph
- Either DFS or BFS will work
-- But one is better
- Consider some examples…

## Problem 1: Spanning Tree
- Spanning Tree: A line that connects all nodes together. (if connections exist)
- Given a connected graph G, use BFS or DFS to construct a spanning tree of G.
-- use BFS so that we get “shorter” paths between vertices
-- this is a straight-up application of BFS, just build a new graph (the spanner) as we go

## Problem 2: Maze Solving
- Model the following maze as a graph. Use DFS to find a path through the maze
- use DFS because its tree is constructed by moving along existing edges (in contrast, BFS keeps back-tracking to the parent node, so you would have to walk further)

## Problem 3: Shortest Path
- Use BFS to find the shortest path between two connected vertices, u and w
-- use BFS because it will find a shortest path (DFS will find “a path” – not always the shortest one)

`Step 1`: run bfs(u) to create a spanning tree T rooted at u (all paths from in T, starting at root, are shortest)

`Step 2`: extract the path from T
use DFS on T, to find any path (as in the previous problem), 

## Problem 4: Find Cucles
- Explain how you can use BFS or DFS to determine if a graph is acyclic
-- either will work
-- need to quit when we have a cycle (we attempt to visit a neighbor, but it has already been visited)

## Problem 5: Determine Connectivity
- Explain how you can use BFS or DFS to determine if a graph is connected
--  either will work
-- modify the first loop so that it calls dfs|bfs on any vertex. If there are any unvisited vertices when it returns, the graph is not connected

