package com.techelevator.controller;

import com.techelevator.dao.JdbcDeckDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Deck;
import com.techelevator.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin
public class DeckController {
    private final JdbcDeckDao jdbcDeckDao;
    private final UserDao userDao;

    public DeckController(JdbcDeckDao jdbcDeckDao, UserDao userDao) {
        this.jdbcDeckDao = jdbcDeckDao;
        this.userDao = userDao;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/decks", method = RequestMethod.POST)
    public void newDeck(@RequestBody Deck deck, Principal principal){
        User creator = userDao.getUserByUsername(principal.getName());

        deck.setUser_id(creator.getId());
        jdbcDeckDao.createDeck(deck);
    }

    @RequestMapping(value = "/decks", method = RequestMethod.GET)
    public  List<Deck> getDecks(Principal principal){
        User creator = userDao.getUserByUsername(principal.getName());


        return jdbcDeckDao.findAll(creator);
    }

}
