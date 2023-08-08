package com.techelevator.model;

public class Flashcard {

    private int id;
    private String question;
    private String answer;
    private String subject;
    private String deckName;

    public Flashcard(int id, String question, String answer, String subject, String deckName) {
        this.id = id;
        this.question = question;
        this.answer = answer;
        this.subject = subject;
        this.deckName = deckName;
    }

    public Flashcard() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDeckName() {
        return deckName;
    }

    public void setDeckName(String deckName) {
        this.deckName = deckName;
    }


}
