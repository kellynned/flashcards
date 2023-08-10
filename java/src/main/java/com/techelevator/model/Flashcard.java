package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Flashcard {

    private int flashcardId;
    private int userId;
    private String question;
    private String answer;
    private String subject;

    @JsonProperty("deck_id")
    private int deck_id;

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

    public int getDeckId() {
        return deck_id;
    }

    public void setDeckId(int deck_id) {
        this.deck_id = deck_id;
    }
}
