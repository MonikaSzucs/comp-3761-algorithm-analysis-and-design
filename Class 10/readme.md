# Class 10 Chapter 9

## Greedy Approach
- Introduction to Greedy Algorithm
- Minimum Spanning Tree
-- Prim
-- Kruskal
- Single-Source Shortest Path
-- Dijkstra

### Greedy Technique
- An `optimization problem` is one in which you want to find, not just a
solution, but the best solution
- A “greedy algorithm” sometimes works well for optimization problems
- Constructs a solution to an optimization problem through a sequence of
choices
-- Choose the best choice that you can make right now, without regard for future
consequences, the “best” choice is the choice that gets us closest to an optimal solution
-- You hope that by choosing a local optimum at each step, you will end up at a global optimum
- Greedy choice properties:
-- `Feasible`: it has to satisfy the problem’s constraint
-- `locally optimal`: it has to be the best local choice among all feasible choices available on that step.
-- `Irrevocable`: Once made, it cannot be changed on subsequent steps of the algorithm.
- It’s a kin to Life – we can revisit choices, but never go back in time to reverse them. We must make the best decision with the information we have.

### Simple Example
- Problem: Pick k numbers out of n numbers such that the sum of these k numbers is the largest.
- Algorithm:
```
FOR i = 1 to k
    pick out the largest number and
    delete this number from the input.
ENDFOR
```

## Problem: Laying Telephone Wire
- pg 8 - 10
- Minimize the total length of wire connecting the customers

## Minimum Spanning Trees
- A `minimum spanning tree` is a subgraph of an undirected weighted graph G, such that
- it is acyclic
- it covers all the vertices V
- the total cost associated with tree edges is the minimum among all possible spanning trees
- not necessarily unique

### MST's
- Consider all the spanning trees of G
- The weight of each spanning tree is given by the sum of its edges ...

```
        b
     1/   \3
     a -1- c
     4\   /2
        d
```
- Minimum Spanning Tree of G is this graph, and it has a weight of 4.

```
        b
     1/   
     a -1- c
          /2
        d
```
1 + 1 + 2 = 4

### Prim
Basic principle:
- Create an empty list of vertices and edges that represent the minimum spanning tree.
- Add a root node as a start
- Until all vertices are visited, add a vertex to the list by finding the smallest edge from a vertex in the spanning tree.

example pg 14 - 19

```
Prim(G)
    VT <- {v0}
    ET <- ø
    for i <- 0 to |V|-1 do
        find a min-weight edge e from the set of ...
        ... edges {u,v} where v is in VT and u is in V-VT
        VT <- VT U u
        ET <- ET U e
    return ET
```

#### Example 2
- find minimum spanning tree 
pg 21 - 28

Vt = {a, f, e, b, c, d}
Et = { {a,f}, {f,e}, {e,b}, {b,c}, {c,d} }

### Kruskals
also greedy
- repeatedly adds the minimum weight edge that does not induce a cycle
- example: pg 30

```
Kruskal(G) // from textbook
    sort e ∈ E in ascending order of weights
    ET <- ø
    count <- 0
    k <- 0
    while count < |V|-1 do
        k <- k + 1
        if ET U ek is acyclic
            ET <- ET U ek
            count <- count + 1
    return ET
```

implementation notes:
- you need to be able to efficiently sort the edges
-- maybe use a regular PQ ?
- need to be able to determine if adding an edge will create a cycle
-- maybe use a dfs or bfs cycle checker?
--- too slow ...
- we notice that the challenge in Kruskal’s algo is that we have to constantly check for cycles when we add edges
- if we use DFS, we would have worst case:
O(|V|2)x(V-1) = O(|V|3)

- this is not great for efficiency, which is why Kruskals is typically implemented using structures that support efficient union operations on sets

### Disjoint Subsets and Union-find operations
- `disjoint subsets` means that elements are only in one subset at a time
- the following set operations are supported: 
`makeset(x)`
- creates a new one element set containing {x}
`find(x)`
- returns the subset containing x
`union(x,y)`
- creates a new subset Sxy containing the subsets Sx and Sy. The sets Sx
and Sy are removed from the collection, and Sxy is added


