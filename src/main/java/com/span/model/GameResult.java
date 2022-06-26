package com.span.model;

public class GameResult {

    TeamScore teamA;
    TeamScore teamB;

    public GameResult(TeamScore teamA, TeamScore teamB) {
        this.teamA = teamA;
        this.teamB = teamB;
    }

    public TeamScore getTeamA() {
        return teamA;
    }

    public void setTeamA(TeamScore teamA) {
        this.teamA = teamA;
    }

    public TeamScore getTeamB() {
        return teamB;
    }

    public void setTeamB(TeamScore teamB) {
        this.teamB = teamB;
    }
}
