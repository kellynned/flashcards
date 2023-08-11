<template>
  <div class="deck">
    <h3 style = "color:#faf9f9">
      .
      <router-link v-bind:to="{ name: 'DecksPage' }" class="edit-button"
        ><i class="fa-solid fa-pen-to-square"></i
      ></router-link>
    </h3>
    <div id="tester">
      <h1 class="subjectName">
        {{ deck.deckName }}
      </h1>
      <router-link class="study-button" v-bind:to="{ name: 'StudySession' }"
        >Study Deck!</router-link
      >
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
  left: 50px;
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
  width: 80px;
  transition: all 0.5s;
  cursor: pointer;
  margin: 5px;
  outline: solid #555b6e;
  text-decoration: none;
  position: relative;
  right: 10px;
  top: 5px;
}
</style>
