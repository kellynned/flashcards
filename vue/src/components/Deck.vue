<template>
  <div class="deck">
    <h3>
      {{ deck.user_id }}
      <router-link v-bind:to="{ name: 'DecksPage' }" class="edit-button"
        ><i class="fa-solid fa-pen-to-square"></i
      ></router-link>
    </h3>
    <h1 class="subject">
      {{ deck.deckName }}

      <router-link class="study-button" v-bind:to="{ name: 'DecksPage' }"
        >Study Deck!</router-link
      >
    </h1>
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
h3 {
  display: flex;
  justify-content: space-between;
  align-self: center;
  color: #89b0ae;
  font-size: 1em;
  padding-left: 12px;

  margin-bottom: 0%;
}
.subject {
  display: flex;
  justify-content: space-between;
  align-items: baseline;
  color: #89b0ae;
  font-size: 1.5em;
  padding-right: 7px;
  margin-left: 45%;
  margin-top: 1%;
}
.deck {
  border-radius: 25px;
  background-color: #faf9f9;
  width: 90%;
  height: 15%;
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
  width: 60px;
  transition: all 0.5s;
  cursor: pointer;
  margin: 5px;
  outline: solid #555b6e;
  text-decoration: none;
}
</style>
