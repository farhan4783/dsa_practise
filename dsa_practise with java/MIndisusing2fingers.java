import java.util.Arrays;

class Solution {
    private Integer[][][] memo;
    private String word;

    public int minimumDistance(String word) {

        this.word = word;
        

        memo = new Integer[word.length()][27][27];
        return solve(0, 26, 26);
    }

    private int solve(int idx, int f1, int f2) {
        if (idx == word.length()) return 0;
        if (memo[idx][f1][f2] != null) return memo[idx][f1][f2];

        int target = word.charAt(idx) - 'A';

       
        int moveF1 = getDist(f1, target) + solve(idx + 1, target, f2);

      
        int moveF2 = getDist(f2, target) + solve(idx + 1, f1, target);

        return memo[idx][f1][f2] = Math.min(moveF1, moveF2);
    }

    private int getDist(int from, int to) {
        if (from == 26) return 0; 
        int r1 = from / 6, c1 = from % 6;
        int r2 = to / 6, c2 = to % 6;
        return Math.abs(r1 - r2) + Math.abs(c1 - c2);
    }
}
