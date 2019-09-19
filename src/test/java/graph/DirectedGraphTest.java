package graph;

import graph.simple_entries.Edge;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import path_finder.DfsPathFinder;

import java.util.List;

public class DirectedGraphTest {

    private Graph<Integer> graph;

    @Before
    public void setUp(){
        graph = new DirectedGraph<>();
        CommonGraphBuilder commonGraphBuilder = new CommonGraphBuilder();
        graph = commonGraphBuilder.buildGraph(graph);
    }

    @Test
    public void addAndReturnEdges() {
        Edge<Integer> fourThreeEdge = new Edge<>(4, 3);
        graph.addEdge(fourThreeEdge);
        Assert.assertTrue(graph.getGraphStructure().get(3).isEmpty());
        Assert.assertTrue(graph.getGraphStructure().get(4).contains(fourThreeEdge));
    }

    @Test
    public void getIsDirectedValue() {
        Assert.assertTrue(graph.isDirected());
    }

    @Test
    public void addVertex() {
        graph.addVertex(5);
        Assert.assertTrue(graph.getGraphStructure().containsKey(5));
    }

    @Test
    public void getPath() {
        List<Edge<Integer>> path = graph.getPath(new DfsPathFinder<>(),1, 3);
        Assert.assertTrue(path.get(0).getVertexA() == 1
                            && path.get(0).getVertexB() == 2
                            && path.get(1).getVertexA() == 2
                            && path.get(1).getVertexB() == 3);
        path = graph.getPath(new DfsPathFinder<>(),3, 1);
        Assert.assertTrue(path.isEmpty());
    }

    @Test
    public void getGraphStructure() {
        Assert.assertTrue(graph.getGraphStructure() != null
                && graph.getGraphStructure().size() != 0);
    }
}