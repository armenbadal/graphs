package graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**/
public class AdjacencyListGraph implements Graph {
    //
    protected Map<String,List<String>> adjacencyList = 
        new HashMap<>();

    @Override
    public Set<String> vertices()
    {
        return null;
    }

    @Override
    public Set<Edge> edges()
    {
        return null;
    }

    @Override
    public boolean addVertex( String v )
    {
        if( adjacencyList.containsKey(v) )
            return false;

        adjacencyList.put(v, new LinkedList<>());
        return true;
    }

    @Override
    public boolean removeVertex( String v )
    {
        return false;
    }

    @Override
    public boolean addEdge( String u, String v )
    {
        if( !adjacencyList.containsKey(u) || !adjacencyList.containsKey(v) )
            return false;

        if( adjacencyList.get(u).contains(v) || adjacencyList.get(v).contains(u) )
            return false;

        adjacencyList.get(u).add(v);
        adjacencyList.get(v).add(u);
        return true;
    }

    @Override
    public boolean removeEdge( String u, String v )
    {
        return false;
    }
}
