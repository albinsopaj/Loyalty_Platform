<template>
  <div class="container">
    <header class="jumbotron">
      <h3>
        <strong>{{currentClient.username}}</strong> Profile
      </h3>
    </header>
    <p>
      <strong>Name:</strong>
      {{ currentClient.firstName }}
    </p>
    <p>
      <strong>Surname:</strong>
      {{ currentClient.lastName }}
    </p>
    <p>
      <strong>Domicile:</strong>
      {{ currentClient.domicile }}
    </p>
    <p>
      <strong>Phone Number:</strong>
      {{ currentClient.phoneNumber }}
    </p>
    <p>
      <strong>Biological Gender:</strong>
      {{ currentClient.biologicalGender }}
    </p>
    <p>
      <strong>Email:</strong>
      {{ currentClient.email }}
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


