<template>
  <div class="col-md-12">
    <div class="card card-container">
      <Form @submit="handleOwnerRegister" :validation-schema="schema">
        <div v-if="!successful">
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
          <div class="form-group">
            <label for="password">Password</label>
            <Field name="password" type="password" class="form-control" />
            <ErrorMessage name="password" class="error-feedback" />
          </div>

          <div class="form-group">
            <button class="btn btn-primary btn-block" :disabled="loading">
              <span
                  v-show="loading"
                  class="spinner-border spinner-border-sm"
              ></span>
              Sign Up
            </button>
          </div>
        </div>
      </Form>

      <div
          v-if="message"
          class="alert"
          :class="successful ? 'alert-success' : 'alert-danger'"
      >
        {{ message }}
      </div>
    </div>
  </div>
</template>

<script>
import { Form, Field, ErrorMessage } from "vee-validate";
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
      firstName: yup
          .string()
          .required("Name is required!")
          .min(1, "Must be at least 1 character!")
          .max(40, "Must be maximum 40 characters!"),
      lastName: yup
          .string()
          .required("Surname is required!")
          .min(1, "Must be at least 1 character!")
          .max(40, "Must be maximum 40 characters!"),
      phoneNumber: yup
          .number()
          .typeError("Insert a number!")
          .positive("A phone number can't start with a minus!")
          .integer("A phone number can't include a decimal point!")
          .required("Phone number is required!")
          .min(9, "Must be at least 2 digits!")
          .max(99999999999999999999, "Must be maximum 20 digits!"),
      biologicalGender: yup
          .string()
          .required("Gender is required!")
          .min(1, "Must be at least 1 character!")
          .max(40, "Must be maximum 40 characters!"),
      domicile: yup
          .string()
          .required("Domicile is required!")
          .min(1, "Must be at least 1 character!")
          .max(40, "Must be maximum 40 characters!")
    });

    return {
      successful: false,
      loading: false,
      message: "",
      schema,
    };
  },
  computed: {
    loggedIn() {
      return this.$store.state.ownerAuth.status.loggedIn;
    },
  },
  mounted() {
    if (this.loggedIn) {
      this.$router.push("/owner/profile");
    }
  },
  methods: {
    handleOwnerRegister(owner) {
      this.message = "";
      this.successful = false;
      this.loading = true;

      this.$store.dispatch("ownerAuth/register", owner).then(
          (data) => {
            this.message = data.message;
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
  max-width: 350px !important;
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
.profile-img-card {
  width: 96px;
  height: 96px;
  margin: 0 auto 10px;
  display: block;
  -moz-border-radius: 50%;
  -webkit-border-radius: 50%;
  border-radius: 50%;
}
.error-feedback {
  color: red;
}
.btn {
  margin:10px 10px 10px 10px;
}
</style>