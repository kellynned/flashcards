<template>
  <div class="deck">
    <div id="tester">
      <router-link
        class="deck"
        :to="{ name: 'ViewDeckFlashcards', params: { deckId: deck.deck_id, deckname: deck.deckname } }"
      >
        <h1 class="subjectName">
          {{ deck.deckname }}
        </h1>
      </router-link>
      <router-link
        class="study-button"
        :to="{ name: 'StudySession', params: { deckId: deck.deck_id } }"
      >
        Study Deck!
      </router-link>
    </div>
  </div>
</template>



<script>
export default {
  name: "Deck",
  components: {},
  props: {
    deck: Object,
  },
  data() {
    return {};
  },
  methods: {},
};
</script>

<style scoped>
#tester {
  display: flex;
  position: relative;
  top: 35px;
}
h3 {
  display: flex;
  justify-content: space-between;
  align-self: center;
  color: #89b0ae;
  font-size: 1em;
  padding-left: 12px;

  margin-bottom: 0%;
}
.subjectName {
  display: flex;
  justify-content: center;
  align-items: baseline;
  color: #89b0ae;
  font-size: 1.5em;
  padding-right: 7px;
  margin: auto;
  position: relative;
  left: 30px;
}
.deck {
  border-radius: 25px;
  background-color: #faf9f9;
  width: 90%;
  height: 15%;
  text-decoration: none;
  position: relative;
  left: 25px;
  right: 25px;
}

.edit-button {
  display: inline-block;
  border-radius: 15px;
  background-color: transparent;
  border: none;
  color: #555b6e;
  text-align: center;
  font-size: 15px;
  padding: 7px;
  width: 40px;
  transition: all 0.5s;
  cursor: pointer;
  margin: 5px;
}
.study-button {
  display: inline-block;
  border-radius: 15px;
  background-color: transparent;
  color: #555b6e;
  text-align: center;
  font-size: 15px;
  padding: 7px;
  width: 80px;
  transition: all 0.5s;
  cursor: pointer;
  margin: 5px;
  outline: solid #555b6e;
  text-decoration: none;
  position: relative;
  right: 10px;
  bottom: 5px;
}
</style>
