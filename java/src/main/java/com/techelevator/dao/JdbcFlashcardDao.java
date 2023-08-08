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


    }

    private Flashcard mapRowToTransaction(SqlRowSet rs){
        Flashcard flashcard = new Flashcard();
        flashcard.setId(rs.getInt("id"));
        flashcard.setAnswer(rs.getString("answer"));
        flashcard.setQuestion(rs.getString("question"));
        flashcard.setSubject(rs.getString("subject"));
        flashcard.setDeckName(rs.getString("deckName"));
        return flashcard;
    }
}
