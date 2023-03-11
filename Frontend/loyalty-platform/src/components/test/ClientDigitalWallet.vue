<template>
  <h1 class="title">
    Your Cards
  </h1>
  <table class="table table-dark">
    <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">Name</th>
      <th scope="col">Company</th>
      <th scope="col">Type</th>
      <th scope="col">Points</th>
      <th scope="col">Level</th>
      <th scope="col">Experience</th>
    </tr>
    </thead>
    <tbody>
    <tr v-for="digitalCard in digitalCards" :key="digitalCard.id" class="list-group-horizontal">
      <td></td>
      <td>{{ digitalCard.fidelityProgramName }}</td>
      <td>{{ digitalCard.companyName }}</td>
      <td>{{ digitalCard.type }}</td>
      <td>{{ digitalCard.points }}</td>
      <td>{{ digitalCard.level }}</td>
      <td>{{ digitalCard.experience }}</td>
    </tr>
    </tbody>
  </table>
</template>

<script>
import clientService from "@/services/client/ClientService";

export default {
  name: "ClientDigitalWallet",
  data(){
    return {
      digitalCards: []
    }
  },
  props: {
    clientId: {}
  },
  computed: {
    currentClient() {
      return this.$store.state.clientAuth.client;
    }
  },
  mounted(){
    if( this.clientId == this.currentClient.id){
      clientService.getDigitalCards(this.clientId).then(response => {this.digitalCards = response.data})
    }
  }
}
</script>

<style scoped>
.title {
  text-align: center;
}
btn {
  margin:10px 10px 10px 10px;
}
.title{
  text-align: center;
}
.table {
  counter-reset: serial-number;
}

.table td:first-child:before {
  counter-increment: serial-number;
  content: counter(serial-number);
}
</style>