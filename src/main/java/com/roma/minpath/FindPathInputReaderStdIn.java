package com.roma.minpath;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FindPathInputReaderStdIn extends AbstractFindPathInputReader{
    @Override
    int[][] readMaze() {
        int[][] maze = new int[0][];

        try (Scanner sc = new Scanner(System.in)) {
            List<String> strings = new ArrayList<>();
            while (sc.hasNextLine()) {
                String str = sc.nextLine();
                if (str.equalsIgnoreCase(""))
                    break;
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
