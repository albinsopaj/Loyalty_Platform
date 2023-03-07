<template>
  <div class="col-md-12">
    <div class="card card-container">
      <form v-if="!successful"  @submit.prevent="handleProfileChange(currentOwner.id)">
        <label>Name</label>
        <input type="text" v-model="form.firstName"/>
        <label>Surname</label>
        <input type="text" v-model="form.lastName"/>
        <label>Email</label>
        <input type="text" v-model="form.email"/>
        <label>Phone Number</label>
        <input type="text" v-model="form.phoneNumber"/>
        <label>Gender</label>
        <input type="text" v-model="form.biologicalGender"/>
        <label>Domicile</label>
        <input type="text" v-model="form.domicile"/>
        <label>Username</label>
        <input type="text" v-model="form.username"/>
        <button type="submit" class="btn btn-primary btn-block">Submit</button>
      </form>
      <button v-if="successful" class="btn btn-primary btn-block" @click="pushToProfile">
        Go Back To Profile
      </button>
        </div>
      <div
          v-if="message"
          class="alert"
          :class="successful ? 'alert-success' : 'alert-danger'"
      >
        {{ message }}
      </div>
    </div>
</template>

<script>
import OwnerService from "@/services/owner/OwnerService";

export default {
  name: "PlatformOwnerRegister",
  data() {
    return {
      successful: false,
      loading: false,
      message: "",
      form: {
        firstName: '',
        lastName: '',
        email: '',
        phoneNumber: '',
        biologicalGender: '',
        domicile: '',
        username: ''
      }
    };
  },
  computed: {
    currentOwner() {
      return this.$store.state.ownerAuth.owner;
    }
  },
  methods: {
    handleProfileChange(ownerId) {
      OwnerService.modifyProfile(ownerId, this.form).then(
          () => {
            this.message = "Profile modified"
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
      );
    },
    pushToProfile(){
      this.$router.push("/owner/profile")
    }
  },
};
</script>

<style scoped>
label {
  display: block;
  margin-top: 10px;
}
.card-container.card {
  max-width: 275px !important;
  padding: 40px 40px;
}
.card {
  background-color: #f7f7f7;
  padding: 20px 25px 30px;
  margin: 0 auto 25px;
  margin-top: 50px;
  -moz-border-radius: 2px;
  -webkit-border-radius: 2px;
  border-radius: 2px;
  -moz-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
  -webkit-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
  box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
}
</style>