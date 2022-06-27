package com.span.league;

import com.span.model.TeamScore;

import java.util.ArrayList;
import java.util.List;

public abstract class LeagueInputStream {

    private int inputLineIndex = 0;

    protected int initInputLines() { return 0; }

    public int writeOutputStream(ArrayList<TeamScore> list) { return 0; };
    public List<String> getInputLines() { return null; }
    public String getNextInputLine() { return ""; }
    public int getInputLinesLength() { return 0; };

    public void setInputLineIndex(int inputLineIndex) {
        this.inputLineIndex = inputLineIndex;
    }

    public int getInputLineIndex() {
        return inputLineIndex;
    }

    public boolean hasMoreLines(){
        return getInputLineIndex() < getInputLinesLength();
    }

}
