<template>
  <div id="app">
    <div id="nav">
      <router-link
        v-bind:to="{ name: 'home' }"
        v-if="$store.state.token != ''"
        class="nav-option"
        >Home <i class="fa-solid fa-house"></i
      ></router-link>
      <span
        v-bind:to="{ name: 'separator' }"
        v-if="$store.state.token != ''"
        class="separator"
        >|</span
      >
      <router-link
        v-bind:to="{ name: 'DecksPage' }"
        v-if="$store.state.token != ''"
        class="nav-option"
        >Decks <i class="fa-solid fa-layer-group"></i
      ></router-link>
      <span
        v-bind:to="{ name: 'separator' }"
        v-if="$store.state.token != ''"
        class="separator"
        >|</span
      >
      <router-link
        v-bind:to="{ name: 'FlashcardsPage' }"
        v-if="$store.state.token != ''"
        class="nav-option"
        >Flashcards <i class="fa-brands fa-pagelines"></i
      ></router-link>
      <span
        v-bind:to="{ name: 'separator' }"
        v-if="$store.state.token != ''"
        class="separator"
        >|</span
      >
      <router-link
        v-bind:to="{ name: 'logout' }"
        v-if="$store.state.token != ''"
        class="nav-option"
        >Logout
        <i class="fa-solid fa-arrow-right-from-bracket" id="logout-arrow"></i
      ></router-link>
    </div>
    <router-view />
  </div>
</template>

<script>


export default {
  components: {
  },
  computed: {
    totalCorrect() {
      return this.flashcards.filter((flashcard) => flashcard.correct).length;
    },
  },
};
</script>

<style scoped>
#nav {
  display: flex;
  align-items: center;
  background-color: #89b0ae;
  height: 4.7vh;
  padding: 0 20px;
  box-shadow: 0px 2px 4px rgba(0, 0, 0, 0.1);
}

.nav-option {
  color: #fff;
  text-decoration: none;
  margin-right: 20px;
  padding: 8px 12px;
  border-radius: 4px;
  transition: background-color 0.3s, color 0.3s;
}

.nav-option:hover {
  background-color: #70a8a6;
}

.nav-option.logout::before {
  content: "\f2f5";
  font-family: "Font Awesome"; 
  margin-right: 6px;
}
.separator {
  margin-right: 20px;
  color: #fff;
}
#logout-arrow {
  margin-left: 3px;
}
.fa-house {
  margin-left: 3px;
}
</style>
