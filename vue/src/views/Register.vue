<template>
  <div id="register" class="text-center">
    <form @submit.prevent="register">
     <h1>Flashcards <i class="fa-brands fa-pagelines"></i></h1>
        <h2 style ="font-size: 3rem; color: #faf9f9;">Create Account</h2>
      <div role="alert" v-if="registrationErrors">
        {{ registrationErrorMsg }}
      </div>
      <div class="form-input-group">
        <label for="username">Username</label>
        <input
          type="text"
          id="username"
          v-model="user.username"
          required
          autofocus
        />
      </div>
      <div class="form-input-group">
        <label for="password">Password</label>
        <input type="password" id="password" v-model="user.password" required />
      </div>
      <div class="form-input-group">
        <label for="confirmPassword">Confirm Password</label>
        <input
          type="password"
          id="confirmPassword"
          v-model="user.confirmPassword"
          required
        />
      </div>
      <button type="submit">Create Account</button>
      <p>
        <router-link :to="{ name: 'login' }" class = "login-link"
          >Already have an account? Log in.</router-link
        >
      </p>
    </form>
  </div>
</template>

<script>
import authService from "../services/AuthService";

export default {
  name: "register",
  data() {
    return {
      user: {
        username: "",
        password: "",
        confirmPassword: "",
        role: "user",
      },
      registrationErrors: false,
      registrationErrorMsg: "There were problems registering this user.",
    };
  },
  methods: {
    register() {
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = "Password & Confirm Password do not match.";
      } else {
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              this.$router.push({
                path: "/login",
                query: { registration: "success" },
              });
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = "Bad Request: Validation Errors";
            }
          });
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = "There were problems registering this user.";
    },
  },
};
</script>

<style scoped>
.form-input-group {
  display: flex;
  flex-direction: column; 
  margin-bottom: 1rem;
}

label {
  text-align: left;
  margin-bottom: 0.25rem; 
}

input {
  width: 100%;
  padding: 0.5rem; 
}

#register {
  display: flex;
  justify-content: center;
  align-self: center;
  background-color: #555b6e;
  height: 95.3vh;
  color: #89b0ae;
  font-size: 1.5em;
}

h1 {
  font-size: 5rem;
  color: #faf9f9;
}

h2 {
  font-size: 3.5rem;
  color: #faf9f9;
  text-align: center;
}
button {
  display: flex;
  margin-top: 30px;
  border-radius: 4px;
  background-color: #bee3db;
  width: 75%;
  height: 40px;
  align-items: center;
  justify-content: center;  
  font-weight: bold;
  position: relative;
  left: 55px;
}

button:hover {
  box-shadow: 0 12px 16px 0 rgba(0, 0, 0, 0.24),
    0 17px 50px 0 rgba(0, 0, 0, 0.19);
  border-radius: 4px;
  background-color: #89b0ae;
}
.login-link{
  display: flex;
  align-items: center;
  justify-content: center;
  color: #FAF9F9;
}
</style>
