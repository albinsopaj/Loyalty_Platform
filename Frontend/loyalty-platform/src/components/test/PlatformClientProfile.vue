<template>
  <div class="container">
    <header class="jumbotron">
      <h3>
        <strong>{{currentClient.username}}</strong> Profile
      </h3>
    </header>
    <p>
      <strong>Token:</strong>
      {{currentClient.token.substring(0, 20)}} ... {{currentClient.token.substr(currentClient.token.length - 20)}}
    </p>
    <p>
      <strong>Id:</strong>
      {{currentClient.id}}
    </p>
    <p>
      <strong>Email:</strong>
      {{currentClient.email}}
    </p>
    <strong>Role:</strong>
    <p>
      <strong>{{currentClient.role}}</strong>
    </p>
  </div>
</template>

<script>
export default {
  name: 'PlatformProfile',
  computed: {
    currentClient() {
      return this.$store.state.clientAuth.client;
    }
  },
  mounted() {
    if (!this.currentClient) {
      this.$router.push('/client/login');
    }
  }
};
</script>


