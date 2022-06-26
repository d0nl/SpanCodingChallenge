import java.io.*;
import java.util.Scanner;

public class TestStdIn {
    public static void main(String[] args) throws IOException {
        BufferedInputStream stream = new BufferedInputStream(System.in);
        Scanner scanner = new Scanner(stream);
        while(scanner.hasNext()) {
            String line = scanner.nextLine();
            System.out.println(line);
        }
    }
}
