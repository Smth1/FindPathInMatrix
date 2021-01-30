package com.roma.minpath;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FindPathInputReaderFile extends AbstractFindPathInputReader{
    private final String filename;

    public FindPathInputReaderFile(String filename) {
        this.filename = filename;
    }

    @Override
    int[][] readMaze() {
        int[][] maze = new int[0][];
        try (Scanner sc = new Scanner(new BufferedReader(new FileReader(this.filename)))) {
            List<String> strings = new ArrayList<>();
            while (sc.hasNextLine()) {
                String str = sc.nextLine();
                strings.add(str);
            }

            maze = new int[strings.size()][strings.get(0).length()];
            for (int i = 0; i < strings.size(); i++) {
                for (int j = 0; j < strings.get(0).length(); j++) {
                    if (strings.get(i).charAt(j) == '#')
                        maze[i][j] = -1;
                    else if (strings.get(i).charAt(j) == 'S') {
                        starty = i;
                        startx = j;
                    } else if (strings.get(i).charAt(j) == 'X') {
                        finishy = i;
                        finishx = j;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return maze;
    }
}
