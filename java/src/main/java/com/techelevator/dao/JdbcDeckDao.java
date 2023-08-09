package com.techelevator.dao;

import com.techelevator.model.Deck;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcDeckDao {
    private final JdbcTemplate jdbcTemplate;


    public JdbcDeckDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;


    }

    public void createDeck(Deck deck) {

        String sql = "INSERT INTO deck (deck_id, deckname, user_id) " +
                "VALUES (?, ?, ?);";
        jdbcTemplate.update(sql, deck.getDeck_id(), deck.getDeckName(), deck.getUser_id());
    }

        public List<Deck> findAll(Deck deck) {
        List<Deck> decks = new ArrayList<>();
        String sql = "SELECT * \n" +
                "FROM deck\n" +
                "LEFT JOIN flashcard_deck on flashcard_deck.deck_id = deck.deck_id\n" +
                "LEFT JOIN flashcard on flashcard.deck_id = flashcard_deck.deck_id\n" +
                "WHERE deck.user_id = ?;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, deck.getUser_id());
        while (results.next()) {
            deck = mapRowToDeck(results);
            decks.add(deck);
        }

        return decks;
    }

    private Deck mapRowToDeck(SqlRowSet rs) {
        Deck deck = new Deck();
        deck.setDeck_id(rs.getInt("deck_id"));
        deck.setDeckName(rs.getString("deckname"));
        deck.setUser_id(rs.getInt("user_id"));
        return deck;
    }
}
