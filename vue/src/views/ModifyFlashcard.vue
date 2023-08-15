<template >
  <body>
    <div id="modify-flashcard">
      <form @submit.prevent="updateCard">
        <h1>Edit Flashcard</h1>
        <div class="form-input-group">
          <label for="card-subject">Card Subject</label>
          <select v-model="card.subject" class="dropdown">
            <option disabled value="">Please select one</option>
            <option>Math</option>
            <option>Science</option>
            <option>Geography</option>
            <option>History</option>
            <option>Politics</option>
            <option>Trivia</option>
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

        <button type="submit">Update Card!</button>
      </form>
    </div>
  </body>
</template>

<script>
import FlashcardService from "../services/FlashcardService.js";
export default {
  name: "modifyflashcard",
  components: {},
  data() {
    return {
      card: {
        id: null,
        subject: this.$route.params.subject,
        question: this.$route.params.question,
        answer: this.$route.params.answer,
        deck_id: null,
      },
    };
  },
  methods: {
    fetchFlashcardInfo(id) {
      FlashcardService.get(id).then((response) => {
        if (response.status === 200) {
          this.card = response.data; // Populate the card data
        }
      });
    },
    updateCard() {
      FlashcardService.update(this.$route.params.flashcardId, this.card).then(
        (response) => {
          if (response.status === 200) {
            this.$store.commit("UPDATE_FLASHCARD", this.card);
            this.card.id = this.card;
            this.card.subject = "";
            this.card.question = "";
            this.card.answer = "";
            this.card.deck_id = null;
            this.$router.push("/");
          }
        }
      );
    },
  },
  mounted() {
    // const flashcardId = this.$route.params.id; // Assuming you're using Vue Router
    // this.fetchFlashcardInfo(flashcardId);
    // this.card.question = this.$route.params.question;
    // this.card.answer = this.$route.params.answer;
    this.card.id = this.$route.params.flashcardId;
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

#modify-flashcard {
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