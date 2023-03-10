<template>
  <div v-if="!correct" class="container">
    <header class="jumbotron">
      <h3>
        <strong>{{ client.username }}</strong> Profile
      </h3>
    </header>
    <p>
      <strong>Name:</strong>
      {{ client.firstName }}
    </p>
    <p>
      <strong>Surname:</strong>
      {{ client.lastName }}
    </p>
    <p>
      <strong>Domicile:</strong>
      {{ client.domicile }}
    </p>
    <p>
      <strong>Phone Number:</strong>
      {{ client.phoneNumber }}
    </p>
    <p>
      <strong>Biological Gender:</strong>
      {{ client.biologicalGender }}
    </p>
    <p>
      <strong>Email:</strong>
      {{ client.email }}
    </p>
  </div>
</template>

<script>
import clientService from "@/services/client/ClientService";

export default {
  name: 'PlatformProfile',
  data() {
    return {
      client: {},
      correct: false
    }
  },
  props : {
    clientId: {}
  },
  computed: {
    currentClient() {
      return this.$store.state.clientAuth.client;
    }
  },
  mounted() {
    if (!this.currentClient) {
      this.$router.push('/client/login');
    }
    if (this.clientId == this.currentClient.id){
      this.client = clientService.getClient(this.clientId).then(response => {this.client = response.data})
    } else {
      this.correct = true;
    }
  }
};
</script>


