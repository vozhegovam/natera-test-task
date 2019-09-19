package graph;

import graph.simple_entries.Edge;

public class CommonGraphBuilder {

    public Graph<Integer> buildGraph(Graph<Integer> graph){
        Edge<Integer> oneTwoEdge = new Edge<>(1, 2);
        Edge<Integer> twoThreeEdge = new Edge<>(2, 3);
        graph.addVertex(1)
                .addVertex(2)
                .addVertex(3)
                .addVertex(4)
                .addEdge(oneTwoEdge)
                .addEdge(twoThreeEdge);
        return graph;
    }

}
