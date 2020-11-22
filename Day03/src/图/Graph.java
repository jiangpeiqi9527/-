package 图;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public interface Graph<V,E> {
    int edgesSize ();
    int verticesSize ();
   void addVertex (V v);
   void addEdge (V from, V to);
   void addEdge (V from, V to, E weight);

   void removeVertex (V v);
   void removeEdge (V from, V to);
   void bfs (V begin);
   void dfs (V begin);
   Set<EdgeInfo<V,E>> mst ();
   List<V> topologcalSort ();
   class EdgeInfo<V,E> {
       V from;
       V to;
       E weight;

       public EdgeInfo(V from, V to, E weight) {
           this.from = from;
           this.to = to;
           this.weight = weight;
       }
   }
}
