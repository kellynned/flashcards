package com.techelevator.model;

public class Deck {
    
    private int deck_id;
    private String deckName;
    private int user_id;

    public Deck(int deck_id, String deckName, int user_id) {
        this.deck_id = deck_id;
        this.deckName = deckName;
        this.user_id = user_id;
    }

    public Deck() {
    }

    public int getDeck_id() {
        return deck_id;
    }

    public void setDeck_id(int deck_id) {
        this.deck_id = deck_id;
    }

    public String getDeckName() {
        return deckName;
    }

    public void setDeckName(String deckName) {
        this.deckName = deckName;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
