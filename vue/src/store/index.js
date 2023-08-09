import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'

Vue.use(Vuex)

/*
 * The authorization header is set for axios when you login but what happens when you come back or
 * the page is refreshed. When that happens you need to check for the token in local storage and if it
 * exists you should set the header so that it will be attached to each request
 */
const currentToken = localStorage.getItem('token')
const currentUser = JSON.parse(localStorage.getItem('user'));

if (currentToken != null) {
  axios.defaults.headers.common['Authorization'] = `Bearer ${currentToken}`;
}


export default new Vuex.Store({
  
  state: {
    token: currentToken || '',
    user: currentUser || {},
    flashcards: [
      {
        subject: "math",
        question: "What is the Pythagorean theorem?",
        answer: "In a right triangle, the square of the length of the hypotenuse is equal to the sum of the squares of the lengths of the other two sides.",
        deck: "Mathematics"
      },
      {
        subject: "science",
        question: "What is photosynthesis?",
        answer: "The process by which green plants and some other organisms use sunlight to synthesize foods with the help of chlorophyll.",
        deck: "Biology"
      },
      {
        subject: "history",
        question: "Who was the first President of the United States?",
        answer: "George Washington",
        deck: "American History"
      },
      {
        subject: "trivia",
        question: "What is the capital of Australia?",
        answer: "Canberra",
        deck: "Geography"
      },
      {
        subject: "math",
        question: "What is the formula for the area of a circle?",
        answer: "A = πr^2",
        deck: "Geometry"
      },
      {
        subject: "science",
        question: "What is Newton's first law of motion?",
        answer: "An object at rest will stay at rest, and an object in motion will stay in motion unless acted upon by an external force.",
        deck: "Physics"
      },
      {
        subject: "history",
        question: "When did World War II end?",
        answer: "September 2, 1945",
        deck: "World History"
      },
      {
        subject: "trivia",
        question: "What is the largest mammal on Earth?",
        answer: "Blue whale",
        deck: "Animals"
      },
      {
        subject: "math",
        question: "What is the quadratic formula?",
        answer: "x = (-b ± √(b^2 - 4ac)) / 2a",
        deck: "Algebra"
      },
      {
        subject: "science",
        question: "What is the chemical symbol for gold?",
        answer: "Au",
        deck: "Chemistry"
      }
    ],
    decks: [
      {
        subject: "math",
        question: "What is the Pythagorean theorem?",
        answer: "In a right triangle, the square of the length of the hypotenuse is equal to the sum of the squares of the lengths of the other two sides.",
        deck: "Mathematics",
        username: "userid"
      },
      {
        subject: "trivia",
        question: "What is the largest mammal on Earth?",
        answer: "Blue whale",
        deck: "Animals",
        username: "userid"
      },
      {
        subject: "math",
        question: "What is the quadratic formula?",
        answer: "x = (-b ± √(b^2 - 4ac)) / 2a",
        deck: "Algebra",
        username: "userid"
      },
      {
        subject: "math",
        question: "What is the Pythagorean theorem?",
        answer: "In a right triangle, the square of the length of the hypotenuse is equal to the sum of the squares of the lengths of the other two sides.",
        deck: "Mathematics",
        username: "userid"
      },
      {
        subject: "trivia",
        question: "What is the largest mammal on Earth?",
        answer: "Blue whale",
        deck: "Animals",
        username: "userid"
      },
      {
        subject: "math",
        question: "What is the quadratic formula?",
        answer: "x = (-b ± √(b^2 - 4ac)) / 2a",
        deck: "Algebra",
        username: "userid"
      },
    ],
  },
  mutations: {
    SET_AUTH_TOKEN(state, token) {
      state.token = token;
      localStorage.setItem('token', token);
      axios.defaults.headers.common['Authorization'] = `Bearer ${token}`
    },
    SET_USER(state, user) {
      state.user = user;
      localStorage.setItem('user', JSON.stringify(user));
    },
    LOGOUT(state) {
      localStorage.removeItem('token');
      localStorage.removeItem('user');
      state.token = '';
      state.user = {};
      axios.defaults.headers.common = {};
    },

    markCorrect(state, flashcardId) {
      const flashcard = state.flashcards.find((card) => card.id === flashcardId);
      if (flashcard) {
        flashcard.correct = !flashcard.correct;
      }
    },
  },

  getters: {
    getFlashcards(state) {
      return state.flashcards;
    },
  },
})
