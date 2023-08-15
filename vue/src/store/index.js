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

    flashcards: [],
    filteredList: [],
    decks: [],
    selectedFlashcardIds: [],
    currentIndex: 0,
    correctCount: 0,

  },

  mutations: {
    SET_AUTH_TOKEN(state, token) {
      state.token = token;
      localStorage.setItem('token', token);
      axios.defaults.headers.common['Authorization'] = `Bearer ${token}`
    },
    SET_DATA_STUDY(state, currentIndex, correctCount) {
      state.currentIndex = currentIndex;
      state.correctCount = correctCount;
    },
    SET_USER(state, user) {
      state.user = user;
      localStorage.setItem('user', JSON.stringify(user));
    },
    SET_FILTERED_FLASHCARDS(state, flashcards) {
      state.filteredList = flashcards;
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
    SET_DECKS(state, decks) {
      state.decks = decks;
    },
    SET_DECK_FLASHCARDS(state, flashcards) {
      state.flashcards = flashcards;
    },

    SET_FLASHCARDS(state, flashcards) {
      state.flashcards = flashcards;
    },
  },
  // actions: {
  //   async fetchDecks({ commit }) {
  //     try {
  //       const response = await axios.get('/decks');
  //       const decks = response.data;
  //       commit('SET_DECKS', decks);
  //     } catch (error) {
  //       console.error('Error fetching decks:', error);
  //     }
  //   },

  // },
  getters: {
    getFlashcards(state) {
      return state.flashcards;
    },
  },
})
