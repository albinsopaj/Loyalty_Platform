<template>
  <div id="app">
    <PlatformClient/>
    <signup-form tool-id="nkmbbm"/>
  </div>
</template>

<script>
import PlatformClient from "@/components/PlatformClient.vue";
import {SignupForm} from "@userfront/vue";

export default {
  name: 'App',
  components: {
    PlatformClient,
    SignupForm
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
