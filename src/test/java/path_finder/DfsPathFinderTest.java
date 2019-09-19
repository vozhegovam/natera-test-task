package path_finder;

import graph.CommonGraphBuilder;
import graph.Graph;
import graph.UndirectedGraph;
import graph.simple_entries.Edge;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class DfsPathFinderTest {

    private PathFinder<Integer> pathFinder;
    private Graph<Integer> graph;

    @Before
    public void setUp(){
        graph = new UndirectedGraph<>();
        CommonGraphBuilder commonGraphBuilder = new CommonGraphBuilder();
        graph = commonGraphBuilder.buildGraph(graph);
        pathFinder = new DfsPathFinder<>();
    }

    @Test
    public void getPath() {
        List<Edge<Integer>> path = graph.getPath(pathFinder,1, 3);
        Assert.assertTrue(path.get(0).getVertexA() == 1
                && path.get(0).getVertexB() == 2
                && path.get(1).getVertexA() == 2
                && path.get(1).getVertexB() == 3);
    }
}