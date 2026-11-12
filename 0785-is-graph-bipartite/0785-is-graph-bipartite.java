class Solution {

    private boolean dfs(int[][] graph, int node, int color, int[] colors) {
        colors[node] = color;

        for (int neighbor : graph[node]) {
            if (colors[neighbor] == color) {
                return false;
            }

            if (colors[neighbor] == -1) {
                if(!dfs(graph, neighbor, 1 - color, colors)) {
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n];
        Arrays.fill(colors, -1);

        for (int i = 0; i < n; i++) {
            if (colors[i] == -1) {
                if(!dfs(graph, i, 0, colors)) {
                    return false;
                }
            }
        }
        return true;
    }
}