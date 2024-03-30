package com.tinder_application.models;

public class Match {
    private int matchId;
    private int userId1;
    private int userId2;
    private boolean isMatched;

    public Match(int matchId, int userId1, int userId2, boolean isMatched) {
        this.matchId = matchId;
        this.userId1 = userId1;
        this.userId2 = userId2;
        this.isMatched = isMatched;
    }

    public Match(){}

    public int getMatchId() {
        return matchId;
    }

    public void setMatchId(int matchId) {
        this.matchId = matchId;
    }

    public int getUserId1() {
        return userId1;
    }

    public void setUserId1(int userId1) {
        this.userId1 = userId1;
    }

    public int getUserId2() {
        return userId2;
    }

    public void setUserId2(int userId2) {
        this.userId2 = userId2;
    }

    public boolean isMatched() {
        return isMatched;
    }

    public void setMatched(boolean matched) {
        isMatched = matched;
    }
}
