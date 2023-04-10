import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Dijkstra {
    private static int[] dijkstra(final int n, final int[][] array) {
        final int[] a = new int[array.length];
        Arrays.fill(a, Integer.MAX_VALUE);
        final boolean[] a2 = new boolean[array.length];
        Arrays.fill(a2, false);
        a[n] = 0;
        a2[n] = true;
        int n2 = n;
        for (int i = 0; i < array.length - 1; ++i) {
            for (int j = 0; j < array.length; ++j) {
                if (!a2[j] && array[n2][j] >= 0) {
                    a[j] = Math.min(a[j], a[n2] + array[n2][j]);
                }
            }
            int n3 = Integer.MAX_VALUE;
            for (int k = 0; k < array.length; ++k) {
                if (!a2[k] && a[k] < n3) {
                    n3 = a[k];
                    n2 = k;
                }
            }
            a2[n2] = true;
        }
        return a;
    }

    public static List<Integer> getPath(final int start, final int finish, final int[][] graph) {
        final int[] array = dijkstra(start, graph);
        final ArrayList<Integer> path = new ArrayList<>();
        int cur;
        int next;
        for (cur = finish; cur != start; cur = next) {
            path.add(cur);
            next = -1;
            for (int i = 0; i < array.length && next == -1; ++i) {
                if (graph[i][cur] >= 0 && array[i] == array[cur] - graph[i][cur]) {
                    next = i;
                }
            }
            if (next == -1) {
                System.out.println("Пути нет!");
                System.exit(0);
            }
        }
        path.add(cur);
        Collections.reverse(path);
        return path;
    }

    public static int getSum(int[][] graph, int start, int finish) {
        int result = 0;
        List<Integer> path = getPath(start, finish, graph);
        if (path.isEmpty()) {
            return -1;
        }
        for (int i = 1; i < path.size(); i++) {
            result += graph[path.get(i-1)][path.get(i)];
        }
        return result;
    }
}
