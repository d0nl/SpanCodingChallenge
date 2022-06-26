import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestLeague {

    @Test
    public void TestInputFile() throws IOException, IOException {
        String[] expectedValues = {
                "Lions 3, Snakes 3",
                "Tarantulas 1, FC Awesome 0",
                "Lions 1, FC Awesome 1",
                "Tarantulas 3, Snakes 1",
                "Lions 4, Grouches 0"
        };

        Path path = Paths.get("src/test/resources/testLeague.txt");
        BufferedReader reader = Files.newBufferedReader(path);
        for(int i=0;i<expectedValues.length;i++) {
            String line = reader.readLine();
            System.out.println(line);
            assertEquals(expectedValues[i], line);
        }
    }



}