package ADJGraph;

import java.util.LinkedList;
import java.util.Queue;

public class AdjGraph {
    int [][] adjMatrix;
    boolean[] visited;
    public int numVertices;
    public boolean directed;

    public AdjGraph(int numVertices) {
        this.numVertices = numVertices;
        adjMatrix = new int[numVertices][numVertices];
    }

    // Method to add an edge between two vertices
    public void addEdge(int i, int j) {
        if (i >= 0 && i < numVertices && j >= 0 && j < numVertices) {
            adjMatrix[i][j] = 1;
            if(!directed){
                adjMatrix[j][i] = 1; // For undirected graph
            }
        }
    }

    public int degree(int vertex){
        int degree = 0;
        for(int i = 0; i < numVertices; i++) {
            degree += adjMatrix[vertex][i];
        }
        return degree;
    }

    public int outDegree(int vertex){
        return degree(vertex);
    }
    
    public int inDegree(int vertex){
        int degree = 0;
        for(int i = 0; i < numVertices; i++) {
            degree += adjMatrix[i][vertex];
        }
        return degree;
    }

    // Method to print the adjacency matrix
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                sb.append(adjMatrix[i][j]).append(" ");
            }
            sb.append("\n"); // Add a newline after each row
        }
        return sb.toString();
    }
    public void DFS(){
        visited = new boolean[numVertices]; // Track visited vertices
        for (int vertex = 0; vertex < numVertices; vertex++) {
            if (!visited[vertex]) {
                dfs(vertex);
            }
        }
    }
    public void dfs(int vertex){
        visited[vertex] = true; // Mark the current vertex as visited
        System.out.println("visiting vertex "+vertex);

        // Visit all adjacent vertices in lexicographic order
        for (int w = 0; w < numVertices; w++) {
            if (adjMatrix[vertex][w] == 1 && !visited[w]) {
                dfs(w);
            }
        }
    }

    public void BFS() {
        visited = new boolean[numVertices]; // Initialize all visited values to false
        for (int vertex = 0; vertex < numVertices; vertex++) {
            if (!visited[vertex]) {
                bfs(vertex);
            }
        }
    }

    private void bfs(int vertex) {
        Queue<Integer> queue = new LinkedList<>();
        visited[vertex] = true; // Mark the current vertex as visited
        queue.add(vertex);

        while (!queue.isEmpty()) {
            int current = queue.poll(); // Remove the head of the queue
            System.out.println("Visiting vertex " + current);

            // Visit all adjacent vertices in lexicographic order
            for (int w = 0; w < numVertices; w++) {
                if (adjMatrix[current][w] == 1 && !visited[w]) {
                    visited[w] = true; // Mark the adjacent vertex as visited
                    queue.add(w);
                }
            }
        }
    }
}
