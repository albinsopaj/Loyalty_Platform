<template>
  <div v-if="!correct">
    <h1 class="title">
      Your companies
    </h1>
    <table class="table table-dark">
      <thead>
      <tr>
        <th scope="col">#</th>
        <th scope="col">Name</th>
        <th scope="col"></th>
        <th scope="col"></th>
      </tr>
      </thead>
      <tbody>
      <tr v-for="company in companies" :key="company.id" class="list-group-horizontal">
        <td></td>
        <td>{{ company.name }}</td>
        <td><button class="btn btn-primary btn-block" @click="pushToViewPrograms(currentOwner.id,company.id)">
          View Fidelity Programs
        </button></td>
        <td><button class="btn btn-primary btn-block" @click="pushToAddProgram(currentOwner.id,company.id)">
          Add Fidelity Program
        </button></td>
      </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import ownerService from "@/services/owner/OwnerService";

export default {
  name: "OwnerCompanies",
  data() {
    return {
      companies: [],
      correct: false
    }
  },
  computed: {
    currentOwner() {
      return this.$store.state.ownerAuth.owner;
    }
  },
  props:{
    ownerId: {}
  },
  methods: {
    pushToAddProgram(ownerId,companyId){
      this.$router.push("/owner/addFidelityProgram/" + ownerId + "/" + companyId)
    },
    pushToViewPrograms(ownerId,companyId){
      this.$router.push("/owner/fidelityPrograms/" + ownerId + "/" + companyId)
    }
  },
  mounted(){
    if( this.ownerId == this.currentOwner.id){
      ownerService.getCompanies(this.ownerId).then(response => {this.companies = response.data})
    } else {
      this.correct = true;
    }
  }
}
</script>

<style scoped>
.btn {
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