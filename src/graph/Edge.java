package graph;

public class Edge {
    public String u = null;
    public String v = null;

    public Edge( String u, String v )
    {
        this.u = u;
        this.v = v;
    }

    @Override
    public String toString()
    {
        return String.format("[%s, %s]", u, v);
    }
}