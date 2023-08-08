package com.techelevator.controller;

import com.techelevator.dao.UserDao;
import com.techelevator.dao.JdbcFlashcardDao;
import com.techelevator.model.Flashcard;
import com.techelevator.model.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;


@RestController
public class FlashcardController {
    private final JdbcFlashcardDao jdbcFlashcardDao;
    private final UserDao userDao;

    public FlashcardController(JdbcFlashcardDao jdbcFlashcardDao, UserDao userDao) {
        this.jdbcFlashcardDao = jdbcFlashcardDao;
        this.userDao = userDao;
    }

    @RequestMapping(value = "/flaschards", method = RequestMethod.POST)
    public void newFlashcard(@RequestBody Flashcard flashcard, Principal principal){
        User creator = userDao.getUserByUsername(principal.getName());

    }

}
