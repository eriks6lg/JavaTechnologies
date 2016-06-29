package main.java.ee.itcollege.tetris.dao;

import main.java.ee.itcollege.tetris.entity.Score;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by eriks on 28.06.2016.
 */
public class ScoreFileDao {
    public List<Score> loadScores() {
        try {
            ObjectInputStream input = new ObjectInputStream(new FileInputStream(new File("db/scores.dat")));
            List<Score> scores = (List<Score>)input.readObject();
            input.close();
            return scores;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<Score>();
    }

    public void persistScores(List<Score> scores) {
        try {
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(new File("db/scores.dat")));
            output.writeObject(scores);
            output.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
