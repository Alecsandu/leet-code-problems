import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.function.Consumer;

public class NumberOfIslands {

    /**
     * Puzzle description at <a href="https://leetcode.com/problems/number-of-islands/">link</a>.
     */
    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };

        System.out.println("Number of islands is: " + Solver.numIslands(grid) + "(expected value is 1).");
    }

    static private class Solver {
        public static int numIslands(char[][] grid) {
            if (grid == null)
                return 0;

            int rows = grid.length, cols = grid[0].length, numOfIslands = 0;
            HashSet<Position> visited = new HashSet<>();
            Position[] directions = new Position[]{
                    new Position(0, 1), // next column
                    new Position(0, -1),// previous column
                    new Position(1, 0), // next row
                    new Position(-1, 0) // previous row
            };

            Consumer<Position> bfs = (Position pos) -> {
                Queue<Position> q = new LinkedList<>();
                q.add(pos);
                visited.add(pos);

                while (!q.isEmpty()) {
                    var currentPos = q.poll();

                    for (Position direction : directions) {
                        int nextRow = currentPos.row + direction.row, nextCol = currentPos.col + direction.col;
                        Position nextPos = new Position(nextRow, nextCol);
                        if (nextRow >= 0 && nextRow < rows && nextCol >= 0 && nextCol < cols && grid[nextRow][nextCol] == '1' && !visited.contains(nextPos)) {
                            visited.add(nextPos);
                            q.add(nextPos);
                        }
                    }
                }
            };

            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    var pos = new Position(row, col);
                    if (grid[row][col] == '1' && !visited.contains(pos)) {
                        bfs.accept(pos);
                        visited.add(pos);
                        numOfIslands++;
                    }
                }
            }

            return numOfIslands;
        }

        private record Position(int row, int col){}
    }


}