package 图;

import java.util.*;

public class ListGraph<V, E> implements Graph<V, E> {
    private Map<V, Vertex<V, E>> vertices = new HashMap<>();
    private Set<Edge<V, E>> edges = new HashSet<>();


    public void print() {
        System.out.println("[顶点]-------------------");
        vertices.forEach((V v, Vertex<V, E> vertex) -> {
            System.out.println(v);
            System.out.println("out-----------");
            System.out.println(vertex.outEdges);
            System.out.println("in-----------");
            System.out.println(vertex.inEdges);
        });

        System.out.println("[边]-------------------");
        edges.forEach((Edge<V, E> edge) -> {
            System.out.println(edge);
        });
    }
    @Override
    public int edgesSize() {
        return edges.size();
    }

    @Override
    public int verticesSize() {
        return vertices.size();
    }

    @Override
    public void addVertex(V v) {
        if (vertices.containsKey(v)) return;
        vertices.put(v, new Vertex<>(v));
    }

    @Override
    public void addEdge(V from, V to) {
        addEdge(from, to, null);
    }

    @Override
    public void addEdge(V from, V to, E weight) {
        Vertex<V, E> fromVertex = vertices.get(from);
        if (fromVertex == null) {
            fromVertex = new Vertex<>(from);
            vertices.put(from, fromVertex);
        }
        Vertex<V, E> toVertex = vertices.get(to);
        if (toVertex == null) {
            toVertex = new Vertex<>(to);
            vertices.put(to, toVertex);
        }
        Edge<V, E> edge = new Edge<>(fromVertex, toVertex);
        edge.weight = weight;
        if (fromVertex.outEdges.remove(edge)) {
            toVertex.inEdges.remove(edge);
            edges.remove(edge);
        }


        fromVertex.outEdges.add(edge);
        toVertex.inEdges.add(edge);
        edges.add(edge);

    }

    @Override
    public void removeEdge(V from, V to) {
        Vertex<V, E> fromVertex = vertices.get(from);
        if (fromVertex == null) return;

        Vertex<V, E> toVertex = vertices.get(to);
        if (toVertex == null) return;

        Edge<V, E> edge = new Edge<>(fromVertex, toVertex);
        if (fromVertex.outEdges.remove(edge)) {
            toVertex.inEdges.remove(edge);
            edges.remove(edge);
        }
    }

    @Override
    public void bfs(V begin) {
        Vertex<V,E> beginVertex = vertices.get(begin);
        if (beginVertex == null) return;
        Set<Vertex<V,E>> visitedVertices = new HashSet<>();
        Queue<Vertex<V,E>> queue = new LinkedList<>();
        queue.offer(beginVertex);
        visitedVertices.add(beginVertex);
        while (!queue.isEmpty()) {
            Vertex<V,E> vertex = queue.poll();
            System.out.println(vertex.value);

            for (Edge<V,E> edge : vertex.outEdges) {
                if (visitedVertices.contains(edge.to)) continue;
                queue.offer(edge.to);
                visitedVertices.add(edge.to);
            }
        }
    }

    @Override
    public void dfs(V begin) {
        Vertex<V,E> vertex = vertices.get(begin);
        if (vertex == null) return;
        dfs(vertex,new HashSet<>());
    }

    @Override
    public Set<EdgeInfo<V, E>> mst() {
        return prim();
    }

    private Set<EdgeInfo<V, E>> prim () {
        Iterator<Vertex<V,E>> it = vertices.values().iterator();
        if (!it.hasNext()) return null;
        Vertex<V,E> vertex = it.next();
        Set<EdgeInfo<V, E>> edgeInfos = new HashSet<>();
        return edgeInfos;
    }

    private Set<EdgeInfo<V, E>> kruskal () {
        return null;
    }

    private void dfs(Vertex<V,E> vertex, Set<Vertex<V,E>> visitedVertices) {
        System.out.println(vertex.value);
        visitedVertices.add(vertex);
        for (Edge<V,E> edge : vertex.outEdges) {
            if (visitedVertices.contains(edge.to)) continue;
            dfs(edge.to,visitedVertices);
        }

    }

    @Override
    public List<V> topologcalSort() {
        List<V> list = new ArrayList<>();
        Queue<Vertex<V,E>> queue = new LinkedList<>();
        // 使用map存储顶点和其入度
        Map<Vertex<V,E>,Integer> ins = new HashMap<>();
        // 初始化 （将度为0 的节点放入队列）
        vertices.forEach((V v,Vertex<V,E> vertex) -> {
            int in = vertex.inEdges.size();
            if (in == 0) {
                queue.offer(vertex);
            } else {
                ins.put(vertex,in);
            }
        });
        while (!queue.isEmpty()) {
            Vertex<V,E> vertex = queue.poll();
            for (Edge<V,E> edge : vertex.outEdges) {
                int toIn = ins.get(edge.to) - 1;
                if (toIn == 0) {
                    queue.offer(edge.to);
                } else {
                    ins.put(edge.to,toIn);
                }
            }
        }

        return list;
    }


    @Override
    public void removeVertex(V v) {
        Vertex<V, E> vertex = vertices.remove(v);
        if (vertex == null) return;

        for (Iterator<Edge<V, E>> iterator = vertex.outEdges.iterator(); iterator.hasNext();) {
            Edge<V, E> edge = iterator.next();
            edge.to.inEdges.remove(edge);
            // 将当前遍历到的元素edge从集合vertex.outEdges中删掉
            iterator.remove();
            edges.remove(edge);
        }

        for (Iterator<Edge<V, E>> iterator = vertex.inEdges.iterator(); iterator.hasNext();) {
            Edge<V, E> edge = iterator.next();
            edge.from.outEdges.remove(edge);
            // 将当前遍历到的元素edge从集合vertex.inEdges中删掉
            iterator.remove();
            edges.remove(edge);
        }
    }

    private static class Vertex<V, E> {
        V value;
        Set<Edge<V, E>> outEdges = new HashSet<>();
        Set<Edge<V, E>> inEdges = new HashSet<>();

        public Vertex(V value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {
            return Objects.equals(value, ((Vertex<V, E>) obj).value);
        }

        @Override
        public int hashCode() {
            return value == null ? 0 : value.hashCode();
        }
    }

    private static class Edge<V, E> {
        Vertex<V, E> from;
        Vertex<V, E> to;
        E weight;

        public Edge(Vertex<V, E> from, Vertex<V, E> to) {
            this.from = from;
            this.to = to;
        }

        @Override
        public boolean equals(Object obj) {
            Edge<V, E> edge = (Edge<V, E>) obj;
            return Objects.equals(from, edge.from) && Objects.equals(to, edge.to);
        }

        @Override
        public int hashCode() {
            return from.hashCode() * 31 + to.hashCode();
        }
    }
}
