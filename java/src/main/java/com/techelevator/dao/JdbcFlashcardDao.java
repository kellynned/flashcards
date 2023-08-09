package com.techelevator.dao;

import com.techelevator.model.Flashcard;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcFlashcardDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcFlashcardDao (JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public void createFlashcard(Flashcard flashcard){

        String sql = "INSERT INTO flashcards (answer, question, subject, user_id) " +
                "VALUES (?, ?, ?, ?);";

        jdbcTemplate.update(sql, flashcard.getAnswer(), flashcard.getQuestion(), flashcard.getSubject(),flashcard.getUserId());

    }

//    public List<Flashcard> findAll() {
//        List<Flashcard> transfers = new ArrayList<>();
//        String sql = "SELECT * \n" +
//                "FROM deck\n" +
//                "LEFT JOIN flashcard_deck on flashcard_deck.deck_id = deck.deck_id\n" +
//                "LEFT JOIN flashcard on flashcard.deck_id = flashcard_deck.deck_id\n" +
//                "WHERE deck.deck_id = 2;";
//
//        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
//        while (results.next()) {
//            Flashcard flashcard = mapRowToFlashcard(results);
//            transfers.add(flashcard);
//        }
//
//        return transfers;
//    }

    private Flashcard mapRowToFlashcard(SqlRowSet rs){
        Flashcard flashcard = new Flashcard();
        flashcard.setFlashcardId(rs.getInt("flashcard_id"));
        flashcard.setUserId(rs.getInt("user_id"));
        flashcard.setAnswer(rs.getString("answer"));
        flashcard.setQuestion(rs.getString("question"));
        flashcard.setSubject(rs.getString("subject"));
        flashcard.setDeckName(rs.getString("deckName"));
        return flashcard;
    }
}
