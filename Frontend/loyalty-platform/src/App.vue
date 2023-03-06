<template>
  <div id="app">
    <nav class="navbar navbar-expand navbar-dark bg-dark">
      <a href="/" class="navbar-brand">Platform</a>
      <div class="navbar-nav mr-auto">
        <ul>
        <li class="nav-item">
          <router-link to="/home" class="nav-link">
            Home
          </router-link>
        </li>
        <li class="nav-item">
          <router-link v-if="currentUser" to="/client" class="nav-link">Client</router-link>
        </li>
        </ul>
      </div>

      <div v-if="!currentUser" class="navbar-nav ml-auto">
        <ul>
        <li class="nav-item">
          <router-link to="/register" class="nav-link">
             Sign Up
          </router-link>
        </li>
        <li class="nav-item">
          <router-link to="/login" class="nav-link">
            Login
          </router-link>
        </li>
        </ul>
      </div>

      <div v-if="currentUser" class="navbar-nav ml-auto">
        <ul>
        <li class="nav-item">
          <router-link to="/profile" class="nav-link">
            {{ currentUser.username }}
          </router-link>
        </li>
        <li class="nav-item">
          <a class="nav-link" @click.prevent="logOut">
            LogOut
          </a>
        </li>
        </ul>
      </div>
    </nav>

    <div class="container">
      <router-view />
    </div>
  </div>
</template>

<script>
export default {
  computed: {
    currentUser() {
      return this.$store.state.auth.client;
    },
  },
  methods: {
    logOut() {
      this.$store.dispatch('auth/logout');
      this.$router.push('/login');
    }
  }
};
</script>

