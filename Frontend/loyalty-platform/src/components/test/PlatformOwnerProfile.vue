<template>
  <div class="container">
    <header class="jumbotron">
      <h3>
        <strong>{{ currentOwner.username }}</strong> Profile
      </h3>
    </header>
    <p>
      <strong>Token:</strong>
      {{ currentOwner.token.substring(0, 20) }} ... {{ currentOwner.token.substr(currentOwner.token.length - 20) }}
    </p>
    <p>
      <strong>Name:</strong>
      {{ currentOwner.firstName }}
    </p>
    <p>
      <strong>Surname:</strong>
      {{ currentOwner.lastName }}
    </p>
    <p>
      <strong>Domicile:</strong>
      {{ currentOwner.domicile }}
    </p>
    <p>
      <strong>Phone Number:</strong>
      {{ currentOwner.phoneNumber }}
    </p>
    <p>
      <strong>Biological Gender:</strong>
      {{ currentOwner.biologicalGender }}
    </p>
    <p>
      <strong>Id:</strong>
      {{ currentOwner.id }}
    </p>
    <p>
      <strong>Email:</strong>
      {{ currentOwner.email }}
    </p>
    <strong>Role:</strong>
    <p>
      <strong>{{ currentOwner.role }}</strong>
    </p>
    <p>
      <strong>Companies:</strong>
    </p>
    <ul v-for="company in currentOwner.companies" :key="company.id">
      <li>{{ company.name }}</li>
    </ul>
  </div>
  <button @click="showAddCompany">Add Company</button>
  <div v-if="show" class="modal-mask">
    <div class="modal-wrapper">
      <div class="modal-container">
        <form @submit.prevent="addNewCompany(currentOwner.id)">
          <label>Company Name</label>
          <input type="text" v-model="form.name"/>
          <button type="submit">Submit</button>
        </form>
        <button @click="showAddCompany" class="btn btn-primary btn-block">
          Cancel
        </button>
      </div>
    </div>
  </div>
</template>

<script>

import OwnerService from "@/services/owner/OwnerService";

export default {
  name: 'PlatformOwnerProfile',
  data() {
    return {
      form: {
        name: ''
      },
      successful: false,
      loading: false,
      message: "",
      show: false,
    }
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
  },
  methods: {
    showAddCompany() {
      this.show = !this.show;
    },
    addNewCompany(ownerId) {
      OwnerService.addCompany(ownerId, this.form);
    }
  }
};
</script>

<style>
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
  width: 300px;
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

.modal-body {
  margin: 20px 0;
}

.modal-default-button {
  float: right;
}

</style>