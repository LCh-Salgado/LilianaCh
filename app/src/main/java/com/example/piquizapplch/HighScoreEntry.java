package com.example.piquizapplch;

public class HighScoreEntry {

    private String name;
    private int score;

    public void setScore(int score) {
        this.score = score;
    }

    public double getScore() {
        return score;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HighScoreEntry(String name) {
        this.name = name;
    }
}