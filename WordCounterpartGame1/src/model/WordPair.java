package model;




import java.util.*;


public class WordPair {
    private String word;
    private String counterpart;
    private String language;

    public WordPair(String word, String counterpart, String language) {
        this.word = word.toLowerCase().trim();
        this.counterpart = counterpart.trim();
        this.language = language;
    }

    public String getWord() {
        return word;
    }

    public String getCounterpart() {
        return counterpart;
    }

    public String getLanguage() {
        return language;
    }
}