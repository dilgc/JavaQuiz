package SampleQuizzes;

import model.Answer;
import model.Question;
import model.Quiz;
import model.Result;

/**
 * Sample quiz(zes) that are hard coded for early testing purposes.
 * Marked for removal for final versions.
 */
public class SampleQuizzes {

    /**
     * Sample for testing purposes.
     * @return A sample quiz someone may make.
     */
    public static Quiz Sample_WhichDangan() {


        Quiz danganQuiz = new Quiz(5, 5, "Which Danganronpa Character are you?");
        Result result1 = new Result("Junko Enoshima", "You are evil.");
        Result result2 = new Result("Makoto Naegi", "You are the protagonist!");
        Result result3 = new Result("Monokuma", "You are the mascot!");
        Result result4 = new Result("Kyoko Kirigiri", "You are the detective!");
        Result result5 = new Result("Hifumi Yamada", "I am sorry.");

        Question question1 = new Question("Are you evil?", 5);
        Answer q1Answer1 = new Answer("Yes", 0);
        question1.addAnswer("Yes!", 0);
        question1.addAnswer("No, definitely not.", 1);
        question1.addAnswer("Depends on who you ask.", 2);
        question1.addAnswer("Neutral", 3);
        question1.addAnswer("I love anime!", 4);

        Question question2 = new Question("What is your favorite color?", 5);
        question2.addAnswer("Red", 0);
        question2.addAnswer("Brown", 1);
        question2.addAnswer("Black", 2);
        question2.addAnswer("Purple", 3);
        question2.addAnswer("I like all colors.", 4);

        Question question3 = new Question("What is most important to you?",5);
        question3.addAnswer("Despair", 0);
        question3.addAnswer("Hope", 1);
        question3.addAnswer("Entertainment", 2);
        question3.addAnswer("Pursuit of the truth", 3);
        question3.addAnswer("My passions", 4);

        Question question4 = new Question("Who is your favorite character?", 5);
        question4.addAnswer("Junko Enoshima", 0);
        question4.addAnswer("Makoto Naegi", 1);
        question4.addAnswer("Monokuma", 2);
        question4.addAnswer("Kyoko Kirigiri", 3);
        question4.addAnswer("Hifumi Yamada", 4);

        Question question5 = new Question("Did you enjoy the quiz?", 5);
        question5.addAnswer("It filled me with despair.", 0);
        question5.addAnswer("It filled me with hope.", 1);
        question5.addAnswer("Puhuhuhuhu", 2);
        question5.addAnswer("Give me the results.", 3);
        question5.addAnswer("Yes, I loved it.", 4);

        //Fill the quiz with the results and questions
        danganQuiz.addResult(result1);
        danganQuiz.addResult(result2);
        danganQuiz.addResult(result3);
        danganQuiz.addResult(result4);
        danganQuiz.addResult(result5);

        danganQuiz.addQuestion(question1);
        danganQuiz.addQuestion(question2);
        danganQuiz.addQuestion(question3);
        danganQuiz.addQuestion(question4);
        danganQuiz.addQuestion(question5);

        return danganQuiz;
    }

     //More sample quizzes will be added to demonstrate program capabilities.

}
