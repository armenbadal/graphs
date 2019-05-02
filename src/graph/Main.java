package graph;

public class Main {
    public static void main( String[] args )
    {
        Graph g0 = new AdjacencyListGraph();
        g0.addVertex("a");
        g0.addVertex("b");
        g0.addVertex("c");

        System.out.println(g0);
    }
}
