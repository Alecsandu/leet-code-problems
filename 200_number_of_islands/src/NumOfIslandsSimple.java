/**
 * Puzzle description at <a href="https://leetcode.com/problems/number-of-islands/">https://leetcode.com/problems/number-of-islands/</a>.
 */
void main() {
    char[][] grid = new char[][]{
            {'1', '1', '1', '1', '0'},
            {'1', '1', '0', '1', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '0', '0', '0'}
    };

    IO.println("Number of islands is: " + Solver.numIslands(grid) + "(expected value is 1).");
}

static private class Solver {

    private Solver() {
        // no constructor
    }

    static int numIslands(char[][] grid) {
        int numOfIslands = 0, rows = grid.length, cols = grid[0].length;
        int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Set<String> visited = new HashSet<>();

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == '1' && !visited.contains(row + "," + col)) {
                    bfs(grid, row, col, visited, rows, cols, directions);
                    numOfIslands++;
                }
            }
        }

        return numOfIslands;
    }

    static void bfs(char[][] grid, int r, int c, Set<String> visited, int rows, int cols, int[][] directions) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r, c});
        visited.add(r + "," + c);

        while (!q.isEmpty()) {
            int[] currentPos = q.poll();

            for (int[] direction : directions) {
                int nextRow = direction[0] + currentPos[0], nextCol = direction[1] + currentPos[1];
                String nextPos = nextRow + "," + nextCol;
                if (nextRow >= 0 && nextRow < rows && nextCol >= 0 && nextCol < cols && grid[nextRow][nextCol] == '1' && !visited.contains(nextPos)) {
                    visited.add(nextPos);
                    q.add(new int[]{nextRow, nextCol});
                }
            }
        }

    }

}
