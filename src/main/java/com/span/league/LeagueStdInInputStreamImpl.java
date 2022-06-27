package com.span.league;

import com.span.main.LeagueRank;
import com.span.model.TeamScore;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.CharBuffer;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;


public class LeagueStdInInputStreamImpl extends LeagueStdInInputStream {

    List<String> inputLines = null;

    @Override
    public int initInputLines() {

        int statusCode = LeagueRank.STATUS_OK;
        try {
            int retValue = LeagueRank.STATUS_OK;
            inputLines = new ArrayList<String>();

            BufferedInputStream stream = new BufferedInputStream(System.in);
            Scanner scanner = new Scanner(stream);
            String lineSeparator = System.lineSeparator();

            //Skip control characters - Tested on Windows and Linux
            scanner.useDelimiter("[\\t\\n\\x0B\\f\\r]");

            while(scanner.hasNext()) {
                String line = scanner.next();
                if(!line.isEmpty()) {
                    inputLines.add(line);
                }
            }
            setInputLineIndex(0);

        } catch(Exception ex){
            ex.printStackTrace();
            statusCode = LeagueRank.STATUS_EXCEPTION;
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

    @Override
    public int writeOutputStream(ArrayList<TeamScore> list) {
        int rank = 0;
        int lastScore = -1;
        for (int i = 0; i < list.size(); i++) {
            TeamScore s = list.get(i);
            if(s.getTeamScore() != lastScore){
                rank++;
                lastScore = s.getTeamScore();
            }
            System.out.println(rank
                    + ". "
                    + s.getTeamName()
                    + ", "
                    + s.getTeamScore()
                    + " "
                    + (s.getTeamScore() == 1 ? "pt" : "pts")
            );
        }
        return LeagueRank.STATUS_OK;
    }


}
