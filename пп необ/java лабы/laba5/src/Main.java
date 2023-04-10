import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    private static int A;   // Начало
    private static int B;   // Конец
    private static Car car;
    private static List<Integer> v1;    // Вершины графа G' (номерация относительно G)

    private static class Pair {
        int vertex;
        int mileage;

        public Pair(int vertex, int m) {
            this.vertex = vertex;
            this.mileage = m;
        }
    }

    private static int[][] inputMatrix(String filename) {
        int[][] matrix = null;
        File file = new File(filename);
        try (Scanner sc = new Scanner(file)) {
            int size = sc.nextInt();
            matrix = new int[size][size];

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return matrix;
    }

    /**
     * Метод возвращает орграф G',
     * принимая на вход G
     */
    private static int[][] getDigraph(int size, List<Refueling> refuelingCities) {
        v1 = new ArrayList<>();
        v1.add(A);
        v1.add(B);
        for (Refueling refueling : refuelingCities) {
            int city = refueling.getCityNumber();
            if (!v1.contains(city)) {
                v1.add(city);
            }
        }
        int[][] digraph = new int[size][size];
        for (int[] ints : digraph) {
            Arrays.fill(ints, -1);
        }

        List<Integer> v2 = new ArrayList<>(v1);
        v2.remove((Integer) A);
        v2.remove((Integer) B);

        for (Integer vertex : v1) {
            if (!vertex.equals(A)) {
                digraph[A][vertex] = 1;
            }
        }

        for (Integer vertex : v2) {
            digraph[vertex][B] = 1;
        }

        for (int i = 0; i < v2.size(); i++) {
            for (int j = 0; j < v2.size(); j++) {
                if (i != j) {
                    digraph[v2.get(i)][v2.get(j)] = 1;
                }
            }
        }

        return digraph;
    }

    private static int[][][] getVector(int[][] graph) {
        // vector(w, v, k)
        int[][][] vectors = new int[graph.length][graph.length][car.getCapacity() + 1];

        Queue<Pair> queue = new ArrayDeque<>();

        for (Integer v : v1) {
            if (v.equals(B)) {
                continue;
            }

            Pair pair = new Pair(v, 0);
            queue.add(pair);

            while (!queue.isEmpty()) {
                pair = queue.poll();
                int w = pair.vertex;
                int m = pair.mileage;

                for (int u = 0; u < graph.length; u++) {
                    if (graph[w][u] > 0) {
                        if (m + graph[w][u] * car.getMileage() <= car.getCapacity()
                                && vectors[u][v][m + graph[w][u] * car.getMileage()] == 0) {
                            vectors[u][v][m + graph[w][u] * car.getMileage()] = 1;
                            Pair newPair = new Pair(u, m + graph[w][u] * car.getMileage());
                            queue.add(newPair);
                        }
                    }
                }
            }
        }

        return vectors;
    }

    private static void setWeight(int[][] graph, int[][] digraph,
                                  int[][][] vectors, List<Refueling> refuelingCities) {
        for (int v = 0; v < digraph.length; v++) {
            for (int w = 0; w < digraph.length; w++) {
                if (B == w) {
                    continue;
                }
                if (digraph[v][w] > 0) {
                    digraph[v][w] = -1;
                    block:
                    {
                        for (int k = car.getCapacity() / 2; k <= car.getCapacity(); k++) {
                            if (vectors[w][v][k] > 0) {
                                for (Refueling city : refuelingCities) {
                                    if (city.getCityNumber() == w) {
                                        digraph[v][w] = k * city.getPrice();
                                        break block;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        // Выставляем весы для дуг (v, B)
        for (int v : v1) {
            if (v == B) {
                continue;
            }
            int num = Dijkstra.getSum(graph, v, B);
            if (num <= car.getCapacity() && num != -1) {
                digraph[v][B] = 0;
            } else {
                digraph[v][B] = -1;
            }
        }
    }

    public static void main(String[] args) {
        int[][] firstMatrix = inputMatrix("src/input.txt");
        List<Refueling> refuelingCities = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        System.out.println("Сколько запрвочных городов?");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            Refueling refueling = new Refueling();
            System.out.print("Порядковый номер " + (i + 1) + "-го города: ");
            refueling.setCityNumber(sc.nextInt());

            System.out.print("Цена за 1 литр бензина: ");
            refueling.setPrice(sc.nextInt());
            refuelingCities.add(refueling);
        }
        System.out.println();

        car = new Car();
        System.out.print("Вместительность машины: ");
        car.setCapacity(sc.nextInt());
        System.out.print("Расход бензина на 1 км: ");
        car.setMileage(sc.nextInt());
        System.out.println();

        System.out.print("С какого города вы хотите добраться: ");
        A = sc.nextInt();
        System.out.print("В какой город вы хотите добраться: ");
        B = sc.nextInt();
        System.out.println();

        int[][] digraph = getDigraph(firstMatrix.length, refuelingCities);

        //Arrays.stream(digraph).forEach(Arrays::toString);
        for (int[] row : digraph) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println();
        System.out.println(v1);
        System.out.println();

        int[][][] U = getVector(firstMatrix);
        setWeight(firstMatrix, digraph, U, refuelingCities);

        for (int[] row : digraph) {
            System.out.println(Arrays.toString(row));
        }

        System.out.println("Посетим заправки: " + Dijkstra.getPath(A, B, digraph));
        System.out.println("Денег потрачено на бензин: " + Dijkstra.getSum(digraph, A, B));
    }
}
