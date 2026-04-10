import java.util.*;

class Solution {
    public int minimumDistance(int[] nums) {
       


        Map<Integer, List<Integer>> indexMap = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {

            indexMap.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);

        }

        int minDistance = Integer.MAX_VALUE;
        boolean found = false;
        for (List<Integer> indices : indexMap.values()) {
            
            
            
            if (indices.size() >= 3) {

                found = true;
               
                for (int h = 0; h < indices.size() - 2; h++) {

                    int i = indices.get(h);
                    int k = indices.get(h + 2);
                    int currentDistance = (k - i) * 2;
                    minDistance = Math.min(minDistance, currentDistance);
                    
                }
            }
        }

        return found ? minDistance : -1;
    }
}
