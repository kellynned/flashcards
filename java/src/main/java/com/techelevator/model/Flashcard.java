package com.techelevator.model;

public class Flashcard {

    private int flashcardId;
    private int userId;
    private String question;
    private String answer;
    private String subject;
    private String deckName;

    public Flashcard(int flashcardId, int userId, String question, String answer, String subject, String deckName) {
        this.flashcardId = flashcardId;
        this.question = question;
        this.answer = answer;
        this.subject = subject;
        this.deckName = deckName;
        this.userId = userId;
    }

    public Flashcard() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getFlashcardId() {
        return flashcardId;
    }

    public void setFlashcardId(int flashcardId) {
        this.flashcardId = flashcardId;
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
