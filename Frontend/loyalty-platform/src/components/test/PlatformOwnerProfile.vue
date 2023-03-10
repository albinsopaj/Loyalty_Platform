<template>
  <div v-if="!correct" class="container">
    <header class="jumbotron">
      <h3>
        <strong>{{ owner.username }}</strong> Profile
      </h3>
    </header>
    <p>
      <strong>Name:</strong>
      {{ owner.firstName }}
    </p>
    <p>
      <strong>Surname:</strong>
      {{ owner.lastName }}
    </p>
    <p>
      <strong>Domicile:</strong>
      {{ owner.domicile }}
    </p>
    <p>
      <strong>Phone Number:</strong>
      {{ owner.phoneNumber }}
    </p>
    <p>
      <strong>Biological Gender:</strong>
      {{ owner.biologicalGender }}
    </p>
    <p>
      <strong>Email:</strong>
      {{ owner.email }}
    </p>
  </div>
</template>

<script>


import ownerService from "@/services/owner/OwnerService";

export default {
  name: 'PlatformOwnerProfile',
  data() {
    return {
      correct: false,
      successful: false,
      loading: false,
      message: "",
      owner: {}
    }
  },
  props: {
    ownerId: {}
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
    if (this.ownerId == this.currentOwner.id){
      this.owner = ownerService.getOwner(this.ownerId).then(response => {this.owner = response.data})
    } else {
      this.correct = true;
    }
  },
};
</script>

<style>

</style>