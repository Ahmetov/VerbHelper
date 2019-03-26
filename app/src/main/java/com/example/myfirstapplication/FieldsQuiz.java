package com.example.myfirstapplication;

public class FieldsQuiz {
    private String word;
    private  String trans;
    private boolean isAnswer = false;
    private boolean isUsed = false;

    public FieldsQuiz(String word, String trans, boolean isAnswer) {
        this.word = word;
        this.trans = trans;
        this.isAnswer = isAnswer;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getTrans() {
        return trans;
    }

    public void setTrans(String trans) {
        this.trans = trans;
    }

    public boolean isAnswer() {
        return isAnswer;
    }

    public void setAnswer(boolean answer) {
        isAnswer = answer;
    }
}
