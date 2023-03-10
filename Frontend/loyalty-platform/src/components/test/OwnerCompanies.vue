<template>
  <h1 v-if="!correct">
    <ol v-for="company in companies" :key="company.id" class="list-group">
      <li class="list-group-item">
        {{ company.name }}
        <button class="btn btn-primary btn-block" @click="pushToViewPrograms(currentOwner.id,company.id)">
          View Fidelity Programs
        </button>
        <button class="btn btn-primary btn-block" @click="pushToAddProgram(currentOwner.id,company.id)">
          Add Fidelity Program
        </button>
      </li>
    </ol>
  </h1>
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
</style>