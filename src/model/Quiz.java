package model;

import util.CommonRules;
import util.QuizUtilities;

import javax.swing.*;

public class Quiz implements util.CommonRules {

    private String title;
    private int numQuestions;
    private int numResults;
    private Question[] questions;
    private Result[] results;
    private int questionCount;
    private int resultCount;

    public Quiz(int numQuestions, int numResults, String title){
        questions = new Question[numQuestions];
        results = new Result[numResults];
        setNumQuestions(numQuestions);
        questionCount = 0;
        resultCount = 0;
        setTitle(title);
    }
    public Quiz(Quiz quiz){
        this(quiz.getNumQuestions(), quiz.getNumQuestions(), quiz.getTitle());
    }
    public void setNumResults(int numResults) {
        this.numResults = numResults;
    }



    public void addQuestion(Question question){
        questions[questionCount++] = question;
    }

    public void addResult(Result result){
        results[resultCount++] = result;
    }
    public int getNumQuestions() {
        return numQuestions;
    }

    public void setNumQuestions(int numQuestions) {
        if(numQuestions < CommonRules.MAXIMUM_QUESTIONS) {
            this.numQuestions = numQuestions;
        }
        else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Please enter a number of questions below ");
            stringBuilder.append(CommonRules.MAXIMUM_QUESTIONS);

            this.numQuestions = Integer.parseInt(JOptionPane.showInputDialog(null, stringBuilder.toString(), "Input", JOptionPane.WARNING_MESSAGE));

            //FIXME this will crash the program if the user enters a non-integer for some reason
        }
    }

    public String getTitle() {
        return title;
    }

    /**
     * Takes in the title and makes sure an unexpected amount or type of character is not in the equation
     * @param title
     */
    public void setTitle(String title) {
        this.title = QuizUtilities.getFittingString(title, false);
    }
}
