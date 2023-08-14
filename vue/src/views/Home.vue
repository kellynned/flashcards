<template>
  <div class="home">
    <div class="header">
      <h1>Flashcards <i class="fa-brands fa-pagelines"></i></h1>
    </div>
    <div class="container">
      <div class="flashcardsContainer">
        <h2>Flashcards</h2>
        <div class="form-input-group">
          <label for="search">Search</label>
          <input
            type="text"
            id="search"
            v-model="searchInput"
            required
            autofocus
            @keypress.enter="getFilteredFlashcards"
          />
        </div>
        <div>
          <Flashcard
            class="flashcard"
            v-for="flashcard in $store.state.filteredList"
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
      <div class="decksContainer">
        <h2>Decks</h2>

        <div>
          <Deck
            class="deck"
            v-for="deck in decks"
            :key="deck.id"
            :deck="deck"
          />
        </div>

        <router-link to="/createdeck" custom v-slot="{ navigate }">
          <button
            class="button"
            @click="navigate"
            role="link"
            style="vertical-align: middle"
          >
            <span>Add Deck</span>
          </button>
        </router-link>
      </div>
    </div>
  </div>
</template>

<script>
import Flashcard from "@/components/Flashcard.vue";
import Deck from "@/components/Deck.vue";
import FlashcardService from "@/services/FlashcardService";
import DeckService from "@/services/DeckService";

export default {
  name: "home",
  components: {
    Flashcard,
    Deck,
  },
  data() {
    return {
      searchInput: "",
      fliteredList: [],
    };
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
    DeckService.list().then((response) =>
      this.$store.commit("SET_DECKS", response.data)
    );
    FlashcardService.list().then((response) =>
      this.$store.commit("SET_FLASHCARDS", response.data)
    );
  },
  methods: {
    getFilteredFlashcards() {
      FlashcardService.getFiltered(this.searchInput).then((response) =>
        this.$store.commit("SET_FILTERED_FLASHCARDS", response.data)
      );
    },
  },
};
</script>

<style scoped>
.home {
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
.form-input-group {
  margin-bottom: 1rem;
  display: flex;
  flex-direction: column;
  align-items: center;
}

label {
  margin-bottom: 0.25rem;
  text-align: left;
  color: #faf9f9;
}

input {
  width: 45%;
  padding: 0.5rem;
}
.container {
  display: flex;
  gap: 100px;
  margin: 20px;
  justify-content: center;
  align-self: center;
}

.decksContainer {
  color: #89b0ae;
  border-radius: 10px;
  width: 550px;
  background-color: #89b0ae;
  height: 750px;
  text-align: center;
  overflow: auto;
}
.flashcardsContainer {
  color: #89b0ae;
  border-radius: 10px;
  width: 550px;
  background-color: #89b0ae;
  height: 750px;
  text-align: center;
  overflow: auto;
  border: 4px solid #64949283;
}

.flashcard {
  border-radius: 25px;
  background-color: #faf9f9;
  width: 90%;
  height: 112px;
  position: relative;
  left: 25px;
  margin-top: 15px;
  margin-bottom: 15px;
}

.deck {
  border-radius: 25px;
  background-color: #faf9f9;
  width: 90%;
  height: 112px;
  position: relative;
  left: 25px;
  margin-top: 15px;
  margin-bottom: 15px;
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
</style>