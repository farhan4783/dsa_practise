class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid.length==0 || grid==null){
            return 0;
        }
        int c=0;
        Queue<int[]> q= new LinkedList<>();
        for(int i=0;i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]==2){
                    q.offer(new int[]{i,j});
                }
                if(grid[i][j]!=0){
                    c++;
                }
            }
        }
        
        int []dx= new int[]{1,-1,0,0};
        int []dy= new int[]{0,0,1,-1};
        int min=0;
        int res=0;
        while(!q.isEmpty()){
            min+=q.size();
            int size=q.size();
            for(int i=0; i<size; i++){
                int []temp= q.poll();
                for(int j=0; j<4; j++){
                    int x= temp[0]+dx[j];
                    int y=temp[1]+dy[j];
                    if(x<0 || y<0 || x>=grid.length || y>=grid[0].length){
                        continue;
                    }
                    if(grid[x][y]==2 || grid[x][y]==0){
                        continue;
                    }
                    grid[x][y]= 2;
                    q.offer(new int[]{x,y});
                }
            }
            if(!q.isEmpty()){
                res++;
            }
        }
        return min==c?res:-1;
    }
}
