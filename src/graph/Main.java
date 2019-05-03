package graph;

public class Main {
    public static void main( String[] args )
    {
        Graph g0 = new AdjacencyMatrixGraph(10);
        g0.addVertex("a");
        g0.addVertex("b");
        g0.addVertex("c");

        g0.addEdge("a", "b");
        g0.addEdge("a", "c");
        g0.addEdge("c", "b");

        System.out.println(g0);

        g0.removeVertex("b");
        System.out.println(g0);
    }
}
