import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Iterator;
 
/**
 * An undirected graph with a fixed number of vertices implemented using
 * adjacency lists. Space complexity is O(V + E) where V is the number
 * of vertices and E the number of edges.
 */
public class GraphList {

    /** Number of vertices in the graph. */
    private int numVertices;

    /** Number of edges in the graph. */
    private int numEdges;

    /**
     * All vertices adjacent to v are stored in adjacentVertices[v].
     * No set is allocated if there are no adjacent vertices.
     */
    private Set<Integer>[] adjacentVertices;

    /**
     * Edge costs are stored in a hash map. The key is an
     * Edge(v, w)-object and the cost is an Integer object.
     */
    private Map<Edge, Integer> edgeCosts;

    /**
     * Constructs a ListGraph with v vertices and no edges.
     * Time complexity: O(v)
     *
     * @throws IllegalArgumentException if v < 0
     */
    public GraphList(int v) {
        if(v < 0){
            throw new IllegalArgumentException("v = " + v);
        }
        else{
                numVertices = v;
                numEdges = 0;
                // The array will contain only Set<Integer> instances created
                // in addEdge(). This is sufficient to ensure type safety.
                @SuppressWarnings("unchecked")
                Set<Integer>[] a = new HashSet[numVertices];
                adjacentVertices = a;
                for(int i = 0; i < numVertices; i++){
                    adjacentVertices[i] = new HashSet<Integer>();
                }
                edgeCosts = new HashMap<Edge, Integer>();
        }
    }
	
    /**
     * An undirected edge between v and w.
     */
    private static class Edge {
        // Invariant: v <= w
        final int v;
        final int w;
        Edge(int v, int w) {
            if (v <= w) {
                this.v = v;
                this.w = w;
            } else {
                this.v = w;
                this.w = v;
            }
        }
		
        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Edge))
                return false;
            Edge e = (Edge) o;
            return v == e.v && w == e.w;
        }

        @Override
        public int hashCode() {
            return 31*v + w;
        }
		
        @Override
        public String toString() {
            return "(" + v + ", " + w + ")";
        }

        public int getV(){
            return v;
        }

        public int getW(){
         return w;
        }
 }

 /**
  * Returns the number of vertices in this graph.
  * @return the number of vertices in this graph
  */
 public int numVertices() {
     return numVertices;
 }

 /**
  * Returns the number of edges in this graph.
  * @return the number of edges in this graph
  */
 public int numEdges() {
     return numEdges;
 }

 /**
  * Returns the degree of vertex v.
  *
  * @param  v vertex
  * @return the degree of vertex v
  * @throws IllegalArgumentException if v is out of range
  */
 public int degree(int v) throws IllegalArgumentException {
     return adjacentVertices[v].size();
 }

 /**
  * Returns true iff v is adjacent to w.
  *
  * @param  v vertex
  * @param  w vertex
  * @return true iff v is adjacent to w
  * @throws IllegalArgumentException if v or w are out of range
  */
 public boolean areAdjacent(int v, int w) {
     return adjacentVertices[v].contains(w);
 }

 /**
  * Returns the edge cost if v and w are adjacent and an edge cost
  * has been assigned, -1 otherwise.
  *
  * @param  v vertex
  * @param  w vertex
  * @return edge cost if available, -1 otherwise
  * @throws IllegalArgumentException if v or w are out of range
  */
 public int edgeCost(int v, int w) throws IllegalArgumentException {
     Edge e = new Edge(v, w);
     if(edgeCosts.get(e) == null){
         return -1;
     }
     else {
         return edgeCosts.get(e);
     }
 }

 /**
  * Inserts an undirected edge between v and w.
  * (No edge cost is assigned.)
  *
  * @param  v vertex
  * @param  w vertex
  * @throws IllegalArgumentException if v or w are out of range
  */
 public void addEdge(int v, int w) {
     if(v == w){
         adjacentVertices[v].add(w);
         edgeCosts.put(new Edge(v, w), 0);
         numEdges++;
     }
     else{
         adjacentVertices[v].add(w);
         adjacentVertices[w].add(v);
         edgeCosts.put(new Edge(v, w), 0);
         numEdges++;
     }
 }

 /**
  * Inserts an undirected edge with edge cost c between v and w.
  *
  * @param  c edge cost, c >= 0
  * @param  v vertex
  * @param  w vertex
  * @throws IllegalArgumentException if v or w are out of range
  * @throws IllegalArgumentException if c < 0
  */
 public void addEdge(int v, int w, int c) {
     Integer cost = c;
     if(v == w){
        adjacentVertices[v].add(w);
        numEdges++;
     }
     else{
         adjacentVertices[v].add(w);
         adjacentVertices[w].add(v);
         numEdges++;
     }
     edgeCosts.put(new Edge(v, w), cost);
 }

 /**
  * Removes the edge between v and w.
  *
  * @param  v vertex
  * @param  w vertex
  * @throws IllegalArgumentException if v or w are out of range
  */
 public void removeEdge(int v, int w) {
     adjacentVertices[v].remove(w);
     adjacentVertices[w].remove(v);
     edgeCosts.remove(new Edge(v, w));
     numEdges--;
 }

 /**
  * Returns a string representation of this graph.
  * Will print out all vertices if <10. Else just
  * prints out number of vertices.
  *
  * @return a String representation of this graph
  */
 public String toString() {
     StringBuilder sb = new StringBuilder();
     if(numVertices == 0){
         sb.append("This graph is empty.");
     }
     else{
         sb.append("Vertices: ");
         if(numVertices <= 10){
             for(int i = 0; i < numVertices; i++){
                sb.append(i + ", ");
             }
             sb.setLength(sb.length() - 2);
         }       
         else{
             sb.append(numVertices);
         }
         sb.append(" || Edges: ");
         if(numEdges != 0){
             sb.append("{");
             Iterator i = edgeCosts.keySet().iterator();
             while(i.hasNext()){
                 sb.append(i.next().toString() + ", ");
             }
             sb.setLength(sb.length() - 2);
             sb.append("}");
         }
         else{
             sb.append("none");
         }
     }
     return sb.toString();
 }

 /**
  * Help method for the DFS search.
  * Returns the adjacentVertices.
  *
  * @return Set<Integer>[]
  */
 public Set<Integer>[] getArray(){
     return adjacentVertices;
 }
 
 public static void dfs_iterative(ArrayList<ArrayList<Integer>> adj, int s){
     boolean[] visited = new boolean[adj.size()];
     java.util.Stack<Integer> st = new java.util.Stack<Integer>();
     st.push(s);
     while(!st.isEmpty()){
         int v = st.pop();
         if(!visited[v]){
             visited[v] = true;
             System.out.print(v + " ");
             // auxiliary stack to visit neighbors in the order they appear
             // in the adjacency list
             // alternatively: iterate through ArrayList in reverse order
             // but this is only to get the same output as the recursive dfs
             // otherwise, this would not be necessary
             java.util.Stack<Integer> auxStack = new java.util.Stack<Integer>();
             for(int w : adj.get(v)){
                 if(!visited[w]){
                     auxStack.push(w);
                 }
             }
             while(!auxStack.isEmpty()){
                 st.push(auxStack.pop());
             }
         }
     }
     System.out.println();
 }
}