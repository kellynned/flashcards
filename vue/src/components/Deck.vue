<template>
  <div class="deck">
    <h3>
      {{ deck.subject }}
      <button class="edit-button" @click="editDeck(deck)">
        <span>Edit </span>
      </button>
    </h3>
    <p>{{ deck.deck }}</p>
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
