class Solution {
    public int[][] rotateGrid(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int numLayers = Math.min(m, n) / 2;

        for (int layer = 0; layer < numLayers; layer++) {
           
            int top = layer, left = layer;
            int bottom = m - 1 - layer, right = n - 1 - layer;

           
            List<Integer> elements = new ArrayList<>();
            for (int j = left; j < right; j++) elements.add(grid[top][j]);
            for (int i = top; i < bottom; i++) elements.add(grid[i][right]); 
            for (int j = right; j > left; j--) elements.add(grid[bottom][j]); 
            for (int i = bottom; i > top; i--) elements.add(grid[i][left]); 

           
            int size = elements.size();
            int shift = k % size;

           
            int idx = shift; 
            for (int j = left; j < right; j++) grid[top][j] = elements.get(idx++ % size);
            for (int i = top; i < bottom; i++) grid[i][right] = elements.get(idx++ % size);
            for (int j = right; j > left; j--) grid[bottom][j] = elements.get(idx++ % size);
            for (int i = bottom; i > top; i--) grid[i][left] = elements.get(idx++ % size);
        }

        return grid;
    }
}
