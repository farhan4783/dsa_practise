import java.util.*;

class Solution {
    public int minMirrorPairDistance(int[] nums) {
        int n = nums.length;
        
        Map<Integer, Integer> map = new HashMap<>();
        int minDistance = Integer.MAX_VALUE;

        for (int j = 0; j < n; j++) {
            
            if (map.containsKey(nums[j])) {
                minDistance = Math.min(minDistance, j - map.get(nums[j]));
            }

            
            int reversedVal = reverse(nums[j]);
            map.put(reversedVal, j);
        }

        return (minDistance == Integer.MAX_VALUE) ? -1 : minDistance;
    }

    private int reverse(int n) {
        int res = 0;
        while (n > 0) {
            res = res * 10 + (n % 10);
            n /= 10;
        }
        return res;
    }
}
