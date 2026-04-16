import java.util.*;

class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {



        
        int n = nums.length;
        int[] minDistance = new int[n];
        Arrays.fill(minDistance, Integer.MAX_VALUE);
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

      
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            List<Integer> indices = entry.getValue();
            int m = indices.size();
            
            if (m <= 1) {
             
                for (int idx : indices) minDistance[idx] = -1;
                continue;
            }

            for (int i = 0; i < m; i++) {
                int curr = indices.get(i);
                
                
                int left = indices.get((i - 1 + m) % m);
                int dLeft = (curr - left + n) % n;
                
                
                int right = indices.get((i + 1) % m);
                int dRight = (right - curr + n) % n;
                
                minDistance[curr] = Math.min(dLeft, dRight);
            }
        }

       
        List<Integer> result = new ArrayList<>(queries.length);
        for (int qIdx : queries) {
            result.add(minDistance[qIdx]);
        }

        return result;
    }
}
