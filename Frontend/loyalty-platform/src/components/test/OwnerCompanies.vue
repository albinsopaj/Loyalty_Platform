<template>
  <h1>
    <ol v-for="company in currentOwner.companies" :key="company.id" class="list-group">
      <li class="list-group-item">
        {{ company.name }}
        <button class="btn btn-primary btn-block">
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
export default {
  name: "OwnerCompanies",
  computed: {
    currentOwner() {
      return this.$store.state.ownerAuth.owner;
    }
  },
  methods: {
    pushToAddProgram(ownerId,companyId){
      this.$router.push("/owner/addFidelityProgram/" + ownerId + "/" + companyId)
    }
  }
}
</script>

<style scoped>
.btn {
  margin:10px 10px 10px 10px;
}
</style>