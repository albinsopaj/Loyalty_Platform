<template>
  <div class="container">
    <header class="jumbotron">
      <h3>
        <strong>{{currentOwner.username}}</strong> Profile
      </h3>
    </header>
    <p>
      <strong>Token:</strong>
      {{currentOwner.token.substring(0, 20)}} ... {{currentOwner.token.substr(currentOwner.token.length - 20)}}
    </p>
    <p>
      <strong>Id:</strong>
      {{currentOwner.id}}
    </p>
    <p>
      <strong>Email:</strong>
      {{currentOwner.email}}
    </p>
    <strong>Role:</strong>
    <p>
      <strong>{{currentOwner.role}}</strong>
    </p>
  </div>
</template>

<script>
export default {
  name: 'PlatformOwnerProfile',
  computed: {
    currentOwner() {
      return this.$store.state.ownerAuth.owner;
    }
  },
  mounted() {
    if (!this.currentOwner) {
      this.$router.push('/owner/login');
    }
  }
};
</script>