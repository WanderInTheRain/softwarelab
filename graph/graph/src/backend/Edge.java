package backend;

public class Edge {
    Node from, to;
    int weight;

    Edge(Node from, Node to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "from=" + from.word +
                ", to=" + to.word +
                ", weight=" + weight +
                '}';
    }
}
