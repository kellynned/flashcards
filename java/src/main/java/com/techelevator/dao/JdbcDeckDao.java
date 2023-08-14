package com.techelevator.dao;

import com.techelevator.model.Deck;
import com.techelevator.model.Flashcard;
import com.techelevator.model.User;
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

        String sql = "INSERT INTO deck (deckname, user_id) " +
                "VALUES (?, ?);";
        jdbcTemplate.update(sql, deck.getDeckName(), deck.getUser_id());
    }

        public List<Deck> findAll(User user) {
        List<Deck> decks = new ArrayList<>();
        String sql = "SELECT distinct deck.deck_id, deckname, deck.user_id\n" +
                "FROM deck\n" +
                "LEFT JOIN flashcard_deck on flashcard_deck.deck_id =  deck.deck_id\n" +
                "LEFT JOIN flashcard on flashcard.flashcard_id = flashcard_deck.flashcard_id\n" +
                "WHERE deck.user_id = ?";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, user.getId());
        while (results.next()) {
            decks.add(mapRowToDeck(results));
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
