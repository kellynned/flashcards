import Vue from 'vue'
import Router from 'vue-router'
import Home from '../views/Home.vue'
import Login from '../views/Login.vue'
import Logout from '../views/Logout.vue'
import Register from '../views/Register.vue'
import store from '../store/index'
import DecksPage from '../views/DecksPage.vue'
import CreateCard from '../views/CreateCard.vue'
import FlashcardsPage from '../views/FlashcardsPage.vue'
import StudySession from '../views/StudySession.vue'
import CreateDeck from '../views/CreateDeck.vue'
import ModifyFlashcard from '../views/ModifyFlashcard.vue'
import ViewDeckFlashcards from '../views/ViewDeckFlashcards.vue'


Vue.use(Router)

/**
 * The Vue Router is used to "direct" the browser to render a specific view component
 * inside of App.vue depending on the URL.
 *
 * It also is used to detect whether or not a route requires the user to have first authenticated.
 * If the user has not yet authenticated (and needs to) they are redirected to /login
 * If they have (or don't need to) they're allowed to go about their way.
 */

const router = new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/login",
      name: "login",
      component: Login,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/logout",
      name: "logout",
      component: Logout,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/register",
      name: "register",
      component: Register,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/deckspage",
      name: "DecksPage",
      component: DecksPage,
      meta: {
        requiresAuth: true
      }
    },

    {
      path: "/createcard",
      name: "createcard",
      component: CreateCard,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/flashcardspage",
      name: "FlashcardsPage",
      component: FlashcardsPage,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/studysession/:deckId",
      name: "StudySession",
      component: StudySession,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/createdeck",
      name: "createdeck",
      component: CreateDeck,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/modifyflashcard",
      name: "modifyflashcard",
      component: ModifyFlashcard,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/viewdeck/:deckId",
      name: "ViewDeckFlashcards",
      component: ViewDeckFlashcards,
      meta: {
        requiresAuth: true
      }
    }
  ]
})

router.beforeEach((to, from, next) => {
  // Determine if the route requires Authentication
  const requiresAuth = to.matched.some(x => x.meta.requiresAuth);

  // If it does and they are not logged in, send the user to "/login"
  if (requiresAuth && store.state.token === '') {
    next("/login");
  } else {
    // Else let them go to their next destination
    next();
  }
});

export default router;
