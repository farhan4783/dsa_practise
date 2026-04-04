class Solution {

    int rows, cols;
    int totalCells = 0;
    int result = 0;

    public int uniquePathsIII(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;

        int startRow = 0, startCol = 0;

       
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (grid[i][j] != -1) {
                    totalCells++;
                }

                if (grid[i][j] == 1) {
                    startRow = i;
                    startCol = j;
                }
            }
        }

     
        dfs(grid, startRow, startCol, 1);

        return result;
    }

    private void dfs(int[][] grid, int r, int c, int count) {

       
        if (r < 0 || c < 0 || r >= rows || c >= cols || grid[r][c] == -1) {
            return;
        }

    
        if (grid[r][c] == 2) {
            if (count == totalCells) {
                result++;
            }
            return;
        }

        int temp = grid[r][c];
        grid[r][c] = -1;

        
        dfs(grid, r + 1, c, count + 1);
        dfs(grid, r - 1, c, count + 1);
        dfs(grid, r, c + 1, count + 1);
        dfs(grid, r, c - 1, count + 1);

      
        grid[r][c] = temp;
    }
}
