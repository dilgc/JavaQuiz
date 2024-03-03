package model;

import java.util.ArrayList;
import java.util.Iterator;

public class QuizBag {
    private int numQuizzes = 0;
    private ArrayList<Quiz> quizBag;

    public QuizBag() {
        this.quizBag = new ArrayList();
    }

    public void insertQuiz(Quiz quiz){
        quizBag.add(quiz);
        numQuizzes++;
    }

    public ArrayList<Quiz> getQuizzes(){
        return this.quizBag;
    }

    /**
     * @param pageNum The page being accessed
     * @return The quizzes on that page
     */
    public ArrayList<Quiz> getPageQuizzes(int pageNum){
        ArrayList<Quiz> quizzesInPage = new ArrayList<>();
        if(numQuizzes > ((pageNum - 1) * 4)) {
            Iterator<Quiz> iterator = quizBag.listIterator((pageNum - 1) * 4);
            int count = 0;
            while (iterator.hasNext() && count < 4) {
                quizzesInPage.add(iterator.next());
                count++;
            }
        }
        return quizzesInPage;
    }
}
