<template>
  <div class="flashcard-back" @click="flip()">
    <p class ="answer">{{ flashcard.answer }}</p>
    
  </div>
</template>

<script>
export default {
  name: "FlashcardBack",
  props: {
    flashcard: Object,
    flip: Function,
  },
  methods: {
  },
};
</script>

<style scoped>
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

.answer {
  display: flex;
  justify-content: center;
  text-align: center;
  position: relative;
  top: 15px;
}
</style>
