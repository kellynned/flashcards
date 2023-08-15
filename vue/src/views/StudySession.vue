<template>
  <div class="studysession">
    <div class="header">
      <h1>Flashcards <i class="fa-brands fa-pagelines"></i></h1>
    </div>

    <div class="flashcardsContainer" v-if="isComplete == false">
      <h2>Study Time!</h2>
      <p class="counter">Card {{ currentIndex }} / {{ flashcards.length }}</p>
      <div>
        <Flashcard
          class="flashcard"
          :flashcard="flashcards[currentIndex]"
          @mark-correct="markCorrect"
        />
      </div>

      <button
        class="incorrect"
        @click="nextFlashcard"
        role="link"
        style="vertical-align: middle"
      >
        <span class="wrong-span">Incorrect </span>
      </button>

      <button class="correct" @click="markCorrect" role="link">
        <span class="rightanswer">Correct </span>
      </button>

      <button class="button" role="link" @click="isCompleted">
        <span>Complete Session </span>
      </button>
    </div>
    <div class="resultsContainer" v-else>
      <div class="results">
        <div v-if="this.correctCount > 0">
          <h1>Nice job!</h1>
        </div>
        <div v-else>
          <h1>Better luck next time!</h1>
        </div>
        <p>
          You answered {{ this.correctCount }} questions correctly out of
          {{ this.currentIndex }}.
        </p>
        <button class="sameDeck" onClick="window.location.reload();">
          <span>Study Same Deck</span>
        </button>
        <router-link v-bind:to="{ name: 'DecksPage' }"
          ><button class="diffDeck">
            <span>Study Another Deck</span>
          </button>
        </router-link>
      </div>
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
      selectedFlashcardIds: [],
      currentIndex: 0,
      correctCount: 0,
      isComplete: false,
    };
  },

  name: "StudySession",
  components: {
    Flashcard,
  },
  computed: {
    flashcards() {
      return this.$store.state.flashcards;
    },
    currentFlashcardNumber() {
      return this.currentIndex + 1;
    },
  },
  mounted() {
    DeckService.get(this.$route.params.deckId).then((response) =>
      this.$store.commit("SET_FLASHCARDS", response.data)
    );
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
    nextFlashcard() {
      if (this.currentIndex <= this.flashcards.length - 1) {
        this.currentIndex++;
      } else {
        //  this.currentIndex++;
      }
    },
    isCompleted() {
      if (this.correctCount > this.currentIndex) {
        this.currentIndex++;
      }
      if (this.correctCount == 0) {
        this.currentIndex == this.currentIndex;
      }
      this.isComplete = true;
    },
    sendData() {
      this.$store.commit(
        "SET_DATA_STUDY",
        this.currentIndex,
        this.correctCount
      );
    },
    markCorrect() {
      if (
        this.correctCount < this.flashcards.length &&
        this.currentIndex <= this.flashcards.length - 1
      ) {
        this.correctCount++;
        this.currentIndex++;
      }
    },
  },
};
</script>

<style scoped>
.studysession {
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
  margin-top: 50px;
  border-radius: 25px;
  margin-right: 25%;
  margin-left: 25%;
  background-color: #89b0ae;
  text-align: center;
  overflow: auto;
  align-content: center;
  height: 500px;
  border: 4px solid #64949283;
}

.resultsContainer {
  margin-top: 50px;
  color: #faf9f9;
  border-radius: 25px;
  margin-right: 25%;
  margin-left: 25%;
  background-color: #89b0ae;
  text-align: center;
  overflow: auto;
  align-content: center;
  height: 500px;
  justify-content: center;
  position: relative;
  border: 4px solid #64949283;
}

.flashcard {
  display: flex;
  border-radius: 25px;
  background-color: #faf9f9;
  width: 90%;
  height: 200px;
  left: 43px;
  position: relative;
  align-content: center;
}

h2 {
  font-size: 1.75em;
  margin: 10px;
  color: #faf9f9;
}

.counter {
  font-size: 1em;
  margin: 10px;
  color: #faf9f9;
  display: flex;
  justify-content: flex-end;
  padding-right: 20px;
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
  width: 300px;
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
  content: "\21E5";
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
.correct {
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

.correct span {
  cursor: pointer;
  display: inline-block;
  position: relative;
  transition: 0.5s;
}

.correct span:after {
  content: "\2713";
  position: absolute;
  opacity: 0;
  top: 0;
  right: -30px;
  transition: 0.5s;
  transform: translateY(-20%);
}

.correct:hover span {
  padding-right: 25px;
}

.correct:hover span:after {
  opacity: 1;
  right: 0;
}
.incorrect {
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

.incorrect span {
  cursor: pointer;
  display: inline-block;
  position: relative;
  transition: 0.5s;
}

.incorrect span:after {
  content: "\0058";
  position: absolute;
  opacity: 0;
  top: 0;
  right: -30px;
  transition: 0.5s;
}

.incorrect:hover span {
  padding-right: 25px;
}

.incorrect:hover span:after {
  opacity: 1;
  right: 0;
}

.sameDeck {
  display: inline-block;
  border-radius: 15px;
  background-color: transparent;
  border: none;
  color: #faf9f9;
  text-align: center;
  font-size: 20px;
  padding: 20px;
  width: 250px;
  transition: all 0.5s;
  cursor: pointer;
  margin: 5px;
}

.sameDeck span {
  cursor: pointer;
  display: inline-block;
  position: relative;
  transition: 0.5s;
}

.sameDeck span:after {
  content: "\27F3";
  position: absolute;
  opacity: 0;
  top: 0;
  right: -30px;
  transition: 0.5s;
  transform: translateY(-6%);
}

.sameDeck:hover span {
  padding-right: 25px;
}

.sameDeck:hover span:after {
  opacity: 1;
  right: 0;
}

.diffDeck {
  display: inline-block;
  border-radius: 15px;
  background-color: transparent;
  border: none;
  color: #faf9f9;
  text-align: center;
  font-size: 20px;
  padding: 20px;
  width: 250px;
  transition: all 0.5s;
  cursor: pointer;
  margin: 5px;
}

.diffDeck span {
  cursor: pointer;
  display: inline-block;
  position: relative;
  transition: 0.5s;
}

.diffDeck span:after {
  content: "\21E5";
  position: absolute;
  opacity: 0;
  top: 0;
  right: -30px;
  transition: 0.5s;
  transform: translateY(-6%);
}

.diffDeck:hover span {
  padding-right: 25px;
}

.diffDeck:hover span:after {
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

.results {
  position: relative;
  top: 100px;
  align-content: center;
  justify-content: center;
  text-align: center;
}
</style>