<template>
  <nav id="vue" class="nav_bar">
    <div class="menu-item"><router-link to="/home">Home</router-link></div>
    <div v-if="currentClient" class="menu-item">
      <router-link to="/companies">Search Companies</router-link>
    </div>
    <div v-if="currentClient" class="menu-item">
      <router-link :to="'/digitalWallet/' + currentClient.id">Digital Wallet</router-link>
    </div>
    <div v-if="currentOwner" class="menu-item">
      <router-link to="/owner/addCompany">Add Company</router-link>
    </div>
    <div v-if="currentOwner" class="menu-item">
      <router-link :to="'/owner/companies/' + currentOwner.id">Companies</router-link>
    </div>
    <div v-if="currentOwner" class="menu-item">
      <router-link :to="'/profile/modify/' + currentOwner.id">Modify Profile</router-link>
    </div>
    <div v-if="currentClient" class="menu-item">
      <router-link :to="'/profile/modify/' + currentClient.id">Modify Profile</router-link>
    </div>
    <RegisterService v-if="!currentClient && !currentOwner" title="Register" />
    <LoginService v-if="!currentClient && !currentOwner" title="Login" />
    <AccountProfile v-if="currentClient || currentOwner" title="Account" />
  </nav>
</template>

<script>
import LoginService from "./LoginService.vue";
import RegisterService from "./RegisterService.vue";
import AccountProfile from "./AccountProfile.vue";
export default {
  name: "navBar",
  components: {
    LoginService,
    RegisterService,
    AccountProfile,
  },
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
nav {
  width: 100vw;
  background-color: #0d0d0e;
  display: flex;
  align-items: center;
  justify-content: center;
}
nav .menu-item {
  color: #fff;
  padding: 25px 40px;
  position: relative;
  text-align: center;
  border-bottom: 5px solid transparent;
  display: flex;
  transition: 0.4s;
}
nav .menu-item.active,
nav .menu-item:hover {
  background-color: #0d0d0e;
  border-bottom-color: #bb3030;
}
nav .menu-item a {
  color: inherit;
  text-decoration: none;
}

@media only screen and (max-width: 768px) {
  nav {
    display: flex;
    flex-direction: row;
    justify-content: space-around;
    width: 100vw;
    padding-top: 2%;
    padding-bottom: 2%;
    background-color: #000000;
    font-size: 20px;
  }
  
}


</style>