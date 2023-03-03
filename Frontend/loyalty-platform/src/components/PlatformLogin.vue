<template>
  <div>
    <h4>Login Form</h4>
    <form>
      <div class="mb-3">
        <label for="txtEmail" class="form-label">Email</label>
        <input type="text" class="form-control" id="txtEmail" placeholder="Enter Email" v-model="email">
      </div>
      <div class="mb-3">
        <label for="txtPassword" class="form-label">Another label</label>
        <input type="password" class="form-control" id="txtPassword" placeholder="Enter Password" v-model="password">
      </div>
      <button type="button" @click="login()" class="bnt btn-primary">Login</button>
    </form>
  </div>
</template>

<script>
import {mapActions, mapGetters} from "vuex";

export default {
  name: "PlatformLogin",
  data(){
    return {
      email: '',
      password: ''
    }
  },
  computer:{
    ...mapGetters('auth',{
      gettersLoginApiStatus: 'getLoginApiStatus'
    })
  },
  methods: {
    ...mapActions('auth',{
      actionLogin: 'login'
    }),
    async login(){
      console.log(this.email, this.password);
      await this.actionLogin({email: this.email, password: this.password});
      if(this.gettersLoginApiStatus === 'success'){
        alert('login success');
      } else {
        alert('failed to login')
      }
    }
  }
}
</script>

<style scoped>

</style>