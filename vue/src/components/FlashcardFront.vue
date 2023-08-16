<template>
  <div class="flashcard-front">
    <h3 class="cardHead" @click="flip">
      {{ flashcard.subject }}
      <router-link
        :to="{
          name: 'modifyflashcard',
          params: {
            flashcardId: flashcard.flashcardId,
            subject: flashcard.subject,
            question: flashcard.question,
            answer: flashcard.answer,
          },
        }"
        class="edit-button"
        ><i class="fa-solid fa-pen-to-square"></i
      ></router-link>
    </h3>
    <p class="question" @click="flip">{{ flashcard.question }}</p>
  </div>
</template>

<script>
export default {
  name: "FlashcardFront",
  props: {
    flashcard: Object,
    flip: Function,
  },
  data() {
    return {
      selectedId: [],
    };
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
  bottom: 30px;
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

.cardHead {
  position: relative;
  left: 30px;
 
}

i {
  position: relative;
  left: 135px;
  bottom: 10px;
}


</style>
