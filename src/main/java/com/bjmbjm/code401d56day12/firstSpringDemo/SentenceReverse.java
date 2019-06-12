package com.bjmbjm.code401d56day12.firstSpringDemo;

public class SentenceReverse {
    private final long id;
    private String sentence;

    public SentenceReverse(long id, String sentence){
        if(id < 0) {
            throw new IllegalArgumentException("id must be positive a integer.");
        }
        this.id = id;
        if(sentence.equals("") || sentence.equals(" ")){
            throw new IllegalArgumentException("sentence must contain an alphanumeric character " +
                    "and not be empty.");
        }
        this.sentence = sentence;
    }

    public long getId(){
        return this.id;
    }

    public String getSentence(){
        return reverseSentence();
    }

    private String reverseSentence() {
        if(this.sentence.length() == 1){
            return this.sentence;
        }
        String[] tmp = this.sentence.split(" ");
        for(int i = 0; i < tmp.length/2; i++) {
            int fromLastIndex = tmp.length - i - 1;
            String strTmp = tmp[i];
            tmp[i] = tmp[fromLastIndex];
            tmp[fromLastIndex] = strTmp;
        }

        this.sentence = String.join(" ", tmp);
        return this.sentence;
    }


}
