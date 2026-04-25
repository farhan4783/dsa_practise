import java.util.*;

class Solution {
    public int maxDistance(int side, int[][] points, int k) {
        int n = points.length;
        long[] unrolled = new long[n];
        
        for (int i = 0; i < n; i++) {
            int x = points[i][0];
            int y = points[i][1];
            if (x == 0) unrolled[i] = y;
            else if (y == side) unrolled[i] = (long) side + x;
            else if (x == side) unrolled[i] = (long) 2 * side + (side - y);
            else unrolled[i] = (long) 3 * side + (side - x);
        }
        
        Arrays.sort(unrolled);
        
        int low = 1, high = side;
        int ans = 0;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canPlace(unrolled, k, mid, (long) 4 * side)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    private boolean canPlace(long[] pos, int k, int minDist, long totalLen) {
        int n = pos.length;
        for (int i = 0; i < n; i++) {
            int count = 1;
            long lastPos = pos[i];
            long firstPos = pos[i];
            
            int curr = i;
            for (int j = 1; j < k; j++) {
                int nextIdx = findNext(pos, lastPos + minDist);
                if (nextIdx >= n) {
                    count = -1;
                    break;
                }
                lastPos = pos[nextIdx];
                count++;
            }
            
            
            if (count == k && (totalLen - (lastPos - firstPos)) >= minDist) {
                return true;
            }
            
             
            if (pos[i] - pos[0] >= minDist) break;
        }
        return false;
    }

    private int findNext(long[] pos, long target) {
        int l = 0, r = pos.length - 1;
        int res = pos.length;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (pos[m] >= target) {
                res = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return res;
    }
}
