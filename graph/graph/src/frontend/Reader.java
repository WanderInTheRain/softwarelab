package frontend;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Reader {
    private String content;

    public void readFromFile(String filePath) {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        content = stringBuilder.toString();
    }

    public String getContent() {
        return content;
    }

    public static void main(String[] args) {
        Reader reader = new Reader();
        String filePath = "test.md";  // replace with your file path
        reader.readFromFile(filePath);
        String fileContent = reader.getContent();
        System.out.println(fileContent);
    }
}
