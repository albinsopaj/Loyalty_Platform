<template>
  <div class="col-md-12">
    <div class="card card-container">
      <div
          v-if="message"
          class="alert"
          :class="successful ? 'alert-success' : 'alert-danger'"
      >
        {{ message }}
      </div>
      <Form v-if="!successful && currentOwner" @submit="handleOwnerProfileChange" @click="getId(currentOwner.id)">
        <div class="form-group">
          <label for="firstName">Name</label>
          <Field name="firstName" type="text" class="form-control" />
          <ErrorMessage name="firstName" class="error-feedback" />
        </div>
        <div class="form-group">
          <label for="lastName">Surname</label>
          <Field name="lastName" type="text" class="form-control" />
          <ErrorMessage name="lastName" class="error-feedback" />
        </div>
        <div class="form-group">
          <label for="email">Email</label>
          <Field name="email" type="email" class="form-control" />
          <ErrorMessage name="email" class="error-feedback" />
        </div>
        <div class="form-group">
          <label for="phoneNumber">Phone Number</label>
          <Field name="phoneNumber" type="text" class="form-control" />
          <ErrorMessage name="phoneNumber" class="error-feedback" />
        </div>
        <div class="form-group">
          <label for="biologicalGender">Gender</label>
          <Field name="biologicalGender" type="text" class="form-control" />
          <ErrorMessage name="biologicalGender" class="error-feedback" />
        </div>
        <div class="form-group">
          <label for="domicile">Domicile</label>
          <Field name="domicile" type="text" class="form-control" />
          <ErrorMessage name="domicile" class="error-feedback" />
        </div>
        <div class="form-group">
          <label for="username">Username</label>
          <Field name="username" type="text" class="form-control" />
          <ErrorMessage name="username" class="error-feedback" />
        </div>
        <pre>
          {{values}}
        </pre>
        <div class="form-group">
          <button class="btn btn-primary btn-block" :disabled="loading">
              <span
                  v-show="loading"
                  class="spinner-border spinner-border-sm"
              ></span>
            Confirm
          </button>
        </div>
      </Form>
      <Form v-if="!successful && currentClient" @submit="handleClientProfileChange" @click="getId(currentClient.id)">
        <div class="form-group">
          <label for="firstName">Name</label>
          <Field name="firstName" type="text" class="form-control" />
          <ErrorMessage name="firstName" class="error-feedback" />
        </div>
        <div class="form-group">
          <label for="lastName">Surname</label>
          <Field name="lastName" type="text" class="form-control" />
          <ErrorMessage name="lastName" class="error-feedback" />
        </div>
        <div class="form-group">
          <label for="email">Email</label>
          <Field name="email" type="email" class="form-control" />
          <ErrorMessage name="email" class="error-feedback" />
        </div>
        <div class="form-group">
          <label for="phoneNumber">Phone Number</label>
          <Field name="phoneNumber" type="text" class="form-control" />
          <ErrorMessage name="phoneNumber" class="error-feedback" />
        </div>
        <div class="form-group">
          <label for="biologicalGender">Gender</label>
          <Field name="biologicalGender" type="text" class="form-control" />
          <ErrorMessage name="biologicalGender" class="error-feedback" />
        </div>
        <div class="form-group">
          <label for="domicile">Domicile</label>
          <Field name="domicile" type="text" class="form-control" />
          <ErrorMessage name="domicile" class="error-feedback" />
        </div>
        <div class="form-group">
          <label for="username">Username</label>
          <Field name="username" type="text" class="form-control" />
          <ErrorMessage name="username" class="error-feedback" />
        </div>
        <pre>
          {{values}}
        </pre>
        <div class="form-group">
          <button class="btn btn-primary btn-block" :disabled="loading">
              <span
                  v-show="loading"
                  class="spinner-border spinner-border-sm"
              ></span>
            Confirm
          </button>
        </div>
      </Form>
    </div>
  </div>
</template>

<script>
import OwnerService from "@/services/owner/OwnerService";
import ClientService from "@/services/client/ClientService";
import {ErrorMessage, Field, Form} from "vee-validate";
import * as yup from "yup";

export default {
  name: "PlatformOwnerRegister",
  components: {
    Form,
    Field,
    ErrorMessage,
  },
  data() {
    const schema = yup.object().shape({
      username: yup
          .string()
          .required("Username is required!")
          .min(3, "Must be at least 3 characters!")
          .max(20, "Must be maximum 20 characters!"),
      email: yup
          .string()
          .required("Email is required!")
          .email("Email is invalid!")
          .max(50, "Must be maximum 50 characters!"),
      password: yup
          .string()
          .required("Password is required!")
          .min(6, "Must be at least 6 characters!")
          .max(40, "Must be maximum 40 characters!"),
    });

    return {
      successful: false,
      loading: false,
      message: "",
      userId: null,
      schema,
    };
  },
  computed: {
    currentOwner() {
      return this.$store.state.ownerAuth.owner;
    },
    currentClient(){
      return this.$store.state.clientAuth.client;
    }
  },
  methods: {
    handleOwnerProfileChange(owner) {
      OwnerService.modifyProfile(this.userId, owner).then(
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
    getId(id){
      this.userId = id;
    },
    handleClientProfileChange(client) {
      ClientService.modifyProfile(this.userId, client).then(
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