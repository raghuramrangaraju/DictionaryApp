package com.example.raghuram.dictionaryapp.Model;

/**
 * Created by raghuram on 11/18/16.
 */
public class Wordsclass {
    private String words;
    private String Tamilmeaning;
    private String Englishmeaning;


    public Wordsclass(String words,String tamilmeaning, String englishmeaning) {
        this.words = words;
        this.Tamilmeaning = tamilmeaning;
        this.Englishmeaning = englishmeaning;
    }

    public String getWords() {
        return words;
    }

    public void setWords(String words) {
        this.words = words;
    }

    public String getTamilmeaning() {
        return Tamilmeaning;
    }

    public void setTamilmeaning(String tamilmeaning) {
        Tamilmeaning = tamilmeaning;
    }

    public String getEnglishmeaning() {
        return Englishmeaning;
    }

    public void setEnglishmeaning(String englishmeaning) {
        Englishmeaning = englishmeaning;
    }
}
