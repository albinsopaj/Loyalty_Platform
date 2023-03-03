<template>
  <div class="vue-tempalte">
    <form>
      <h3>Sign Up</h3>

      <div class="form-group">
        <label>Full Name</label>
        <input class="form-control form-control-lg" type="text"/>
      </div>

      <div class="form-group">
        <label>Email address</label>
        <input class="form-control form-control-lg" type="email"/>
      </div>

      <div class="form-group">
        <label>Password</label>
        <input class="form-control form-control-lg" type="password"/>
      </div>

      <button class="btn btn-dark btn-lg btn-block" type="submit">Sign Up</button>

      <p class="forgot-password text-right">
        Already registered
        <router-link :to="{name: 'login'}">sign in?</router-link>
      </p>
    </form>
  </div>
</template>

<script>
export default {
  data() {
    return {}
  }
}
</script>