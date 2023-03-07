<template>
  <div id="app">
    <NavigationBar/>
    <router-view/>
  </div>
</template>

<script>
import NavigationBar from "@/components/NavigationBar";

export default {

  name: "App",

  components: {
    NavigationBar,
  }

};
</script>

<style>
body {
  margin: 0;
  height: 100vh;
  background: white;
}
</style>
