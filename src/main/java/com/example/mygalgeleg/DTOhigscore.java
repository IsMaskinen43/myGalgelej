package com.example.mygalgeleg;

import java.io.Serializable;

public class DTOhigscore  implements Serializable {
    private String name;
    private String word;
    private int failedGeuss;

    public DTOhigscore(String name, String word, int failedGeuss){
        this.name = name;
        this.word = word;
        this.failedGeuss = failedGeuss;
    }

    public int getFailedGeuss() {
        return failedGeuss;
    }

    public String getName() {
        return name;
    }

    public String getWord() {
        return word;
    }
    public String toString(){
        return "Name: " + name + " Word: " + word + " Failed: " + failedGeuss;
    }
}
