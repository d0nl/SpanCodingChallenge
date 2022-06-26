package com.span.league;

import com.span.main.LeagueRank;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static java.nio.file.Files.newBufferedReader;

public class LeagueFileInputStreamImpl extends LeagueFileInputStream {

    List<String> inputLines = null;

    public LeagueFileInputStreamImpl(String inputFileName, String outputFileName) {
        setInputFileName(inputFileName);
        setOutputFileName(outputFileName);
    }

    @Override
    public int initInputLines() {
        Path path = null;
        BufferedReader reader = null;
        int statusCode = LeagueRank.STATUS_OK;
        try {
            int retValue = LeagueRank.STATUS_OK;
            System.out.println("Processing " + getInputFileName() + " " + getOutputFileName());

            path = Paths.get(getInputFileName());
            reader = newBufferedReader(path);

            inputLines = new ArrayList();
            reader.lines().forEach(
                    line -> inputLines.add(line));
            setInputLineIndex(0);

        } catch (NoSuchFileException ex) {
            System.out.println(ex);
            statusCode = LeagueRank.STATUS_INPUTFILE_NOTFOUND;
        } catch (IOException ex) {
            ex.printStackTrace();
            statusCode = LeagueRank.STATUS_IOEXCEPTION;
        } catch (Exception ex) {
            ex.printStackTrace();
            statusCode = LeagueRank.STATUS_EXCEPTION;
        } finally {
            if(!(reader == null)){
                try {
                    reader.close();
                } catch(Exception ex){
                    ex.printStackTrace();
                    statusCode = LeagueRank.STATUS_EXCEPTION;
                }
            }
        }
        return statusCode;
    }

    @Override
    public List<String> getInputLines() {
        return inputLines;
    }

    @Override
    public String getNextInputLine() {
        int index = getInputLineIndex();
        String line = inputLines.get(index++);
        setInputLineIndex(index);
        return line;
    }

    @Override
    public int getInputLinesLength() {
        return inputLines.size();
    }

}
