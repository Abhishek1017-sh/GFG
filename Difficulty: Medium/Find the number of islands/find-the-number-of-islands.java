class Solution {
    public int countIslands(char[][] grid) {
        // Code here
        int n=grid.length;
        int m=grid[0].length;
        int count=0;
        int[] d_r={0,1,1,1,0,-1,-1,-1};
        int[] d_c={1,1,0,-1,-1,-1,0,1};
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='L'){
                    count++;
                    dfs(grid,i,j,n,m,d_r,d_c);
                }
            }
        }
        return count;
    }
    void dfs(char[][] grid,int r,int c,int n,int m,int[] d_r,int[] d_c) {
        if (r<0 || r>=n || c<0 || c>=m || grid[r][c]!='L'){
            return;
        }
        grid[r][c]='W';
        for(int i=0;i<8;i++){
            dfs(grid,r+d_r[i],c+d_c[i],n,m,d_r,d_c);
        }
    }
}