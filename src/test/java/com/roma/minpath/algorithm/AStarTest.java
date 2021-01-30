package com.roma.minpath.algorithm;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class AStarTest {

    @Test
    public void findPathTo() {
        int xstart = 0, ystart = 0,
                xend = 7, yend = 7;
        int[][] maze = {
                {  0,  0,  0,  0,  0,  0,  0,  0},
                {  0,  0,  0,  0,  0,  0,  0,  0},
                {  0,  0,  0,  0,  0,  0,  0,  0},
                {  0,  0,  0,  0,  0,  0,  0,  0},
                {  0,  0,  0,  0,  0,  0,  0,  0},
                {  0,  0,  0,  0,  0,  0,  0,  0},
                {  0,  0, -1,  0,  0,  0, -1,  0},
                {  0,  0, -1,  0,  0,  0,  0,  0},
        };
        AStar as = new AStar(maze, xstart, ystart);
        List<AStar.Node> path = as.findPathTo(xend, yend);

        Assert.assertTrue(path.get(0).x == xstart && path.get(0).y == ystart);
        Assert.assertTrue(path.get(path.size() - 1).x == xend && path.get(path.size() - 1).y == yend);
    }

    @Test
    public void findPathNotExist() {
        int[][] maze = {
                {  0,  0,  0,  0,  0,  0,  0,  0},
                {  0,  0,  0,  0,  0,  0,  0,  0},
                {  0,  0,  0,  0,  0,  0,  0,  0},
                {  0,  0,  0,  0,  0,  0,  0,  0},
                {  0,  0,  0,  0,  0,  0,  0,  0},
                {  0,  0,  0,  0,  0,  0,  0,  0},
                {  0,  0, -1,  0,  0,  0, -1, -1},
                {  0,  0, -1,  0,  0,  0, -1,  0},
        };
        AStar as = new AStar(maze, 0, 0);
        List<AStar.Node> path = as.findPathTo(7, 7);

        Assert.assertNull(path);
    }
}