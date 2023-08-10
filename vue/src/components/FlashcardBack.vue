<template>
  <div class="flashcard-back" v-on:click="flipBack">
    <p>{{ flashcard.answer }}</p>
  </div>
</template>

<script>
export default {
  name: "FlashcardBack",
  props: {
    flashcard: Object,
  },
  methods: {
    markCorrect() {
      this.$store.commit("markCorrect", this.flashcard.id);
    },
  },
};
</script>

<style scoped>
/* Add styles for the back side of the flashcard here */
.flashcard-back {
  background-color: #faf9f9;
  border-radius: 25px;
  cursor: pointer;
  text-align: center;
  width: 90%;
  height: 15%;
  position: relative;
  left: 25px;
  margin-top: 15px;
  margin-bottom: 15px;
}
</style>
