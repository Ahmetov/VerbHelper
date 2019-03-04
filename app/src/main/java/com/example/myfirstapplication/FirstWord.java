package com.example.myfirstapplication;

public class FirstWord {

    private int id;

    private String first;

    private String second;

    public FirstWord(){}

    public FirstWord(int id, String first, String second) {
        this.id = id;
        this.first = first;
        this.second = second;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String name) {
        this.first = name;
    }

    public String getSecond() {
        return second;
    }

    public void setSecond(String second) {
        this.second = second;
    }
}
