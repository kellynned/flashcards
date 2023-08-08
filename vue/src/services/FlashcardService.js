import axios from 'axios';
const http = axios.create({
    baseURL: "http://localhost:9000"
});
export default {

    list() {
        return http.get('/flashcards');
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