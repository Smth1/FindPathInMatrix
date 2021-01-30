package com.roma.minpath;

public abstract class AbstractFindPathInputReader {
    protected int startx;
    protected int starty;
    protected int finishx;
    protected int finishy;

    abstract int[][] readMaze();

    public int getStartx() {
        return startx;
    }

    public int getStarty() {
        return starty;
    }

    public int getFinishx() {
        return finishx;
    }

    public int getFinishy() {
        return finishy;
    }
}
