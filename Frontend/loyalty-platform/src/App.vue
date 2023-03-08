<template>
  <div id="app" class="bg-green-400 h-screen">
    <NavBar/>
  </div>
  <router-view/>
</template>
<script>
import NavBar from "@/components/NavBar";

export default {
  name: "App",
  components: {
    NavBar
}

};
</script>
<style>

</style>
