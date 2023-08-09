import axios from 'axios';

const http = axios.create({
  baseURL: "http://localhost:9000/"
});

export default {

  getDecks() {

    console.log("Starting to Load...");
    return http.get('/decks');
  }
}