### Disjoint Subsets and Union-find Example
```
let S be the set {1, 2, 3, 4, 5, 6, 7, 8}
for each element x in S
    makeset(x)
    {1} {2} {3} {4} {5} {6} {7} {8}
union(2,7)
    {1} {2,7} {3} {4} {5} {6} {8}
union(1,4)
    {1,4} {2,7} {3} {5} {6} {8}
y <- find(4)
    sets y = {1,4}
union(y,3)
    {1,4,3} {2,7} {5} {6} {8}
x <- find(1)
    sets x = {1,4,3}
y <- find(7)
    sets y = {2,7}
union(x, y)
    {1,4,3,2,7} {5} {6} {8}
```

- consider the following sequence of randomly chosen union & find operations:

### Disjoint Subsets & Kruskal's
- As we go from multiple sets to one, it is very similar to the concept of water droplets merging into one big drop.
- Similarly, the union of each set eventually creates one large set that contains all verticies.

This is the pseudocode you would want to use to implement Kruskal's
```
algorithm Kruskal(G)
    Create a graph T <- Ø // T will contain the soln MST
    Add all vertices in G to T // add v's but don’t add e's
    Create a priority queue PQ // candidate edges
    Create a collection C // contains disjoint subsets
    
    for each vertex v in G do
        C.makeset(v)
    
    for each edge e in G do
        PQ.add(e.weight, e) // PQ of edges, sorted by weight
    
    while T has fewer than n-1 edges do
        (u,v) <- PQ.removeMin() // get next smallest edge
        setU <- C.find(u); setV <- C.find(v)
        if setV ≠ setU then // will edge (v,u) create a cycle?
            T.addEdge(v,u)
            C.union(setU, setV)
return graph T
```

#### Another Kruskal Example
- this is the state after the initialization
- edge ef has been added
- main loop exits because N-1 edges added
- algorithm returns solution
pg 38 to 44

#### Efficiency of Kruskal’s
- With an efficient union-find algorithm… the slowest thing is the initial sort on edge weights
O(|E| log |E|)

## Shortest Path Problems
Problem: Single-Source Shortest Path
- find the shortest path from one source vertex v to every other vertex in the graph
- “source” means “starting vertex”

What about BFS? pg 49
- we know how to do this for an unweighted graph
- but BFS doesn’t work for weighted graphs, consider
- the algorithm to find shortest paths in weighted graphs needs to consider the weight on the edge before including it in the solution
- Popular Approach: Dijkstra

Relaxation
- Dijkstra always refers to “relaxing” a vertex
- this means update the best known shortest path to v

### Dijkstra Example
- Find the shortest paths from A to all other vertices
- Algorithm is very similar to Kruskal’s as it uses a PQ of edges to pick the next path to explore. Main difference is it combines the concept of BFS
- Basic Concept: Next vertex in the PQ is the shortest path from the root

Q = PQ
S = Solution - Vertices that have found the shortest path to the root.

Greedy Algorithm
- builds a tree of shortest paths rooted at the starting vertex
- it is greedy because it adds the closest vertex, then the next closest, and so on (until all vertices have been added)

Here is the high-level pseudocode:
```
1. Initialise d and prev
2. Add all vertices to a PQ with distance from source as the key
3. While there are still vertices in PQ
4.      Get next vertex u from the PQ
5.      For each vertex v adjacent to u
6.          If v is still in PQ, relax v

1. Relax(v):
2.      if d[u] + w(u,v) < d[v]
3.          d[v] ¬ d[u] + w(u,v)
4.          prev[v] ¬ u
5.          PQ.updateKey(d[v], v)
```

#### Similarity to Prim
- algorithm is similar to Prim’s algo
- needs to select the minimum priority edge from the set of edges adjacent to the tree that has been built so far
- in Prim’s algo the “priority” of an edge (u, v) is defined by the weight of the edge
- in Dijkstra the “priority” is given by the weight of the edge (u, v) plus the distance from the start to the parent of v

#### Application of Dijkstra’s
- Suppose whole pineapples are served in a restaurant in London. To ensure freshness, the pineapples are purchased in Hawaii and air freighted from Honolulu to Heathrow in London.
- There are various airline routes that the shipments can take, but each possible route has a different shipping cost.
- Which route will result in the lowest shipping cost?

#### Build a model ...
- now we just apply Dijkstra to find the shortest route from Honolulu to London

#### Dijkstra: negative weight edges?
- negative weight edges do not work
- if we added a new edge to T, and it had a negative weight, then there could exist a shorter path (through this new vertex) to vertices already in T
- For example, consider graph A below.
-- Graph B is the result of running Dijkstra's algorithm on A.
-- But clearly there exists a path such as a-c-e in graph C that is shorter than the path found in B. Therefore Dijkstra's algorithm did not work on this graph that has a neg edge weight.