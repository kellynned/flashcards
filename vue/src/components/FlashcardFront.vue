<template>
  <div class="flashcard-front" @click="flip">
    <h3>
      {{ flashcard.subject }}
      <router-link v-bind:to="{ name: 'modifyflashcard' }" class="edit-button"
        ><i class="fa-solid fa-pen-to-square"></i
      ></router-link>
    </h3>
    <p class="question">{{ flashcard.question }}</p>
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
  top: 7px;
  margin-top: 15px;
  margin-bottom: 15px;
}

.question {
  position: relative;
  bottom: 17px;
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
