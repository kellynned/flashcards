package com.techelevator.dao;

import com.techelevator.model.Flashcard;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

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
