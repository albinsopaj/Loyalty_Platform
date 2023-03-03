<template>
  <div class="w-full bg-white fixed top-0 shadow-lg">


    <div class="w-11/12 mx-auto flex justify-between justify-center items-center px-5 py-7">
      <div class="text-black sm:text-left text-center text-4xl font-bold font-pacifico">
        <h1>Recipee</h1>
      </div>
      <div class="md:hidden" @click="toggleMobileMenu">
        <font-awesome-icon v-if='!mobileMenu' :icon="['fas', 'bars']" class="text-xl"/>
        <font-awesome-icon v-if='mobileMenu' :icon="['fas', 'times']" class="text-xl"/>
      </div>
      <!-- desktop view -->
      <div class="flex bg-white space-x-12 hidden sm:block text-black-200 font-raleway tracking-wide items-center">
        <router-link to="/">HOME</router-link>
        <router-link to="/explore">SEARCH RECIPES</router-link>
        <router-link v-if="!user" to="/register">SIGN UP</router-link>
        <router-link v-if="!user" to="/login">LOGIN</router-link>
        <router-link v-if="user" to="/bookmarks">
          <font-awesome-icon :icon="['fas', 'bookmark']" class="text-xl"/>
          BOOKMARKS
        </router-link>
        <router-link v-if="user" to="">
          <font-awesome-icon :icon="['fas', 'user-circle']" class="text-xl"/>
          {{ user.username }}
        </router-link>
        <span @click="logout">
                  <router-link v-if="user" to="">LOGOUT</router-link>
                </span>

      </div>
    </div>

    <!-- mobile view -->
    <div v-if="mobileMenu" class="h-screen md:hidden text-2xl text-left font-raleway p-10">
      <router-link class="block my-7" to="/">HOME</router-link>
      <hr>
      <router-link class="block my-7" to="/explore">SEARCH RECIPES</router-link>
      <hr>
      <router-link v-if="!user" class="block my-7" to="/register">SIGN UP</router-link>
      <hr>
      <router-link v-if="!user" class="block my-7" to="/login">LOGIN</router-link>
      <hr>
      <router-link v-if="user" class="block my-7" to="/bookmarks">
        <font-awesome-icon :icon="['fas', 'bookmark']" class="text-xl"/>
        BOOKMARKS
      </router-link>
      <hr>
      <router-link v-if="user" class="block my-7" to="">
        <font-awesome-icon :icon="['fas', 'user-circle']" class="text-xl"/>
        {{ user.username }}
      </router-link>
      <hr>
      <span class="block my-7" @click="logout">
                <router-link v-if="user" to="">LOGOUT</router-link>
            </span>
    </div>
  </div>
</template>

<script>
// import { mapGetters } from 'vuex'
export default {
  name: 'Nav',

  data() {
    return {
      user: {},
      mobileMenu: false
    }
  },

  mounted() {
    this.user = JSON.parse(window.localStorage.getItem('userData'))
  },

  methods: {
    logout() {
      window.localStorage.removeItem('jwt')
      window.localStorage.removeItem('userData')
      window.localStorage.removeItem('bookmarks')
      this.$router.push('/login')
    },

    toggleMobileMenu() {
      this.mobileMenu = !this.mobileMenu
    }
  }
}
</script>

<style scoped>

</style>