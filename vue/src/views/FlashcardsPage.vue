<template>
  <div class="flashcards-page">
    <div class="header">
      <h1>Flashcards <i class="fa-brands fa-pagelines"></i></h1>
    </div>

    <div class="flashcardsContainer">
      <h2>Flashcards</h2>
        <button class="button" @click="deleteSelectedFlashcards">
        Add To Deck <i class="fa-regular fa-square-plus"></i>
      </button>
      <input type="text" class="search" />

      <button class="button" @click="deleteSelectedFlashcards">
        Delete <i class="fa-solid fa-trash-can"></i>
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
import Flashcard from "@/components/Flashcard.vue";
import FlashcardService from "@/services/FlashcardService";

export default {
  data() {
    return {
      selectedFlashcardIds: [],
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
    // this.$store.dispatch("fetchDecks");
    // this.fetchDecks();
  },

  services: {
    FlashcardService,
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
    toggleSelectedFlashcard(flashcardId) {
      if (this.selectedFlashcardIds.includes(flashcardId)) {
        this.selectedFlashcardIds = this.selectedFlashcardIds.filter(
          (id) => id !== flashcardId
        );
      } else {
        this.selectedFlashcardIds.push(flashcardId);
      }
    },

    async deleteSelectedFlashcards() {
      console.log("WORKING", this.selectedFlashcardIds)
      if (this.selectedFlashcardIds.length > 0) {
        try {
          // Call your API endpoint to delete selected flashcards
          await FlashcardService.delete(this.selectedFlashcardIds);

          // Clear the selectedFlashcardIds array after successful deletion
          this.selectedFlashcardIds = [];

          // Fetch updated flashcards from the server or update Vuex store
          this.fetchFlashcards();
        } catch (error) {
          console.error("Error deleting flashcards:", error);
        }
      }
    },
  },
};
</script>

<style scoped>
.flashcards-page {
  background-color: #555b6e;
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
  border-radius: 25px;
  margin-right: 25%;
  margin-left: 25%;
  background-color: #89b0ae;
  text-align: center;
  overflow: auto;
  align-content: center;
  height: 750px;
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
</style>