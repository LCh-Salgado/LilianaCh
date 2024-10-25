package com.example.piquizapplch;

public class Question {

    private String qText;
    private  boolean correctAns;
    

    public  Question() {
        qText = "unknow";
        correctAns = true;
    }

    public Question(String sQText, boolean sCorrectAns) {
        qText = sQText;
        correctAns = sCorrectAns;
    }

    public boolean getCorrAns() {
        return correctAns;
    }

    public void  setQText(String newQT) {
        qText = newQT;
    }

    public String getQText() {
        return qText;
    }

    public void setCorrect(boolean newA) {
        correctAns = newA;
    }

    @Override
    public String toString() {
        return "question Text: " + qText +
            "correctAnswers" +  correctAns;
    }
}
