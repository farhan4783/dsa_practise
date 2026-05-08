class Solution {
    public int minJumps(int[] nums) {
        int n = nums.length;
        if (n == 1) return 0;

        int maxVal = 0;
        for (int x : nums) maxVal = Math.max(maxVal, x);

        boolean[] isPrime = sieve(maxVal);

        Map<Integer, List<Integer>> valueToIndices = new HashMap<>();
        for (int i = 0; i < n; i++) {
            valueToIndices.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        Queue<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[n];
        Set<Integer> usedPrime = new HashSet<>();

        q.offer(0);
        visited[0] = true;

        int steps = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int i = q.poll();
                if (i == n - 1) return steps;

                int left = i - 1, right = i + 1;
                if (left >= 0 && !visited[left]) {
                    visited[left] = true;
                    q.offer(left);
                }
                if (right < n && !visited[right]) {
                    visited[right] = true;
                    q.offer(right);
                }

                int val = nums[i];
                if (val >= 2 && isPrime[val] && usedPrime.add(val)) {
                    for (int multiple = val; multiple <= maxVal; multiple += val) {
                        List<Integer> indices = valueToIndices.get(multiple);
                        if (indices == null) continue;
                        for (int idx : indices) {
                            if (!visited[idx]) {
                                visited[idx] = true;
                                q.offer(idx);
                            }
                        }
                    }
                }
            }
            steps++;
        }

        return -1;
    }

    private boolean[] sieve(int n) {
        boolean[] prime = new boolean[n + 1];
        if (n < 2) return prime;
        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;
        for (int i = 2; i * i <= n; i++) {
            if (prime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    prime[j] = false;
                }
            }
        }
        return prime;
    }
}
