package graph;

import graph.simple_entries.Edge;
import path_finder.PathFinder;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class AbstractGraph<V> implements Graph<V> {

    Map<V, List<Edge<V>>> graphData = new ConcurrentHashMap<>();
    boolean isDirected = false;
    private boolean isWeighted = false;

    public Graph<V> addVertex(V vertex) {
        this.graphData.putIfAbsent(vertex, new CopyOnWriteArrayList<>());
        return this;
    }

    void addEdgeValidation(Edge<V> edge){
        if (!graphData.containsKey(edge.getVertexA()) || !graphData.containsKey(edge.getVertexB())) {
            throw new RuntimeException("Can't add edge to graph without vertex");
        }
        else if(edge.getWeight() != 0){
            this.isWeighted = true;
        }
    }

    public abstract Graph<V> addEdge(Edge<V> edge);

    public List<Edge<V>> getPath(PathFinder<V> pathFinder, V fromVertex, V toVertex) {

        if (pathFinder == null){
            throw new RuntimeException("PathFinder can not be NULL");
        } else if (fromVertex == null || toVertex == null) {
            throw new RuntimeException("Input can't be NULL");
        }
        return pathFinder.getPath(this, fromVertex, toVertex);
    }

    public Map<V, List<Edge<V>>> getGraphStructure(){
        return graphData;
    }

    @Override
    public boolean isDirected() {
        return isDirected;
    }

    @Override
    public boolean isWeighted() {
        return isWeighted;
    }
}
