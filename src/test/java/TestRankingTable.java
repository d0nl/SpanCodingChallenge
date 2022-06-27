import com.span.league.LeagueFileInputStreamImpl;
import com.span.league.LeagueInputStream;
import com.span.league.LeagueRankingTable;
import com.span.league.LeagueStdInInputStreamImpl;
import com.span.main.LeagueRank;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestRankingTable {

    @Test
    public void TestRanking() throws Exception {
        String[] expectedValues = {
                "1. Tarantulas, 6 pts",
                "2. Lions, 5 pts",
                "3. Ants, 2 pts",
                "3. FC Awesome, 2 pts",
                "4. Abis, 1 pt",
                "4. Grouches, 1 pt",
                "4. Jgs, 1 pt",
                "4. Snakes, 1 pt"
        };

        String pathString = convertPathToOS("src\\test\\resources\\sampleinput.txt");
        String pathStringUt = convertPathToOS("src\\test\\resources\\output_ut.txt");

        LeagueInputStream stream = new LeagueFileInputStreamImpl(pathString, pathStringUt);
        LeagueRankingTable rankingTable = new LeagueRankingTable(stream);
        int statusCode = rankingTable.processStream();
        assertEquals(statusCode, LeagueRank.STATUS_OK);

        //Check output file against expected results
        Path path = Paths.get(pathStringUt);
        try(BufferedReader reader = Files.newBufferedReader(path)) {
            for(int i = 0; i < expectedValues.length; i++) {
                String line = reader.readLine();
                System.out.println(line);
                assertEquals(expectedValues[i], line);
            }
        } catch(Exception ex){
            throw new Exception(ex);
        }
    }

    private String convertPathToOS(String pathToConvert){
        char fileSeparator = FileSystems.getDefault().getSeparator().charAt(0);
        //Convert to Linux if should
        String os = System.getProperty("os.name").toLowerCase();
        if(!os.contains("windows")){
            //Assume linux or OSX - I don't have a Mac!
            pathToConvert = pathToConvert.replace('\\', fileSeparator);
        }
        return pathToConvert;

    }
}