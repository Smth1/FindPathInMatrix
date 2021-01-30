package com.roma.minpath;

import com.roma.minpath.algorithm.AStar;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        int startx=0, starty=0;
        int xend=0, yend=0;
        AbstractFindPathInputReader readerFile = new FindPathInputReaderFile("input.txt");
        int[][] maze = readerFile.readMaze();

        startx = readerFile.getStartx();
        starty = readerFile.getStarty();
        xend = readerFile.getFinishx();
        yend = readerFile.getFinishy();
        AStar aStar = new AStar(maze, startx, starty);

        List<AStar.Node> pathTo = aStar.findPathTo(xend, yend);
        StringBuilder res = new StringBuilder();

        if (pathTo == null) {
            System.out.println("error");
        } else {
            for (int i=0; i < pathTo.size() - 1; i++) {
                if (pathTo.get(i).y + 1 == pathTo.get(i+1).y) {
                    res.append("d");
                } else if (pathTo.get(i).y - 1 == pathTo.get(i+1).y) {
                    res.append("u");
                } else if (pathTo.get(i).x + 1 == pathTo.get(i+1).x) {
                    res.append("r");
                } else if (pathTo.get(i).x - 1 == pathTo.get(i+1).x) {
                    res.append("l");
                }
            }
        }

        System.out.println(res);
    }
}
