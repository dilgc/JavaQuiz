package model;

import util.CommonRules;
import util.QuizUtilities;

import javax.swing.*;

public class Answer {

    //Declare the variables
    private int resultNum;
    private String answerText;

    /**
     *
     * @param answerText The string attributed to the question
     * @param resultNum the number result that this answer correlates with,
     *                  for example, let's say Batman is #3 on a which character are you quiz,
     *                  if the question is "Favorite animal", the answer "Bat" will have resultNum = 3
     */
    public Answer(String answerText, int resultNum){
        setAnswerText(answerText);
        setResultNum(resultNum);
    }

    public int getResultNum() {
        return resultNum;
    }

    public void setResultNum(int resultNum) {
        this.resultNum = resultNum;
    }

    public String getAnswerText() {
        return answerText;
    }

    public void setAnswerText(String answerText) {
        this.answerText = QuizUtilities.getFittingString(answerText, false);
    }
}
