<template >
  <body>
    <section id="login-area">
      <div id="login">
        <form @submit.prevent="login">
          <h1>Flashcards</h1>
          <div role="alert" v-if="invalidCredentials">
            Invalid username and password!
          </div>
          <div role="alert" v-if="this.$route.query.registration">
            Thank you for registering, please sign in.
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
            <input
              type="password"
              id="password"
              v-model="user.password"
              required
            />
          </div>
          <button type="submit">Sign in</button>
          <p>
            <router-link :to="{ name: 'register' }"
              >Need an account? Sign up.</router-link
            >
          </p>
        </form>
      </div>
    </section>
  </body>
</template>

<script>
import authService from "../services/AuthService";

export default {
  name: "login",
  components: {},
  data() {
    return {
      user: {
        username: "",
        password: "",
      },
      invalidCredentials: false,
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then((response) => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/");
          }
        })
        .catch((error) => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    },
  },
};
</script>

<style scoped>
.form-input-group {
  margin-bottom: 1rem;
}
label {
  margin-right: 0.5rem;
}

#login {
  display: flex;
  justify-content: center;
  align-self: center;
  background-color: #555b6e;
  height: 95vh;
  color: #89b0ae;
  font-size: 1.9em;
}

h1 {
  font-size: 5rem;
  color: #faf9f9;
}

button {
  background-color: #89b0ae;
  border-radius: 10px;
  padding: 15px;
  min-height: 20px;
  min-width: 200px;
  color: #555b6e;
  font-size: 0.8em;
  border-color: white;
}

#login-area {
  display: flex;
  flex-direction: column;
  width: 45%;
}

body {
}
</style>
