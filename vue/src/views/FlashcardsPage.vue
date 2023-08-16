<template>
  <div class="flashcards-page">
    <div class="header">
      <h1>Flashcards <i class="fa-brands fa-pagelines"></i></h1>
    </div>
    <div class="flashcardsContainer">
      <h2>Flashcards</h2>
      <label for="deck-names">Choose a deck:</label>
      <select name="deck-names" id="deck-names" v-model="selectedDeckId">
        <option v-for="deck in decks" :key="deck.deck_id" :value="deck.deck_id">
          {{ deck.deckname }}
        </option>
      </select>
      <input
        type="text"
        id="search"
        v-model="searchInput"
        required
        autofocus
        @keypress.enter="getFilteredFlashcards"
      />
      <button class="button">
        Save <i class="fa-solid fa-floppy-disk"></i>
      </button>
      <ul v-for="flashcard in $store.state.filteredList" :key="flashcard.id">
        <li>
          <Flashcard class="flashcard" :flashcard="flashcard" />
           <input
      class ="checkbox"
      type="checkbox"
      v-bind:id="flashcard.flashcardId"
      v-bind:value="flashcard.flashcardId"
      v-model="selectedId"
    />
        </li>
      </ul>
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
      searchInput: "",
      selectedDeckId: 0,
      selectedId: [],
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
    decks() {
      return this.$store.state.decks;
    },
  },
  mounted() {
    this.getFilteredFlashcards();
  },
  services: {
    FlashcardService,
    DeckService,
  },
  methods: {
    async fetchFlashcards() {
      try {
        await this.$store.dispatch("fetchFlashcards");
      } catch (error) {
        console.error("Error fetching flashcards:", error);
      }
    },
    getFilteredFlashcards() {
      FlashcardService.getFiltered(this.searchInput).then(
        (response) =>
          this.$store.commit("SET_FILTERED_FLASHCARDS", response.data),
        console.log("Testing")
      );
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
#search {
  width: 40%;
  height: 20px;
}

.checkbox {
position: relative;
right: 360px;
bottom: 45px;
}
</style>