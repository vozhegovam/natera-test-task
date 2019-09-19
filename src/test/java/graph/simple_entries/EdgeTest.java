package graph.simple_entries;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class EdgeTest {


    @Test
    public void getOppositeVertex() {
        Edge<Integer> edge= new Edge<>(1, 2);
        Assert.assertEquals(Integer.valueOf(2), edge.getOppositeVertex(1));
    }
}