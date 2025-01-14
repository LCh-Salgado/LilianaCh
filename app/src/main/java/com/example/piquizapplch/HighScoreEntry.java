package com.example.piquizapplch;

public class HighScoreEntry implements Comparable {

    private String name;
    private int score;

    public HighScoreEntry(String name, int score) {
        this.name = name;
        this.score = score;
    }
    public HighScoreEntry() {
        this.name = "";
        this.score = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public int compareTo(Object obj) {
        HighScoreEntry other = (HighScoreEntry) obj;
        return other.score - this.score;
    }

    @Override
    public String toString() {
        return "HighScoreEntry{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}