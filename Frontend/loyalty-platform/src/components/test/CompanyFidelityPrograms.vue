<template>
    <table class="table table-dark">
      <thead>
      <tr>
        <th scope="col">#</th>
        <th scope="col">Name</th>
        <th scope="col">Number of Clients</th>
        <th scope="col">Conversion Rate</th>
      </tr>
      </thead>
      <tbody>
        <tr v-for="fidelityProgram in company.fidelityPrograms" :key="fidelityProgram.id" class="list-group-horizontal">
          <td></td>
          <td>{{ fidelityProgram.name }}</td>
          <td>{{ fidelityProgram.clientIds.length }}</td>
          <td>{{ fidelityProgram.conversionRate }}</td>
        </tr>
      </tbody>
    </table>
</template>

<script>
import ownerService from "@/services/owner/OwnerService";

export default {
  name: "CompanyFidelityPrograms",
  data() {
    return {
      company: {},
    }
  },
  props: {
    ownerId: {},
    companyId: {},
  },
  mounted() {
    if(this.ownerId == this.currentOwner.id){
      ownerService.getCompany(this.ownerId,this.companyId).then(response => {this.company = response.data})
    }
  },
  computed: {
    currentOwner() {
      return this.$store.state.ownerAuth.owner;
    }
  }
}
</script>

<style scoped>
.table {
  counter-reset: serial-number;
}

.table td:first-child:before {
  counter-increment: serial-number;
  content: counter(serial-number);
}
</style>