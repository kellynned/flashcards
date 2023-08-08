package com.techelevator.controller;

import com.techelevator.dao.UserDao;
import com.techelevator.dao.JdbcFlashcardDao;
import com.techelevator.model.Flashcard;
import com.techelevator.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;


@RestController
public class FlashcardController {
    private final JdbcFlashcardDao jdbcFlashcardDao;
    private final UserDao userDao;

    public FlashcardController(JdbcFlashcardDao jdbcFlashcardDao, UserDao userDao) {
        this.jdbcFlashcardDao = jdbcFlashcardDao;
        this.userDao = userDao;
    }
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/flaschards", method = RequestMethod.POST)
    public void newFlashcard(@RequestBody Flashcard flashcard, Principal principal){
        User creator = userDao.getUserByUsername(principal.getName());

        flashcard.setUserId(creator.getId());
        jdbcFlashcardDao.createFlashcard(flashcard);
    }

}
