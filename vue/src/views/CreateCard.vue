<template >
  <body>
    <div id="login">
      <form @submit.prevent="create">
        <h1>Create a Flashcard</h1>
        <div class="form-input-group">
          <label for="card-subject">Card Subject</label>
          <select v-model="card.subject" class="dropdown">
            <option disabled value="">Please select one</option>
            <option>Math</option>
            <option>Science</option>
            <option>Geography</option>
            <option>History</option>
            <option>Politics</option>
          </select>
        </div>
        <div class="form-input-group">
          <label for="question">Question</label>
          <input
            type="text"
            id="question"
            v-model="card.question"
            required
            autofocus
          />
        </div>
        <div class="form-input-group">
          <label for="answer">Answer</label>
          <input
            type="text"
            id="answer"
            v-model="card.answer"
            required
            autofocus
          />
        </div>
        <div class="form-input-group">
          <!-- <label for="deck_id">Deck</label>
          <input
            type="number"
            id="deck"
            v-model.number="card.deck_id"
            autofocus
          /> -->
          <label for="deck_id">Add this card to a deck?</label>

          <select v-model="card.deck_id" class="dropdown">
            <option disabled value="">None</option>
            <option>1</option>
            <option>2</option>
            <option>3</option>
            <option>4</option>
            <option>5</option>
          </select>
        </div>
        <button type="submit">Add Card!</button>
      </form>
    </div>
  </body>
</template>

<script>
import FlashcardService from "../services/FlashcardService.js";

export default {
  name: "createcard",
  components: {},
  data() {
    return {
      card: {
        subject: "",
        question: "",
        answer: "",
        deck_id: null,
      },
    };
  },
  methods: {
    create() {
      FlashcardService.create(this.card).then((response) => {
        if (response.status == 201) {
          this.$store.commit("SET_FLASHCARDS", response.data.card);
          this.card.subject = "";
          this.card.question = "";
          this.card.answer = "";
          this.card.deck_id = null;
        }
      });
    },
  },
};
</script>

<style scoped>
.form-input-group {
  margin-bottom: 1rem;
  display: flex;
  flex-direction: column;
}

label {
  margin-bottom: 0.25rem;
  text-align: left;
}

input {
  width: 100%;
  padding: 0.5rem;
}

#login {
  display: flex;
  justify-content: center;
  align-self: center;
  background-color: #555b6e;
  height: 95vh;
  color: #89b0ae;
  font-size: 1.5em;
}

h1 {
  font-size: 5rem;
  color: #faf9f9;
}

h2 {
  font-size: 3.5rem;
  color: #faf9f9;
  text-align: center;
}

button {
  display: flex;
  border-radius: 4px;
  background-color: #bee3db;
  width: 75%;
  height: 40px;
  align-items: center;
  justify-content: center;
  margin-top: 30px;
  font-weight: bold;
  position: relative;
  left: 65px;
}

button:hover {
  box-shadow: 0 12px 16px 0 rgba(0, 0, 0, 0.24),
    0 17px 50px 0 rgba(0, 0, 0, 0.19);
  border-radius: 4px;
  background-color: #89b0ae;
}
.login-link {
  display: flex;
  align-items: center;
  justify-content: center;
  color: #faf9f9;
}
</style>