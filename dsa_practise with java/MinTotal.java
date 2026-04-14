import java.util.*;

class Solution {
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        
        
        Collections.sort(robot);
        Arrays.sort(factory, (a, b) -> Integer.compare(a[0], b[0]));

        int n = robot.size();
        int m = factory.length;

        
        long[][] memo = new long[n][m];
        for (long[] row : memo) Arrays.fill(row, -1);

        return solve(0, 0, robot, factory, memo);
    }

    private long solve(int robIdx, int factIdx, List<Integer> robot, int[][] factory, long[][] memo) {
        








        if (robIdx == robot.size()) return 0;
        

        if (factIdx == factory.length) return (long) 1e15; 

        if (memo[robIdx][factIdx] != -1) return memo[robIdx][factIdx];

        
        long res = solve(robIdx, factIdx + 1, robot, factory, memo);

       
        long currentFactoryDist = 0;
        for (int k = 0; k < factory[factIdx][1]; k++) {

            int nextRob = robIdx + k;
            if (nextRob >= robot.size()) break;

            currentFactoryDist += Math.abs(robot.get(nextRob) - factory[factIdx][0]);
            
            long nextDist = solve(nextRob + 1, factIdx + 1, robot, factory, memo);

            if (nextDist < (long) 1e15) {

                res = Math.min(res, currentFactoryDist + nextDist);
            }
        }

        return memo[robIdx][factIdx] = res;
    }
}
