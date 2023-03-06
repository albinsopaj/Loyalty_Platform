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
          <router-link v-if="currentClient" to="/client" class="nav-link">Client</router-link>
          <router-link v-if="currentOwner" to="/owner" class="nav-link">Owner</router-link>
        </li>
        </ul>
      </div>

      <div v-if="!currentClient && !currentOwner" class="navbar-nav ml-auto">
        <ul>
        <li class="nav-item">
          <router-link to="/client/register" class="nav-link">
             Client Sign Up
          </router-link>
        </li>
          <li class="nav-item">
            <router-link to="/owner/register" class="nav-link">
              Owner Sign Up
            </router-link>
          </li>
        <li class="nav-item">
          <router-link to="/client/login" class="nav-link">
            Client Login
          </router-link>
        </li>
          <li class="nav-item">
            <router-link to="/owner/login" class="nav-link">
              Owner Login
            </router-link>
          </li>
        </ul>
      </div>

      <div v-if="currentClient" class="navbar-nav ml-auto">
        <ul>
        <li class="nav-item">
          <router-link to="/client/profile" class="nav-link">
            {{ currentClient.username }}
          </router-link>
        </li>
        <li class="nav-item">
          <a class="nav-link" @click.prevent="clientLogOut">
            LogOut
          </a>
        </li>
        </ul>
      </div>
      <div v-if="currentOwner" class="navbar-nav ml-auto">
        <ul>
          <li class="nav-item">
            <router-link to="/owner/profile" class="nav-link">
              {{ currentOwner.username }}
            </router-link>
          </li>
          <li class="nav-item">
            <a class="nav-link" @click.prevent="ownerLogOut">
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
    currentClient() {
      return this.$store.state.clientAuth.client;
    },
    currentOwner(){
      return this.$store.state.ownerAuth.owner;
    }
  },
  methods: {
    clientLogOut() {
      this.$store.dispatch('clientAuth/logout');
      this.$router.push('/home');
    },
    ownerLogOut() {
      this.$store.dispatch('ownerAuth/logout');
      this.$router.push('/home');
    }
  }
};
</script>

