package graph;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**/
public class AdjacencyMatrixGraph implements Graph {
    //
    protected int vertexCount = 0;
    protected String[] vertexNames = null;
    protected boolean[][] adjacencyMatrix = null;

    //
    public AdjacencyMatrixGraph( int vc )
    {
        vertexNames = new String[vc];
        adjacencyMatrix = new boolean[vc][vc];
    }

    //
    private int indexOf( String v )
    {
        for( int i = 0; i < vertexCount; ++i )
            if( vertexNames[i].equals(v) )
                return i;

        return -1;
    }

    //
    private void resize( int ns )
    {
        String[] vns = vertexNames;
        String[] vertexNames = new String[ns];
        for( int i = 0; i < vertexCount; ++i )
            vertexNames[i] = vns[i];
        
        boolean[][] am = adjacencyMatrix;
        boolean[][] adjacencyMatrix = new boolean[ns][ns];
        for( int i = 0; i < vertexCount; ++i )
            for( int j = 0; j < vertexCount; ++j )
                adjacencyMatrix[i][j] = am[i][j];
    }

    @Override
    public Set<String> vertices()
    {
        Set<String> res = new HashSet<>();
        for( int i = 0; i < vertexCount; ++i )
            res.add(vertexNames[i]);
        return res;
    }
    
    @Override
    public Set<Edge> edges()
    {
        Set<Edge> res = new HashSet<>();
        for( int i = 0; i < vertexCount; ++i )
            for( int j = 0; j < vertexCount; ++j )
                if( adjacencyMatrix[i][j] ) {
                    Edge e = new Edge(vertexNames[i], vertexNames[j]);
                    res.add(e);
                }
        return res;
    }

    @Override
    public boolean addVertex( String v )
    {
        if( vertexCount == vertexNames.length )
            resize(2 * vertexNames.length);
        
        if( -1 != indexOf(v) )
            return false;

        vertexNames[vertexCount++] = v;
        return true;
    }
    
    @Override
    public boolean removeVertex( String v )
    {
        int iv = indexOf(v);
        if( iv == -1 )
            return false;

        // TODO: սխալ կա, ուղղել
        for( int j = iv; j < vertexCount; ++j ) {
            vertexNames[j] = vertexNames[j+1];
            adjacencyMatrix[iv][j] = adjacencyMatrix[iv][j+1];
            adjacencyMatrix[j][iv] = adjacencyMatrix[j+1][iv];
        }

        --vertexCount;
        return true;
    }

    @Override
    public boolean addEdge( String u, String v )
    {
        int iu = indexOf(u);
        int iv = indexOf(v);
        if( iu == -1 || iv == -1 )
            return false;

        if( adjacencyMatrix[iv][iu] && adjacencyMatrix[iu][iv] )
            return false;

        adjacencyMatrix[iv][iu] = true;
        adjacencyMatrix[iu][iv] = true;
        return true;
    }
    
    @Override
    public boolean removeEdge( String u, String v )
    {
        int iu = indexOf(u);
        int iv = indexOf(v);
        if( iu == -1 || iv == -1 )
            return false;

        if( !adjacencyMatrix[iv][iu] || !adjacencyMatrix[iu][iv] )
            return false;

        adjacencyMatrix[iv][iu] = false;
        adjacencyMatrix[iu][iv] = false;
        return true;
    }

    @Override
    public int degree( String v )
    {
        return 0;
    }

    @Override
    public String toString()
    {
        String vs = String.join(", ", vertices());
        String es = String.join(", ",
            edges().stream().map(e -> e.toString())
            .collect(Collectors.toSet()));

        // TEST
        StringBuilder sr = new StringBuilder();
        for( int i = 0; i < vertexCount; ++i ) {
            for( int j = 0; j < vertexCount; ++j )
                sr.append(adjacencyMatrix[i][j] ? "* " : ". ");
            sr.append("\n");
        }
        System.out.println(sr.toString());

        return String.format("Vertices: %s\nEdges: %s", vs, es);
    }
}
