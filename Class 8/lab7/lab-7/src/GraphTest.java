import ADJGraph.*;

public class GraphTest {

    private static void printDegree(AdjGraph adjGraph){
        if(adjGraph.directed){
            for(int i=0; i < adjGraph.numVertices; i++){
                int id = adjGraph.inDegree(i);
                int od = adjGraph.outDegree(i);
                System.out.println("inDegree["+i+"]="+ id);
                System.out.println("outDegree["+i+"]="+ od);
            }
            return;
        }
        for(int i=0; i < adjGraph.numVertices; i++){
            int d = adjGraph.degree(i);
            System.out.println("degree["+i+"]="+ d);
        }
    }
    
    public static void main(String[] args) {
        // Part 1
        // first graph 
        // 1st iteration for undirected graphs
        // 2nd for directed
        for(int k = 0; k < 2; k++){
            int vertices = 5;

            boolean directed = k == 1;
            if(directed){
                System.out.println("\nDirected Graphs:");
            } else {
                System.out.println("\nUndirected Graphs:");
            }
            AdjGraph graph = new AdjGraph(vertices);

            graph.directed=directed;
            
            graph.addEdge(0,1);
            graph.addEdge(0,3);
            graph.addEdge(0,4);
            graph.addEdge(1,2);
            graph.addEdge(1,4);
            graph.addEdge(2,3);
            graph.addEdge(3,4);

            System.out.println("Graph #1 with degrees:");
            System.out.println(graph);
            
            printDegree(graph);
            
            // second graph
            vertices = 4;
            graph = new AdjGraph(vertices);
            graph.directed = directed;
            
            for(int i =0;i<3;i++){
                graph.addEdge(i,i+1);
            }
            System.out.println("\nGraph #2 with degrees:");
            System.out.println(graph);
            printDegree(graph);
        }

        // Part 2
        // undirected graph
        AdjGraph graph = new AdjGraph(8);
        
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(0,4);
        graph.addEdge(1,3);
        graph.addEdge(1,5);
        graph.addEdge(2,3);
        graph.addEdge(2,6);
        graph.addEdge(3,7);
        graph.addEdge(4,5);
        graph.addEdge(4,6);
        graph.addEdge(5,7);
        graph.addEdge(6,7);

        System.out.println();

        System.out.println("Doing dfs on graph:");
        System.out.println(graph);
        graph.DFS();

        System.out.println();

        System.out.println("Doing bfs on graph:");
        System.out.println(graph);
        graph.BFS();
    }
}