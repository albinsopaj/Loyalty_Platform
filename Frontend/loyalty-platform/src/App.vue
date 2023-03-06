<template>

  <header>
    <div>
      <nav class="navigation-bar">
        <h3>Loyalty Platform</h3>
        <a>
          <router-link to="/home" class="nav-link">
            Home
          </router-link>
        </a>
        <a>
          <router-link to="">Search Companies</router-link>
        </a>

        <!-- execute the following dive iff the owner or client are not authenticated nor registered -->
        <div v-if="!currentClient && !currentOwner">
          <a>
            <router-link to="/owner/register">Register as Owner</router-link>
          </a>
          <a>
            <router-link to="/client/register">Register as Client</router-link>
          </a>
          <a>
            <router-link to="/owner/login">Login as Owner</router-link>
          </a>
          <a>
            <router-link to="/client/login">Login as Client</router-link>
          </a>
        </div>
      </nav>
    </div>

    <div v-if="currentClient" class="navbar-nav ml-auto">

      <a>
        <router-link to="/client/profile" class="nav-link">
          {{ currentClient.username }}
        </router-link>
      </a>

      <a class="nav-link" @click.prevent="clientLogOut">
        LogOut
      </a>

    </div>

    <div v-if="currentOwner" class="navbar-nav ml-auto">

      <a>
        <router-link to="/owner/profile" class="nav-link">
          Profile
        </router-link>
      </a>
      <a class="nav-link" @click.prevent="ownerLogOut">
        LogOut
      </a>

    </div>

  </header>


  <router-view/>

</template>

<script>


export default {

  components: {},

  computed: {
    currentClient() {
      return this.$store.state.clientAuth.client;
    },
    currentOwner() {
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

<style>

header {
  background-color: #333;
  color: white;
  height: 80px;
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 0 50px;
}

nav {
  display: flex;
  justify-content: space-between;
  align-items: center;
}

nav a {
  color: white;
  text-decoration: none;
  margin-left: 30px;
  font-size: 1.2rem;
  font-weight: bold;
  transition: all 0.3s ease;
}

navigation-bar {
  display: inline;
  justify-content: space-between;
}

</style>
