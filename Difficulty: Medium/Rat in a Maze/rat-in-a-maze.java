class Solution {
    
    static boolean isSafeToMove(int newX, int newY, int[][] maze, int n, boolean[][] visited) {
        //OUT OF BOUND CASE
        if (newX < 0 || newY < 0 || newX >= n || newY >= n) {
            return false;
        }
        // BLOCK CELL CASE
        if (maze[newX][newY] == 0) {
            return false;
        }
        //ALREADY VISITED CASE
        if (visited[newX][newY] == true) {
            return false;
        }
        else {
            return true;
        }
    }
    
    
    void solve(int[][] maze, int srcX, int srcY, int endX, int endY, boolean[][] visited, ArrayList<String> ans, String path) {
        if (srcX == endX && srcY == endY) {
            ans.add(path);
            return;
        }
        
        visited[srcX][srcY] = true;
        int n = maze.length;
        //FOUR MOVEMENTS I HAVE
        //UP
        int newX = srcX - 1;
        int newY = srcY;
        if(isSafeToMove(newX, newY, maze, n, visited)) {
            solve(maze,newX, newY, endX, endY, visited, ans, path + "U");
        }
        //DOWN
        newX = srcX + 1; 
        newY = srcY;
        if(isSafeToMove(newX, newY, maze, n, visited)) {
            solve(maze,newX, newY, endX, endY, visited, ans, path + "D");
        }
        //LEFT
        newX = srcX;
        newY = srcY - 1;
        if(isSafeToMove(newX, newY, maze, n, visited)) {
            solve(maze,newX, newY, endX, endY, visited, ans, path + "L");
        }
        //RIGHT
        newX = srcX;
        newY = srcY + 1;
        if(isSafeToMove(newX, newY, maze, n, visited)) {
            solve(maze,newX, newY, endX, endY, visited, ans, path + "R");
        }
        
        // We have already explored all 4 possible directions from this cell.
        // Now we are returning to the previous cell because there is no further
        // path to explore from here.

        // Since we are going back, we must undo our previous choice.
        // This allows us to try a different path when we return.
        visited[srcX][srcY] = false;

        // Setting it back to false is the BACKTRACKING step.
        // Remember: Choose → Explore → Undo → Try another choice.
    }
    
    public ArrayList<String> ratInMaze(int[][] maze) {
        // code here
        int srcX = 0;
        int srcY = 0;
        
        int n = maze.length;
        int endX = n -1;
        int endY = n -1;
        
        boolean[][] visited = new boolean[n][n];
        ArrayList<String> ans = new ArrayList<>();
        String path ="";
        
        if (maze[0][0] == 0 || maze[n-1][n-1] == 0) {
            return ans;
        }
        
        solve(maze,srcX, srcY, endX, endY, visited, ans, path);
        Collections.sort(ans);
        return ans;
    }
}