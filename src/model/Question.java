package model;

import util.QuizUtilities;

public class Question {
    private String question;
    private Answer[] answers;
    private int answerCount;

    public Question(String question, int numAnswers) {
        setQuestion(question);
        answers = new Answer[numAnswers];
        answerCount = 0;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = QuizUtilities.getFittingString(question, false);
    }

    /**
     * Creates an answer for the question and adds it to the question
     * @param answerText The text of the answer
     * @param resultNum The correlating result the answer contributes to
     */
    public void addAnswer(String answerText, int resultNum){
        answers[answerCount++] = new Answer(answerText, resultNum);
    }
}
