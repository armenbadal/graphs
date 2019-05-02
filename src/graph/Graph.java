package graph;

import java.util.Set;

public interface Graph {
    Set<String> vertices();
    Set<Edge> edges();

    boolean addVertex( String v );
    boolean removeVertex( String v );

    boolean addEdge( String u, String v );
    boolean removeEdge( String u, String v );
}