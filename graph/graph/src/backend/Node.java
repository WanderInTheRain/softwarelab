package backend;

public class Node {
    String word;

    Node(String word) {
        this.word = word;
    }

    @Override
    public String toString() {
        return "Node{" +
                "word='" + word + '\'' +
                '}';
    }
}
