<template >
  <body>
    <div id="login">
      <form>
        <h1>Edit Deck Name</h1>
        <div class="form-input-group">
          <label for="deckname">Deckname</label>
          <input
            type="text"
            id="deckname"
            v-model="deck.deckname"
            required
            autofocus
          />
        </div>
        <button @click.prevent="renameDeck" type="submit">Rename Deck!</button>
      </form>
    </div>
  </body>
</template>

<script>
import DeckService from "../services/DeckService.js";

export default {
  name: "createdeck",
  components: {},
  data() {
    return {
      deck: {
        deckname: "",
        deckId: this.$route.params.deckId
      },
    };
  },
  methods: {
    renameDeck() {
        DeckService.renameDeck(this.$route.params.deckId, this.deck);
        console.log(this.$route.params.deckId)
    }
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