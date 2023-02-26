<template>
  <div class = "container">

    <h1 class = "text-center"> Company List</h1>

    <table class = "table table-striped">
      <thead>
      <tr>
        <th> Company Name</th>
      </tr>

      </thead>
      <tbody>
      <tr v-for="company in companies" v-bind:key="company.id">
        <td> {{company.name}}</td>
      </tr>
      </tbody>
    </table>
  </div>
</template>

<script>

import CompanyService from "@/services/CompanyService";

export default {
  name: 'PlatformCompany',
  data(){
    return {
      companies: []
    }
  },
  methods: {
    getCompanies(){
      CompanyService.getCompanies().then((response) => {
        this.companies = response.data;
      });
    }
  },
  created() {
    this.getCompanies()
  }
}

</script>