package com.codingquestions.app.DFSII;

/**
 * Randomly generate a maze of size N * N (where N = 2K + 1) whose corridor and
 * wall’s width are both 1 cell. For each pair of cells on the corridor, there
 * must exist one and only one path between them. (Randomly means that the
 * solution is generated randomly, and whenever the program is executed, the
 * solution can be different.). The wall is denoted by 1 in the matrix and
 * corridor is denoted by 0.
 * 
 * Assumptions
 * 
 * N = 2K + 1 and K >= 0 the top left corner must be corridor there should be as
 * many corridor cells as possible for each pair of cells on the corridor, there
 * must exist one and only one path between them Examples
 * 
 * N = 5, one possible maze generated is
 * 
 * 0 0 0 1 0
 * 
 * 1 1 0 1 0
 * 
 * 0 1 0 0 0
 * 
 * 0 1 1 1 0
 * 
 * 0 0 0 0 0
 */

public class GenerateRandomMaze {
    // when to stop: when you backtrack until that you can't go to
    // other directions

    public int[][] maze(int n) {
        int[][] maze = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    maze[i][j] = 0;
                } else {
                    maze[i][j] = 1;
                }
            }
        }
        generate(maze, 0, 0);
        return maze;
    }

    private void generate(int[][] maze, int x, int y) {
        // get a random shuffle of all directions
        // and follow the shuffled order to do DFS and backtrack
        // NOTE: this is backtrack in a sense that we return when we can't
        // find any other valid directio nwhen we backtrack all the way to the beginning
        Dir[] dirs = Dir.values();
        shuffle(dirs);
        for (Dir dir : dirs) {
            // we move by two to avoid a square with all
            // 1s or 0s
            int nextX = dir.moveX(x, 2);
            int nextY = dir.moveY(y, 2);
            if (isValidWall(maze, nextX, nextY)) {
                // only if the cell is a wall
                // we break the walls through to make it corridors
                maze[dir.moveX(x, 1)][dir.moveY(y, 1)] = 0;
                maze[nextX][nextY] = 0;
                generate(maze, nextX, nextY);
            }
        }
    }

    // NOTE: pay attention to this way of shuffling
    private void shuffle(Dir[] dirs) {
        for (int i = 0; i < dirs.length; i++) {
            int index = (int) (Math.random() * (dirs.length - i));
            Dir tmp = dirs[i];
            dirs[i] = dirs[i + index];
            dirs[i + index] = tmp;
        }
    }

    private boolean isValidWall(int[][] maze, int x, int y) {
        return x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && maze[x][y] == 1;
    }

    enum Dir {
        NORTH(-1, 0), SOUTH(1, 0), WEST(0, -1), EAST(0, 1);

        int deltaX;
        int deltaY;

        Dir(int deltaX, int deltaY) {
            this.deltaX = deltaX;
            this.deltaY = deltaY;
        }

        // move certain times of deltax
        public int moveX(int x, int times) {
            return x + times * deltaX;
        }

        public int moveY(int y, int times) {
            return y + times * deltaY;
        }
    }
}