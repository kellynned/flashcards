<template>
  <div class="flashcards-page">
    <div class="header">
      <h1>Flashcards <i class="fa-brands fa-pagelines"></i></h1>
    </div>

    <div class="flashcardsContainer">
      <h2>Deck</h2>

      <button class="button" @click="removeFromDeck">
        Remove <i class="fa-solid fa-trash-can"></i>
      </button>

      <ul v-for="flashcard in flashcards" :key="flashcard.id">
        <li>
          <Flashcard class="flashcard" :flashcard="flashcard" />
          <input
            class="checkbox"
            type="checkbox"
            v-bind:id="flashcard.flashcardId"
            v-bind:value="flashcard.flashcardId"
            v-model="selectedId"
          />
        </li>
      </ul>

      <router-link
        :to="{ name: 'addcard', params: { deckId: this.$route.params.deckId } }"
      >
        <button class="button" role="link" style="vertical-align: middle">
          <span>Add Card </span>
        </button>
      </router-link>
    </div>
  </div>
</template>

<script>
import Flashcard from "@/components/Flashcard.vue";
import FlashcardService from "@/services/FlashcardService";
import DeckService from "../services/DeckService";
export default {
  data() {
    return {
      searchInput: "",
      selectedDeckId: this.$route.params.deckId,
      selectedId: [],
    };
  },

  name: "ViewDeckFlashcards",
  components: {
    Flashcard,
  },
  computed: {
    flashcards() {
      return this.$store.state.flashcards;
    },
  },
  mounted() {
    this.getDeckFlashcards();
  },
  services: {
    FlashcardService,
    DeckService,
  },
  methods: {
    getDeckFlashcards() {
      DeckService.get(this.$route.params.deckId).then((response) =>
        this.$store.commit("SET_FLASHCARDS", response.data),
      );
    },
    removeFromDeck() {
      DeckService.removeCards(this.selectedDeckId, this.selectedId);
      console.log(this.selectedDeckId);
    },
  },
};
</script>

<style scoped>
.flashcards-page {
  background-image: linear-gradient(to bottom, #555b6e, #faf9f9);
  height: 95.3vh;
  color: #89b0ae;
  font-size: 1.5em;
}

.header {
  display: flex;
  justify-content: center;
  align-self: center;
  color: #faf9f9;
}

.flashcardsContainer {
  color: #89b0ae;
  border-radius: 10px;
  margin-right: 25%;
  margin-left: 29%;
  background-color: #89b0ae;
  text-align: center;
  overflow: auto;
  align-content: center;
  height: 750px;
  border: 4px solid #64949283;
  width: 800px;
}

.flashcard {
  border-radius: 25px;
  background-color: #faf9f9;
  width: 90%;
  height: 112px;
  left: 43px;
  position: relative;
  align-content: center;
  margin-bottom: -30px;
}

h2 {
  font-size: 1.75em;
  margin: 10px;
  color: #faf9f9;
}

.overflowScroll {
  height: 250px;
}

::-webkit-scrollbar {
  width: 10px;
}

::-webkit-scrollbar-track {
  box-shadow: inset 0 0 5px grey;
  border-radius: 10px;
}

::-webkit-scrollbar-thumb {
  background: #b3b3b3;
  border-radius: 10px;
}

.button {
  display: inline-block;
  border-radius: 15px;
  background-color: transparent;
  border: none;
  color: #faf9f9;
  text-align: center;
  font-size: 20px;
  padding: 20px;
  width: 200px;
  transition: all 0.5s;
  cursor: pointer;
  margin: 5px;
}

.button span {
  cursor: pointer;
  display: inline-block;
  position: relative;
  transition: 0.5s;
}

.button span:after {
  content: "\002B";
  position: absolute;
  opacity: 0;
  top: 0;
  right: -30px;
  transition: 0.5s;
}

.button:hover span {
  padding-right: 25px;
}

.button:hover span:after {
  opacity: 1;
  right: 0;
}

.edit-button {
  display: inline-block;
  border-radius: 15px;
  background-color: #fde8da;
  border: none;
  color: #555b6e;
  text-align: center;
  font-size: 15px;
  padding: 20px;
  width: 70px;
  transition: all 0.5s;
  cursor: pointer;
  margin: 5px;
}

.checkbox {
  position: relative;
  right: 360px;
  bottom: 45px;
}
</style>