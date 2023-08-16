import http from 'axios';

export default {

    list() {
        return http.get('/decks');
    },

    get(id) {
        return http.get(`/decks/${id}`);
    },
    create(deck) {
        return http.post(`/decks`, deck);
    },
    update(id, deck) {
        return http.put(`/decks/${id}`, deck);
    },
    delete(id) {
        return http.delete(`/decks/${id}`);
    },
    addCards(id, flashcardIds) {
        return http.post(`/decks/${id}/addFlashcards`, flashcardIds);
    },
    removeCards(id, flashcardIds) {
        return http.delete(`/decks/${id}/removeFlashcards`, flashcardIds);
    }
}