import org.junit.jupiter.api.Test;
import java.io.BufferedReader;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestLeague {

    @Test
    public void TestInputFile() throws Exception {
        String[] expectedValues = {
                "Lions 3, Snakes 3",
                "Tarantulas 1, FC Awesome 0",
                "Lions 1, FC Awesome 1",
                "Tarantulas 3, Snakes 1",
                "Lions 4, Grouches 0",
                "Ants 1, FC Awesome 1",
                "Grouches 1, Ants 1",
                "Abis 1, Jgs 1"
        };

        //Get file separator character
        char fileSeparator = FileSystems.getDefault().getSeparator().charAt(0);
        //Default path for Windows
        String pathString = "src\\test\\resources\\sampleinput.txt";
        //Convert to Linux if should
        String os = System.getProperty("os.name").toLowerCase();
        if(!os.contains("windows")){
            //Assume linux or OSX - I don't have a Mac!
            pathString = pathString.replace('\\', fileSeparator);
        }
        System.out.println("OS is " + os + " pathString = " + pathString);
        Path path = Paths.get(pathString);

        try(BufferedReader reader = Files.newBufferedReader(path)) {
            for (int i = 0; i < expectedValues.length; i++) {
                String line = reader.readLine();
                System.out.println(line);
                assertEquals(expectedValues[i], line);
            }
        } catch(Exception ex){
            throw new Exception(ex);
        }
    }



}