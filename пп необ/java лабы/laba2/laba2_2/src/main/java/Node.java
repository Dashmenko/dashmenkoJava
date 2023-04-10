import java.util.ArrayList;

public class Node {
    public int number;
    public ArrayList<Integer> path;

    public Node(int number) {
        this.number = number;
        path = new ArrayList<>();
    }

    public Node() {}
}
