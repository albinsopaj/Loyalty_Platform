<template>
  <div class="vue-tempalte">
    <form>
      <h3>Sign In</h3>

      <div class="form-group">
        <label>Email address</label>
        <input class="form-control form-control-lg" type="email"/>
      </div>

      <div class="form-group">
        <label>Password</label>
        <input class="form-control form-control-lg" type="password"/>
      </div>

      <button class="btn btn-dark btn-lg btn-block" type="submit">Sign In</button>

      <p class="forgot-password text-right mt-2 mb-4">
        <router-link to="/forgot-password">Forgot password ?</router-link>
      </p>

      <div class="social-icons">
        <ul>
          <li><a href="#"><i class="fa fa-google"></i></a></li>
          <li><a href="#"><i class="fa fa-facebook"></i></a></li>
          <li><a href="#"><i class="fa fa-twitter"></i></a></li>
        </ul>
      </div>

    </form>
  </div>
</template>

<script>
export default {
  name: "PlatformLogin2",
  data() {
    return {}
  }
}
</script>