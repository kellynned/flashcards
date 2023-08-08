<template>
  <div class="deck">
    <h3>{{ deck.subject }}</h3>
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
</style>
