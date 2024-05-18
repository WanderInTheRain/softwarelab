package backend;

public class PointedNode{
    public String word;
    public int x, y;

    PointedNode(String word,int x, int y) {
        this.word = word;
        this.x = x;
        this.y = y;
    }
    public String getWord() {
        return word;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "PointedNode{" +
                "word='" + word + '\'' +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}
