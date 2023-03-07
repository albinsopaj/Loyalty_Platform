<template>
  <div v-if="show" class="modal-mask">
    <div @click.self="pushToProfile" class="modal-wrapper">
      <div class="modal-container">
        <form v-if="!successful" @submit.prevent="addNewCompany(currentOwner.id)">
          <label>Company Name</label>
          <input type="text" v-model="form.name"/>
          <button type="submit" class="btn btn-primary btn-block">Submit</button>
        </form>
        <div
            v-if="message"
            class="alert"
            :class="successful ? 'alert-success' : 'alert-danger'"
        >
          {{ message }}
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import OwnerService from "@/services/owner/OwnerService";

export default {
  name: "addCompany",
  data() {
    return {
      form: {
        name: ''
      },
      successful: false,
      loading: false,
      message: "",
      show: true,
    }
  },
  computed: {
    currentOwner() {
      return this.$store.state.ownerAuth.owner;
    }
  },
  methods: {
    addNewCompany(ownerId) {
      OwnerService.addCompany(ownerId, this.form).then(
          () => {
            this.message = "Company created";
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
    },
    pushToProfile(){
      this.$router.push("/owner/profile")
    }
  }
}
</script>

<style scoped>
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
.btn {
  position:relative;
  top: 10px;
}
</style>