<template>
  <div id="app">
    <div id="nav">
      <router-link v-bind:to="{ name: 'home' }" class="nav-option">Home <i class="fa-solid fa-house"></i></router-link>
      <span class="separator">|</span>
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''" class="nav-option">Logout <i class="fa-solid fa-arrow-right-from-bracket" id="logout-arrow"></i></router-link>
    </div>
    <router-view />
  </div>
</template>

<style scoped>
#nav {
  display: flex;
  align-items: center;
  background-color: #89B0AE;
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
  background-color: #70A8A6;
}

.router-link-exact-active {
  background-color: #70A8A6;
}

/* Optional: Add an icon to the Logout link */
.nav-option.logout::before {
  content: "\f2f5"; /* Unicode for a logout icon (you can replace with your preferred icon) */
  font-family: "Font Awesome"; /* Include the Font Awesome font family */
  margin-right: 6px;
}
.separator{
  margin-right: 20px;
  color: #fff;
}
#logout-arrow{
  margin-left: 3px;
}
.fa-house{
  margin-left: 3px;
}
</style>
