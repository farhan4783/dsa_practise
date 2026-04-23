class Solution {
    public boolean canFinish(int n, int[][] pre) {
        ArrayList<ArrayList<Integer>> g = new ArrayList<>();
        for(int i=0;i<n;i++) g.add(new ArrayList<>());
        
        int[] in = new int[n];
        
        for(int[] e: pre){
            g.get(e[1]).add(e[0]);
            in[e[0]]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(in[i]==0) q.add(i);
        }
        
        int cnt = 0;
        
        while(!q.isEmpty()){
            int u = q.poll();
            cnt++;
            
            for(int x: g.get(u)){
                in[x]--;
                if(in[x]==0) q.add(x);
            }
        }
        
        return cnt==n;
    }
}
