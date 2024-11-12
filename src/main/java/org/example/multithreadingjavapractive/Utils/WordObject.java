package org.example.multithreadingjavapractive.Utils;

public class WordObject{
    private String word;
    private String wordType;
    private String wordDefinition;

    public WordObject(String word, String wordType, String wordDefinition) {
        this.word = word;
        this.wordType = wordType;
        this.wordDefinition = wordDefinition;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getWordType() {
        return wordType;
    }

    public void setWordType(String wordType) {
        this.wordType = wordType;
    }

    public String getWordDefinition() {
        return wordDefinition;
    }

    public void setWordDefinition(String wordDefinition) {
        this.wordDefinition = wordDefinition;
    }
}
