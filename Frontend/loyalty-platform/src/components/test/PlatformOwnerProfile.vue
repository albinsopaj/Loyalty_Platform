<template>
  <div class="container">
    <header class="jumbotron">
      <h3>
        <strong>{{ currentOwner.username }}</strong> Profile
      </h3>
    </header>
    <p>
      <strong>Name:</strong>
      {{ currentOwner.firstName }}
    </p>
    <p>
      <strong>Surname:</strong>
      {{ currentOwner.lastName }}
    </p>
    <p>
      <strong>Domicile:</strong>
      {{ currentOwner.domicile }}
    </p>
    <p>
      <strong>Phone Number:</strong>
      {{ currentOwner.phoneNumber }}
    </p>
    <p>
      <strong>Biological Gender:</strong>
      {{ currentOwner.biologicalGender }}
    </p>
    <p>
      <strong>Email:</strong>
      {{ currentOwner.email }}
    </p>
  </div>
</template>

<script>

export default {
  name: 'PlatformOwnerProfile',
  data() {
    return {
      form: {
        name: ''
      },
      successful: false,
      loading: false,
      message: ""
    }
  },
  computed: {
    currentOwner() {
      return this.$store.state.ownerAuth.owner;
    }
  },
  mounted() {
    if (!this.currentOwner) {
      this.$router.push('/owner/login');
    }
  },
};
</script>

<style>

</style>