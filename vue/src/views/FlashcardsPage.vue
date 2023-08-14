<template>
  <div class="flashcards-page">
    <div class="header">
      <h1>Flashcards <i class="fa-brands fa-pagelines"></i></h1>
    </div>

    <div class="flashcardsContainer">
      <h2>Flashcards</h2>
      <label for="deck-names">Choose a deck:</label>
      <select name="deck-names" id="deck-names" v-model="selectedDeck">
        <option v-for="deck in decks" :key="deck.deck_id" :deck="deck">
          {{ deck.deckName }}
        </option>
      </select>
      <input type="text" class="search" />

      <button class="button">
        Save <i class="fa-solid fa-floppy-disk"></i>
      </button>

      <div>
        <Flashcard
          class="flashcard"
          v-for="flashcard in flashcards"
          :key="flashcard.id"
          :flashcard="flashcard"
        />
      </div>

      <router-link to="/createcard" custom v-slot="{ navigate }">
        <button
          class="button"
          @click="navigate"
          role="link"
          style="vertical-align: middle"
        >
          <span>Add Card </span>
        </button>
      </router-link>
    </div>
  </div>
</template>

<script>
import DeckService from "@/services/DeckService";
import Flashcard from "@/components/Flashcard.vue";
import FlashcardService from "@/services/FlashcardService";

export default {
  data() {
    return {
      decks: [],
      selectedDeck: null,
    };
  },

  name: "FlashcardsPage",
  components: {
    Flashcard,
  },
  computed: {
    flashcards() {
      return this.$store.state.flashcards;
    },
  },
  mounted() {
    FlashcardService.list().then((response) =>
      this.$store.commit("SET_FLASHCARDS", response.data)
    );
    // DeckService.list().then((response) =>
    //   this.deck = response.data,
    //   this.selectedDeck = this.decks[0].deck_id
    // );
  },

  services: {
    FlashcardService,
    DeckService,
  },
  methods: {
    async fetchFlashcards() {
      try {
        // const response = await DeckService.list();
        // const decks = response.data;
        // this.$store.commit("SET_DECKS", decks);
        // this.deck = decks;
        await this.$store.dispatch("fetchFlashcards");
        // Update your Vuex store or component data with fetched decks
      } catch (error) {
        console.error("Error fetching flashcards:", error);
      }
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
  margin-left: 25%;
  background-color: #89b0ae;
  text-align: center;
  overflow: auto;
  align-content: center;
  height: 750px;
  border: 4px solid #64949283;
}

.flashcard {
  border-radius: 25px;
  background-color: #faf9f9;
  width: 90%;
  height: 112px;
  left: 43px;
  position: relative;
  align-content: center;
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

.search {
  width: 40%;
  height: 20px;
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

#deck-names {
  position: relative;
  right: 100px;
  height: 30px;
  width: 100px;
}
</style>