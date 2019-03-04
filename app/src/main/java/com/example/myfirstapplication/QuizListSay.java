package com.example.myfirstapplication;

public class QuizListSay {

    private String q;
    private String answ;
    private boolean isAnswer = false;

    public QuizListSay(String answ, String q, boolean isAnswer) {
        this.answ = answ;
        this.q = q;
        this.isAnswer = isAnswer;
    }

    public String getAnsw() {
        return answ;
    }

    public void setAnsw(String answ) {
        this.answ = answ;
    }

    public QuizListSay(String answ, String q) {
        this.answ = answ;
        this.q = q;
    }

    public String getQ() {
        return q;
    }

    public void setQ(String q) {
        this.q = q;
    }

    public boolean isAnswer() {
        return isAnswer;
    }

    public void setAnswer(boolean answer) {
        isAnswer = answer;
    }
}
