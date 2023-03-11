<template>
  <div v-if="show" class="modal-mask">
    <div @click.self="goBack" class="modal-wrapper">
      <div class="modal-container">
        <div
            v-if="message && hidePrograms"
            class="alert"
            :class="successful ? 'alert-success' : 'alert-danger'"
        >
          {{ message }}
        </div>
        <div v-if="!hidePrograms">
        <table class="table table-dark">
          <thead>
          <tr>
            <th scope="col">#</th>
            <th scope="col">Name</th>
            <th scope="col">Type</th>
            <th scope="col">Conversion Rate</th>
            <th scope="col">Experience to Unlock</th>
            <th></th>
          </tr>
          </thead>
          <tbody>
          <tr v-for="fidelityProgram in fidelityPrograms" :key="fidelityProgram.id" class="list-group-horizontal">
            <td></td>
            <td>{{ fidelityProgram.name }}</td>
            <td>{{ fidelityProgram.type }}</td>
            <td>{{ fidelityProgram.conversionRate }}</td>
            <td>{{ fidelityProgram.experienceToUnlock }}</td>
            <td><button class="btn btn-primary btn-block" @click="registerToFidelityProgram(fidelityProgram.id)">Register</button></td>
          </tr>
          </tbody>
        </table>
        </div>
      </div>
    </div>
  </div>
  <h1 class="title">
    Platform Companies
  </h1>
  <table class="table table-dark">
    <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">Name</th>
      <th></th>
    </tr>
    </thead>
    <tbody>
    <tr v-for="company in companies" :key="company.id" class="list-group-horizontal">
      <td></td>
      <td>{{ company.name }}</td>
      <td><button class="btn btn-primary btn-block" @click="viewCompanyFidelityPrograms(company.id)">Fidelity Programs</button></td>
    </tr>
    </tbody>
  </table>
</template>

<script>

import companyService from "@/services/company/CompanyService";
import clientService from "@/services/client/ClientService";

export default {
  name: "PlatformCompanies",
  data() {
    return {
      companies: [],
      fidelityPrograms: [],
      show: false,
      successful: false,
      loading: false,
      message: "",
      hidePrograms: false
    }
  },
  computed: {
    currentClient() {
      return this.$store.state.clientAuth.client;
    }
  },
  mounted(){
    companyService.getCompanies().then(response => {this.companies = response.data})
  },
  methods: {
    viewCompanyFidelityPrograms(companyId){
      this.show = true
      companyService.getFidelityPrograms(companyId).then(response => {this.fidelityPrograms = response.data})
    },
    goBack(){
      this.show = !this.show;
      this.hidePrograms = !this.hidePrograms;
    },
    registerToFidelityProgram(fidelityProgramId){
      this.hidePrograms = !this.hidePrograms
      clientService.registerToFidelityProgram(this.currentClient.id,fidelityProgramId).then(
          () => {
            this.message = "Registered correctly";
            this.successful = true;
            this.loading = false;
          },
          (error) => {
            this.message =
                (error.response &&
                    error.response.data &&
                    error.response.data.message) ||
                error.message ||
                error.toString();
            this.successful = false;
            this.loading = false;
          }
      )
    }
  }
}
</script>

<style scoped>
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
.modal-mask {
  position: fixed;
  z-index: 9998;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-color: rgba(0, 0, 0, 0.5);
  display: table;
  transition: opacity 0.3s ease;
}

.modal-wrapper {
  display: table-cell;
  vertical-align: middle;
}

.modal-container {
  width: 1280px;
  margin: 0px auto;
  padding: 20px 30px;
  background-color: #fff;
  border-radius: 2px;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.33);
  transition: all 0.3s ease;
}

.modal-header h3 {
  margin-top: 0;
  color: #42b983;
}
label {
  display: block;
  margin-top: 10px;
}
.error-feedback {
  color: red;
}
</style>