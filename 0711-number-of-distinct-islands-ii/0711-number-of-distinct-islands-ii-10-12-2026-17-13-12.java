class Solution {
    private static final int[][] DIRS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int numDistinctIslands2(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        Set<String> shapes = new HashSet<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    List<int[]> island = bfs(grid, i, j, visited);
                    shapes.add(canonical(island));
                }
            }
        }
        return shapes.size();
    }

    // collect the absolute coordinates of one island
    private List<int[]> bfs(int[][] grid, int r, int c, boolean[][] visited) {
        int m = grid.length, n = grid[0].length;
        List<int[]> cells = new ArrayList<>();
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{r, c});
        visited[r][c] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            cells.add(cur);
            for (int[] d : DIRS) {
                int x = cur[0] + d[0], y = cur[1] + d[1];
                if (x >= 0 && y >= 0 && x < m && y < n
                        && grid[x][y] == 1 && !visited[x][y]) {
                    visited[x][y] = true;
                    queue.offer(new int[]{x, y});
                }
            }
        }
        return cells;
    }

    // try all 8 orientations, keep the smallest normalized key
    private String canonical(List<int[]> cells) {
        String best = null;
        for (int k = 0; k < 8; k++) {
            List<int[]> t = new ArrayList<>(cells.size());
            for (int[] p : cells) t.add(transform(p[0], p[1], k));
            String key = normalize(t);
            if (best == null || key.compareTo(best) < 0) best = key;
        }
        return best;
    }

    // the 8 rotations / reflections of a point
    private int[] transform(int x, int y, int k) {
        switch (k) {
            case 0:  return new int[]{ x,  y};
            case 1:  return new int[]{ x, -y};
            case 2:  return new int[]{-x,  y};
            case 3:  return new int[]{-x, -y};
            case 4:  return new int[]{ y,  x};
            case 5:  return new int[]{ y, -x};
            case 6:  return new int[]{-y,  x};
            default: return new int[]{-y, -x};
        }
    }

    // sort points, shift so the first point is (0,0), encode as a string
    private String normalize(List<int[]> pts) {
        pts.sort((a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        int r0 = pts.get(0)[0], c0 = pts.get(0)[1];
        StringBuilder sb = new StringBuilder();
        for (int[] p : pts) {
            sb.append(p[0] - r0).append(',').append(p[1] - c0).append(';');
        }
        return sb.toString();
    }

    // public static void main(String[] args) {
    //     Main s = new Main();

    //     int[][] ex1 = {
    //         {1, 1, 0, 0, 0},
    //         {1, 0, 0, 0, 0},
    //         {0, 0, 0, 0, 1},
    //         {0, 0, 0, 1, 1}
    //     };
    //     System.out.println(s.numDistinctIslands2(ex1));   // expected 1

    //     int[][] ex2 = {
    //         {1, 1, 0, 0, 0, 0, 0},
    //         {1, 0, 0, 0, 1, 1, 0},
    //         {1, 0, 0, 0, 0, 1, 0},
    //         {0, 0, 1, 1, 0, 0, 0},
    //         {0, 0, 1, 0, 0, 1, 1},
    //         {0, 0, 1, 0, 0, 1, 0}
    //     };
    //     System.out.println(s.numDistinctIslands2(ex2));   // expected 2
    // }
}