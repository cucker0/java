package com.java.exercise.test;

import com.java.exercise.Score;
import org.junit.Test;

public class TestScore {
    @Test
    public void test1() {
        Score s1 = new Score();

        s1.inputScore();
        s1.showScore();
    }

}
