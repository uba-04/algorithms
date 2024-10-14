package org.modules.module3.algorithms.dfs;

public class Islands {
  public int countIslands(int[][] matrix) {
    if (matrix == null || matrix.length == 0) {
      return 0;
    }

    int rows = matrix.length;
    int cols = matrix[0].length;
    int count = 0;

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if (matrix[i][j] == 1) {
          count++;
          dfs(matrix, i, j);
        }
      }
    }

    return count;
  }

  public void dfs(int[][] matrix, int row, int col) {
    int rows = matrix.length;
    int cols = matrix[0].length;

    if (row < 0 || col < 0 || row >= rows || col >= cols || matrix[row][col] != 1) {
      return;
    }

    matrix[row][col] = -1;

    dfs(matrix, row - 1, col);
    dfs(matrix, row + 1, col);
    dfs(matrix, row, col - 1);
    dfs(matrix, row, col + 1);
  }
}
