package com.techelevator.controller;

import com.techelevator.dao.UserDao;
import com.techelevator.dao.JdbcFlashcardDao;
import com.techelevator.model.Deck;
import com.techelevator.model.Flashcard;
import com.techelevator.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;


@RestController
@CrossOrigin
public class FlashcardController {
    private final JdbcFlashcardDao jdbcFlashcardDao;
    private final UserDao userDao;

    public FlashcardController(JdbcFlashcardDao jdbcFlashcardDao, UserDao userDao) {
        this.jdbcFlashcardDao = jdbcFlashcardDao;
        this.userDao = userDao;
    }
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/flashcards", method = RequestMethod.POST)
    public void newFlashcard(@RequestBody Flashcard flashcard, Principal principal){
        User creator = userDao.getUserByUsername(principal.getName());

        flashcard.setUserId(creator.getId());
        jdbcFlashcardDao.createFlashcard(flashcard);
    }

    @RequestMapping(value = "/flashcards", method = RequestMethod.GET)
    public List<Flashcard> getFlashcards(Principal principal){
        User creator = userDao.getUserByUsername(principal.getName());


        return jdbcFlashcardDao.findAll(creator);
    }
    @RequestMapping(value = "/flashcards/{input}", method = RequestMethod.GET)
    public List<Flashcard> getFilteredFlashcards(@PathVariable String input, Principal principal){
        User creator = userDao.getUserByUsername(principal.getName());


        return jdbcFlashcardDao.findFiltered(creator, input);
    }

    @RequestMapping(value = "/flashcard/{id}", method = RequestMethod.PUT)
    public void updateFlashcard(@PathVariable int id, Principal principal){
        jdbcFlashcardDao.updateFlashcard(id);
    }



    @RequestMapping(value = "/decks/{id}", method = RequestMethod.GET)
    public  List<Flashcard> getDecks(@PathVariable int id, Principal principal){

        return jdbcFlashcardDao.findAllByDeck(id);
    }

}
