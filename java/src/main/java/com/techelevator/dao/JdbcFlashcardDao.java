package com.techelevator.dao;

import com.techelevator.model.Flashcard;
import com.techelevator.model.User;
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

        String sql = "INSERT INTO flashcard (answer, question, subject, user_id) " +
                "VALUES (?, ?, ?, ?);";

        jdbcTemplate.update(sql, flashcard.getAnswer(), flashcard.getQuestion(), flashcard.getSubject(), flashcard.getUserId());

    }

    public void updateFlashcard(Flashcard flashcard, int id) {
        String sql = "update flashcard \n" +
                "set subject = ?, question = ?, answer = ? " +
                "where flashcard_id = ?;";

        jdbcTemplate.update(sql,flashcard.getSubject(), flashcard.getQuestion(), flashcard.getAnswer(), id);
    }

    public List<Flashcard> findAll(User user) {
        List<Flashcard> flashcards = new ArrayList<>();
        String sql = "SELECT * FROM flashcard where user_id = ?";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, user.getId());
        while (results.next()) {
            flashcards.add(mapRowToFlashcard(results));
        }

        return flashcards;
    }



    public List<Flashcard> findAllByDeck( int id) {
        List<Flashcard> flashcards = new ArrayList<>();
        String sql = "select * from flashcard \n" +
                "join flashcard_deck as fd on flashcard.flashcard_id = fd.flashcard_id\n" +
                "join deck on deck.deck_id = fd.deck_id\n" +
                "where fd.deck_id = ?;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
        while (results.next()) {
            flashcards.add(mapRowToFlashcard(results));
        }

        return flashcards;
    }

    private Flashcard mapRowToFlashcard(SqlRowSet rs){
        Flashcard flashcard = new Flashcard();
        flashcard.setFlashcardId(rs.getInt("flashcard_id"));
        flashcard.setUserId(rs.getInt("user_id"));
        flashcard.setSubject(rs.getString("subject"));
        flashcard.setQuestion(rs.getString("question"));
        flashcard.setAnswer(rs.getString("answer"));
        return flashcard;
    }

    public List<Flashcard> findFiltered(User creator, String input) {
        List<Flashcard> flashcards = new ArrayList<>();
        input = "%" + input + "%";

        String sql = "SELECT * FROM flashcard WHERE flashcard.subject ILIKE ? AND user_id = ?;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, input, creator.getId());
        while (results.next()) {
            flashcards.add(mapRowToFlashcard(results));
        }

        return flashcards;    }
}
