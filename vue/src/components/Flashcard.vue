<template>
  <div class="flashcard">
    <FlashcardFront v-if="!flipped" :flashcard="flashcard" :flip="flip" />
    <FlashcardBack v-else :flashcard="flashcard" />
    <input
      class="select"
      type="checkbox"
      :id="flashcardId" v-model="selectedFlashcardIds" :value="flashcardId"
    />
  </div>
</template>

<script>
import FlashcardFront from "./FlashcardFront.vue";
import FlashcardBack from "./FlashcardBack.vue";

export default {
  name: "Flashcard",
  components: {
    FlashcardFront,
    FlashcardBack,
  },
  props: {
    flashcard: Object,
  },
  data() {
    return {
      flipped: false,
    };
  },
  methods: {
    flip() {
      this.flipped = !this.flipped;
    },
    toggleSelected(flashcardId) {
      this.$emit("toggle-selected", flashcardId);
    },
  },
};
</script>

<style scoped>
.flashcard {
  border-radius: 25px;
  background-color: #faf9f9;
  width: 90%;
  height: 15%;
  position: relative;
  left: 25px;
  margin-top: 15px;
  margin-bottom: 15px;
}

.select {
  position: relative;
  right: 400px;
}
</style>
