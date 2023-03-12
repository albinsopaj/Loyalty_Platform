<template>
  <v-app>
    <NavBar/>
    <router-view/>
    <FooterSection/>
  </v-app>
</template>
<script>
import FooterSection from "@/components/FooterSection.vue";
import NavBar from "@/components/NavBar.vue";

export default {
  name: "HomePage",
  components: {
    FooterSection,
    NavBar,
  },
};
</script>
<style>
.marginLeft {
  margin-left: -90px;
}

.mtop {
  margin-top: 100px;
}

.mbottom {
  margin-bottom: 100px;
}

.v-card.borderme {
  border: 2px solid green !important;
}

.v-card.borderout {
  border: 1px solid #d5f0db !important;
}

.v-btn:not(.v-btn--round).v-size--default.add {
  min-width: 0px !important;
}

.theme--light.v-sheet--outlined.mobile {
  border: 2px solid black !important;
}

@media only screen and (max-width: 600px) {
  h2.title1 {
    font-size: 15px;
  }

  h2.title2 {
    font-size: 15px;
  }

  .top {
    margin-top: 20px;
  }
}

@media only screen and (min-width: 600px) {
  .top {
    margin-top: 70px;
  }
}

@media only screen and (min-width: 768px) {
  .top {
    margin-top: 120px;
  }
}

@media (max-width: 767px) {
  .navbar-expand-lg .navbar-nav .nav-link {
    padding-right: 0.5rem;
    padding-left: 0.5rem;
  }
}
</style>
