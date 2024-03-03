package model;

import util.QuizUtilities;

public class Result {
    private String resultName;
    private String resultDescription;

    public Result(String resultName, String resultDescription){
        setResultName(resultName);
        setResultDescription(resultDescription);
    }

    public String getResultName() {
        return resultName;
    }

    public void setResultName(String resultName) {
        this.resultName = QuizUtilities.getFittingString(resultName, false);
    }

    public String getResultDescription() {
        return resultDescription;
    }

    public void setResultDescription(String resultDescription) {
        this.resultDescription = util.QuizUtilities.getFittingString(resultDescription, true);
    }
}
