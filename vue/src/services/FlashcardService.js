import http from 'axios';


export default {

    list() {
        return http.get('/flashcards');
    },

    getFiltered(input) {
        return http.get(`/flashcards/${input}`);
    },

    getDeckCards(id) {
        return http.get(`/deck/${id}`)
    },
    addFromDeck(deckId, flashcard) {
        return http.post(`/deck/${deckId}`, flashcard)
    },
    get(id) {
        return http.get(`/flashcards/${id}`);
    },
    create(flashcard) {
        return http.post(`/flashcards`, flashcard);
    },

    update(id, flashcard) {
        return http.put(`/flashcards/${id}`, flashcard);
    },
    delete(id) {
        return http.delete(`/flashcards/${id}`);
    }

}