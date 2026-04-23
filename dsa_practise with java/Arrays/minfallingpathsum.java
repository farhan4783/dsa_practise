class Solution {
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        if (n == 1) return grid[0][0];

      
        int prevMin1 = 0, prevMin2 = 0, prevIndex1 = -1;

        for (int[] row : grid) {
            int currMin1 = Integer.MAX_VALUE;
            int currMin2 = Integer.MAX_VALUE;
            int currIndex1 = -1;

            for (int j = 0; j < n; j++) {
                
                int sum = row[j] + (j == prevIndex1 ? prevMin2 : prevMin1);

                
                if (sum < currMin1) {
                    currMin2 = currMin1;
                    currMin1 = sum;
                    currIndex1 = j;
                } else if (sum < currMin2) {
                    currMin2 = sum;
                }
            }

            
            prevMin1 = currMin1;
            prevMin2 = currMin2;
            prevIndex1 = currIndex1;
        }

        return prevMin1;
    }
}
