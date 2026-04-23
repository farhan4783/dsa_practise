import java.util.*;

class Solution {
    public long[] distance(int[] nums) {


        int n = nums.length;
        long[] result = new long[n];
    
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {

            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

       
        for (List<Integer> indices : map.values()) {

            int size = indices.size();
            if (size <= 1) continue;
            long totalSum = 0;
            for (int idx : indices) {
                totalSum += idx;
            }

            long prefixSum = 0;
            for (int i = 0; i < size; i++) {
                long currentIdx = indices.get(i);
                
               
                long leftSum = (long) i * currentIdx - prefixSum;
                
              
                long suffixSum = totalSum - prefixSum - currentIdx;
                long rightSum = suffixSum - (long) (size - 1 - i) * currentIdx;
                
                result[(int) currentIdx] = leftSum + rightSum;

                
             
                prefixSum += currentIdx;
            }
        }

        return result;
    }
}
