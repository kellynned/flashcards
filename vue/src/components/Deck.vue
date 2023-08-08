<template>
  <div class="deck">
    <h3>
      {{ deck.username }} | {{ deck.deck }}
      <router-link v-bind:to="{ name: 'DecksPage' }" class="edit-button"
        ><i class="fa-solid fa-pen-to-square"></i
      ></router-link>
    </h3>
    <h1 class="subject">{{ deck.subject }}</h1>
  </div>
</template>

<script>
export default {
  name: "Deck",
  components: {},
  props: {
    deck: Object,
  },
  data() {},
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
}
.subject {
  display: flex;
  justify-content: center;
  align-items: baseline;
  color: #89b0ae;
  font-size: 1.5em;
}
.deck {
  border-radius: 25px;
  background-color: #faf9f9;
  width: 90%;
  height: 15%;
  position: relative;
  left: 25px;
  right: 25px;
  margin-top: 15px;
  margin-bottom: 15px;
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
</style>
