<template>
  <div class = "container">

    <h1 class = "text-center"> Company List</h1>

    <table class = "table table-striped" id="companiesTable">
      <thead>
      <tr>
        <th> Company Name</th>
        <th> Company Owner</th>
        <th> Fidelity Programs</th>
      </tr>

      </thead>
      <tbody>
      <tr v-for="company in companies" v-bind:key="company.id">
        <td>{{company.name}}</td>
        <td>{{company.owner.firstName+" "+company.owner.lastName}}</td>
        <td><button @click="showPrograms(company.fidelityPrograms)">Fidelity Programs</button></td>
      </tr>
      </tbody>
    </table>
    <div v-if="state === 'programs'" class="backdrop" @click.self="closeModal">
      <div class="modal">
        <table class = "table table-striped">
          <thead>
          <tr>
            <th> Fidelity Program Name</th>
          </tr>
          </thead>
          <tbody>
          <tr v-for="fidelityProgram in fidelityPrograms" v-bind:key="fidelityProgram.id">
            <td>{{fidelityProgram.name}}</td>
          </tr>
          </tbody>
        </table>
      </div>
    </div>
  </div>
</template>

<script>

import CompanyService from "@/services/CompanyService";

export default {
  name: 'PlatformCompany',
  data(){
    return {
      companies: [],
      fidelityPrograms: [],
      state: 'default'
    }
  },
  methods: {
    getCompanies(){
      CompanyService.getCompanies().then((response) => {
        this.companies = response.data;
      });
    },
    showPrograms(companyFidelityPrograms){
      this.state = 'programs';
      this.fidelityPrograms = companyFidelityPrograms;
    },
    closeModal(){
      this.state = 'default';
    }
  },
  created() {
    this.getCompanies()
  }
}

</script>

<style>
  .modal {
    width: 400px;
    padding: 20px;
    margin: 100px auto;
    background: white;
    border-radius: 10px;
  }
  .backdrop {
    top: 0;
    position: fixed;
    background: rgba(0,0,0,0.5);
    width: 100%;
    height: 100%;
  }
</style>