<template>
  <div class="menu-item" @click="isOpen = !isOpen">
    <a href="#">
      {{ title }}
    </a>
    <svg viewBox="0 0 1030 638" width="10">
      <path
        d="M1017 68L541 626q-11 12-26 12t-26-12L13 68Q-3 49 6 24.5T39 0h952q24 0 33 24.5t-7 43.5z"
        fill="#FFF"
      ></path>
    </svg>
    <transition name="fade" apear>
      <div class="sub-menu" v-if="isOpen">
        <div v-if="currentClient" class="menu-item">
          <router-link to="/client/profile">View Profile</router-link>
        </div>
        <div v-if="currentClient" class="menu-item" @click.prevent="clientLogOut">
          Logout
        </div>
        <div v-if="currentOwner">
          <router-link to="/owner/profile">View Profile</router-link>
        </div>
        <div v-if="currentOwner" @click.prevent="ownerLogOut">Logout</div>
      </div>
    </transition>
  </div>
</template>

<script>
export default {
  name: "accountProfile",
  props: ["title"],
  data() {
    return {
      isOpen: false,
    };
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
nav .menu-item svg {
  width: 10px;
  margin-left: 10px;
}
nav .menu-item .sub-menu {
  position: absolute;
  background-color: #222;
  top: calc(100% + 5px);
  left: 50%;
  transform: translateX(-50%);
  width: max-content;
  border-radius: 0px 0px 16px 16px;
}
.fade-enter-active,
.fade-leave-active {
  transition: all 0.5s ease-out;
}
.fade-enter,
.fade-leave-to {
  opacity: 0;
}
.sub-menu {
  cursor: pointer;
}
</style>
