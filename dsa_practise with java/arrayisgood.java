//best approach with best time and spce complexity

class Solution {
    public boolean isGood(int[] nums) {
        int len = nums.length;
        if (len < 2) return false; 

        int n = len - 1;
        int[] count = new int[len]; 

        for (int num : nums) {
            
            if (num < 1 || num > n) {
                return false;
            }
            count[num]++;
        }

      
        for (int i = 1; i < n; i++) {
            if (count[i] != 1) {
                return false;
            }
        }

        return count[n] == 2;
    }
}
