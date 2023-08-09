package com.techelevator.dao;

import com.techelevator.model.Deck;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcDeckDao {
    private final JdbcTemplate jdbcTemplate;


    public JdbcDeckDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;


    }
    public void createDeck(Deck deck){

        String sql = "INSERT INTO deck (deck_id, deckname, user_id) " +
                "VALUES (?, ?, ?);";
        jdbcTemplate.update(sql, deck.getDeck_id(), deck.getDeckName(), deck.getUser_id());
    }
    private Deck mapRowToDeck(SqlRowSet rs){
        Deck deck = new Deck();
        deck.setDeck_id(rs.getInt("deck_id"));
        deck.setDeckName(rs.getString("deckname"));
        deck.setUser_id(rs.getInt("user_id"));
        return deck;
}
}
