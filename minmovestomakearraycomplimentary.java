class Solution {
    public int minMoves(int[] nums, int k) {
        int n = nums.length;
        
        int[] delta = new int[2 * k + 2];

        for (int i = 0; i < n / 2; i++) {
            int a = nums[i];
            int b = nums[n - 1 - i];

           
            delta[2] += 2;
            delta[2 * k + 1] -= 2;

           
            int minPossible = Math.min(a, b) + 1;
            int maxPossible = Math.max(a, b) + k;
            delta[minPossible] -= 1;
            delta[maxPossible + 1] += 1;

            
            delta[a + b] -= 1;
            delta[a + b + 1] += 1;
        }

        int minMoves = n; 
        int currentMoves = 0;
        
       
        for (int i = 2; i <= 2 * k; i++) {
            currentMoves += delta[i];
            minMoves = Math.min(minMoves, currentMoves);
        }

        return minMoves;
    }
}
