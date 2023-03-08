<template>
  <header>
    <!-- <div class="container">
      <h3>Loyalty Platform</h3>
      <nav>
        <ul>
          <li>
            <a><router-link to="/home" class="nav-link">Home</router-link></a>
          </li>
          <li>
            <a><router-link to="/">Search Companies</router-link></a>
          </li>
          <li>
            <a
              ><router-link to="/owner/register"
                >Register as Owner</router-link
              ></a
            >
          </li>
          <li>
            <a
              ><router-link to="/client/register"
                >Register as Client</router-link
              ></a
            >
          </li>
          <li>
            <a><router-link to="/owner/login">Login as Owner</router-link></a>
          </li>
          <li>
            <a><router-link to="/client/login">Login as Client</router-link></a>
          </li>
          <li>
            <ServicesDrop title="ServicesDrop" />
          </li>
        </ul>
      </nav>
      <div class="menu-icon"></div>
    </div> -->

    <div class="">
      <nav class="">
        <h3>Loyalty Platform</h3>
        <a>
          <router-link to="/home" class="nav-link"> Home </router-link>
        </a>
        <a>
          <router-link to="">Search Companies</router-link>
        </a>
        <div v-if="currentOwner" class="navbar-nav ml-auto">
          <a>
            <router-link to="/owner/addCompany">Add Company</router-link>
          </a>
        </div>
        <div v-if="currentOwner || currentClient" class="navbar-nav ml-auto">
          <a>
            <router-link to="/profile/modify">Modify Profile</router-link>
          </a>
        </div>
        <!-- execute the following div iff the owner or client are not authenticated nor registered -->
        <div v-if="!currentClient && !currentOwner">
          <dropdown>
            <a>
              <router-link to="/owner/register">Register as Owner</router-link>
            </a>
            <a>
              <router-link to="/client/register"
                >Register as Client</router-link
              >
            </a>
          </dropdown>
          <a>
            <router-link to="/owner/login">Login as Owner</router-link>
          </a>
          <a>
            <router-link to="/client/login">Login as Client</router-link>
          </a>
        </div>
        
        <div v-if="currentClient" class="navbar-nav ml-auto">
          <a>
            <router-link to="/client/profile" class="nav-link">
              Profile
            </router-link>
          </a>

          <a class="nav-link" @click.prevent="clientLogOut"> LogOut </a>
        </div>

        <div v-if="currentOwner" class="navbar-nav ml-auto">
          <a>
            <router-link to="/owner/profile" class="nav-link">
              Profile
            </router-link>
          </a>
          <a class="nav-link" @click.prevent="ownerLogOut"> LogOut </a>
        </div>
      </nav>
    </div>
  </header>
  <router-view />
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
    },
  },
  methods: {
    clientLogOut() {
      this.$store.dispatch("clientAuth/logout");
      this.$router.push("/home");
    },
    ownerLogOut() {
      this.$store.dispatch("ownerAuth/logout");
      this.$router.push("/home");
    },
  },
};
</script>

<style>
header {
  height: 80px;
  background-color: #fff;
}
header .container {
  height: 80px;
  display: flex;
  justify-content: space-between;
  align-items: center;
}
header nav {
  width: 50%;
  display: block;
}
header nav ul {
  list-style-type: none;
  display: flex;
  justify-content: space-between;
  align-items: center;
}
header nav a {
  color: #111;
  text-decoration: none;
  transition: all 0.3s ease-in-out;
}
header nav a:hover {
  text-decoration: underline;
}
header .menu-icon {
  display: none;
}

@media screen and (max-width: 768px) {
  header nav {
    display: none;
  }
  header .menu-icon {
    display: block;
    width: 31px;
    height: 31px;
    background-image: url();
    background-repeat: no-repeat;
    background-position: center center;
  }
  header .menu-icon:hover {
    background-image: url();
  }
}

/*
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
*/
</style>
