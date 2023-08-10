<template>
  <div class="flashcard-front" v-on:click="flip">
    <h3>{{ flashcard.subject }} </h3>
    <p>{{ flashcard.question }}</p>
  </div>
</template>

<script>
export default {
  name: "FlashcardFront",
  props: {
    flashcard: Object,
    flip: Function,
  },
};
</script>

<style scoped>
/* Add styles for the front side of the flashcard here */
.flashcard-front {
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
