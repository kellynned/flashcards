<template>
  <div class="home">
    <div class="header"><h1>Flashcards</h1></div>
    <div class="container">
      <div class="flashcardsContainer">
        <h2>Flashcards</h2>
        <input type="text" class="search" />
        <div>
          <Flashcard
            class="flashcard"
            v-for="flashcard in flashcards"
            :key="flashcard.id"
            :flashcard="flashcard"
          />
        </div>

        <button class="button" style="vertical-align: middle">
          <span>Add Card </span>
        </button>
      </div>
      <div class="decksContainer">
        <h2>Decks</h2>
        <input type="text" class="search" />
        <div class="deck">
          <h3>Example Deck</h3>
          <p>This is a deck preview.</p>
        </div>
        <div class="deck">
          <h3>Example Deck</h3>
          <p>This is a deck preview.</p>
        </div>
        <div class="deck">
          <h3>Example Deck</h3>
          <p>This is a deck preview.</p>
        </div>
        <div class="deck">
          <h3>Example Deck</h3>
          <p>This is a deck preview.</p>
        </div>
        <div class="deck">
          <h3>Example Deck</h3>
          <p>
            This is a deck preview. Thiskjlsdjaljfiwe ajhffh dfsl. asdlfjief
            afjskd lajsdf alsdjf klasjfld jfl sdf sfajls
          </p>
        </div>
        <div class="deck">
          <h3>Example Deck</h3>
          <p>This is a deck preview.</p>
        </div>
        <button class="button" style="vertical-align: middle">
          <span>Add Deck </span>
        </button>
      </div>
    </div>
  </div>
</template>

<script>
import Flashcard from "@/components/Flashcard.vue";
export default {
  name: "home",
  components: {
    Flashcard,
  },
  computed: {
    flashcards() {
      // Replace this with fetching the flashcards from the store
      return this.$store.state.flashcards;
    },
  },
};
</script>

<style scoped>
.home {
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

.container {
  display: flex;
  gap: 100px;
  margin: 20px;
  justify-content: center;
  align-self: center;
}

.decksContainer {
  color: #89b0ae;
  border-radius: 25px;
  width: 550px;
  background-color: #89b0ae;
  height: 750px;
  text-align: center;
  overflow: auto;
}
.flashcardsContainer {
  color: #89b0ae;
  border-radius: 25px;
  width: 550px;
  background-color: #89b0ae;
  height: 750px;
  text-align: center;
  overflow: auto;
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
  height: 15%;
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
  color: #ffffff;
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
</style>