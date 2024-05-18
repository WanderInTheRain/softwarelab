package backend;

public class PointedEdge {
    public PointedNode from, to;
    public int weight;

    PointedEdge(PointedNode from, PointedNode to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "PointedEdge{" +
                "from=" + from.word +
                ", to=" + to.word +
                ", weight=" + weight +
                '}';
    }
}
