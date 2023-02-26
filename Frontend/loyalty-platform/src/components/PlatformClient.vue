<template>
  <div class = "container">
    <div v-if="state === 'default'">
      <button>Logout</button>
      <div></div>
      <div @click="toggleShowCompanies" class = "custom-box">
          <h1>Companies</h1>
      </div>
    </div>
    <div v-if="state === 'showCompanies' ">
      <button @click="goBack">Go back</button>
      <PlatformCompanies/>
    </div>
  </div>
</template>

<script>

import PlatformCompanies from "@/components/PlatformCompanies.vue";
export default {
  name: 'PlatformClients',
  data(){
    return {
      state: 'default'
    }
  },
  components: {
    PlatformCompanies
  },
  methods: {
    toggleShowCompanies(){
      this.state = 'showCompanies';
    },
    goBack(){
      this.state = 'default';
    },
  },
  created() {

  }
}

</script>

<style>
.custom-box {
  background-color: lightgrey;
  width: 800px;
  height:  450px;
  border: 15px solid green;
  padding: 50px;
  margin: 20px;
}
</style>