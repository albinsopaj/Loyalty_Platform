<template>
  <div v-if="!show" class="modal-mask">
    <div @click.self="pushToProgramsList" class="modal-wrapper">
      <div class="modal-container">
        <div v-if="!hide">
          <button class="btn btn-primary btn-block" :disabled="loading" @click="setTypePoints">Points Program</button>
          <button class="btn btn-primary btn-block" :disabled="loading" @click="setTypeLevels">Levels Program</button>
        </div>
        <div
            v-if="message"
            class="alert"
            :class="successful ? 'alert-success' : 'alert-danger'"
        >
          {{ message }}
        </div>
        <Form v-if="!successful && points" @submit="addNewPointsFidelityProgram" :validation-schema="schemaPoints">
          <div class="form-group">
            <label for="name">Program Name</label>
            <Field name="name" type="text" class="form-control" />
            <ErrorMessage name="name" class="error-feedback" />
          </div>
          <div class="form-group">
            <label for="conversionRate">Conversion Rate</label>
            <Field name="conversionRate" type="text" class="form-control" />
            <ErrorMessage name="conversionRate" class="error-feedback" />
          </div>
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
        <Form v-if="!successful && levels" @submit="addNewLevelFidelityProgram" :validation-schema="schemaLevels">
          <div class="form-group">
            <label for="name">Program Name</label>
            <Field name="name" type="text" class="form-control" />
            <ErrorMessage name="name" class="error-feedback" />
          </div>
          <div class="form-group">
            <label for="experienceToUnlock">Experience to Unlock</label>
            <Field name="experienceToUnlock" type="text" class="form-control" />
            <ErrorMessage name="experienceToUnlock" class="error-feedback" />
          </div>
          <div class="form-group">
            <label for="conversionRate">Conversion Rate</label>
            <Field name="conversionRate" type="text" class="form-control" />
            <ErrorMessage name="conversionRate" class="error-feedback" />
          </div>
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
  </div>
</template>

<script>
import {ErrorMessage, Field, Form} from "vee-validate";
import * as yup from "yup";
import OwnerService from "@/services/owner/OwnerService";

export default {
  name: "AddFidelityProgram",
  props: {
    ownerId: {},
    companyId: {},
  },
  components: {
    Form,
    Field,
    ErrorMessage,
  },
  data() {
    const schemaPoints = yup.object().shape({
      name: yup
          .string()
          .required("Name is required!")
          .min(1, "Must be at least 3 characters!")
          .max(40, "Must be maximum 40 characters!"),
      conversionRate: yup
          .number()
          .typeError("Insert a number!")
          .positive("Conversion rate must be positive!")
          .integer("A conversion rate can't include a decimal point!")
          .required("Conversion rate is required!")
          .min(9, "Must be at least 1 digit!")
          .max(99999999999999999999, "Must be maximum 20 digits!")
    });
    const schemaLevels = yup.object().shape({
      name: yup
          .string()
          .required("Name is required!")
          .min(1, "Must be at least 3 characters!")
          .max(40, "Must be maximum 40 characters!"),
      conversionRate: yup
          .number()
          .typeError("Insert a number!")
          .positive("Conversion rate must be positive!")
          .integer("A conversion rate can't include a decimal point!")
          .required("Conversion rate is required!")
          .min(9, "Must be at least 1 digit!")
          .max(99999999999999999999, "Must be maximum 20 digits!"),
      experienceToUnlock: yup
          .number()
          .typeError("Insert a number!")
          .positive("Conversion to Unlock must be positive!")
          .integer("A conversion to unlock can't include a decimal point!")
          .required("Conversion to unlock is required!")
          .min(9, "Must be at least 1 digit!")
          .max(99999999999999999999, "Must be maximum 20 digits!"),
    });

    return {
      successful: false,
      loading: false,
      points: false,
      levels: false,
      message: "",
      show: false,
      hide: false,
      schemaPoints,
      schemaLevels
    };
  },
  computed: {
    currentOwner() {
      return this.$store.state.ownerAuth.owner;
    }
  },
  methods: {
    pushToProgramsList(){
      this.$router.push("/owner/fidelityPrograms/" + this.currentOwner.id + "/" + this.companyId);
    },
    mounted(){
      if(this.ownerId == this.currentOwner.id){
        this.show = true;
      }
    },
    addNewPointsFidelityProgram(fidelityProgram) {
      OwnerService.addPointsFidelityProgram(this.ownerId, this.companyId, fidelityProgram).then(
          () => {
            this.message = "Points Fidelity Program created and added";
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
    addNewLevelFidelityProgram(fidelityProgram) {
      OwnerService.addLevelFidelityProgram(this.ownerId, this.companyId, fidelityProgram).then(
          () => {
            this.message = "Levels Fidelity Program created and added";
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
    setTypePoints(){
      this.points = true;
      this.hide = true;
    },
    setTypeLevels(){
      this.levels = true;
      this.hide = true;
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
label {
  display: block;
  margin-top: 10px;
}
.error-feedback {
  color: red;
}
.btn {
  margin:10px 10px 10px 10px;
}
</style>