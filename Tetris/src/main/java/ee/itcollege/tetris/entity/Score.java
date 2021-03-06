package main.java.ee.itcollege.tetris.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Score implements Serializable{



    private String playerName;
    private int score;

    public Score(String playerName, int score) {
        if(null != playerName) {
            setPlayerName(playerName.trim());
            setScore(score);
        }

    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        if(null == playerName|| "".equals(playerName.trim())) {
            throw new IllegalArgumentException("empty name!");
        }
        this.playerName = playerName;
    }

    public int getScore() {
        return score;
    }

    private void setScore(int score) {
        if(score < 0) {
            throw new IllegalArgumentException("negative score!");
        }
        this.score = score;
    }
}
