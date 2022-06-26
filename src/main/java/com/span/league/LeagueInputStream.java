package com.span.league;

import java.util.List;

public abstract class LeagueInputStream {

    private int inputLineIndex = 0;

    public int getInputLineIndex() {
        return inputLineIndex;
    }

    public void setInputLineIndex(int inputLineIndex) {
        this.inputLineIndex = inputLineIndex;
    }

    protected int initInputLines() {
        return 0;
    }

    public List<String> getInputLines() {
        return null;
    }

    public String getNextInputLine() {
        return null;
    }

    public int getInputLinesLength() {
        return 0;
    }

    protected boolean hasMoreLines(){
        return getInputLineIndex() < getInputLinesLength();
    }

}
