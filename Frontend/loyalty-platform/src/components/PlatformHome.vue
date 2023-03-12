<template>
  <div class="main-content">
    <div class="container">
      <div class="home-page">
        <div class="section-container header-container">
          <div class="row align-items-center">
            <div class="col-md-6">
              <h1 class="mb-1">
                Turn first-time customers into forever customers with the
                world's most trusted loyalty app
              </h1>
              <div
                class="body-large mb-1_5"
                style="
                  font-family: inherit;
                  font-size: 18px;
                  font-weight: 400;
                  line-height: 27px;
                "
              >
                Over 125 million shoppers earn points through Smile. Give the
                people what they love.
              </div>
              <div class="d-flex align-items-center flex-wrap">
                <a href="" class="btn btn-primary contact-btn"
                  >Start building customer loyalty</a
                >
              </div>
            </div>
            <div class="col-md-6 header-image d-none d-md-block">
              <img
                alt="Engaged customer community sharing rewards and love with a loyalty program"
                src="https://website-assets.smilecdn.co/assets/home/hero-2-2030048081739b943dded2de8b6d09247c88398754d92e113629c378df634823.svg"
              />
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import TestService from "@/services/TestService";

export default {
  name: "PlatformHome",
  data() {
    return {
      content: "",
    };
  },
  mounted() {
    TestService.getPublicContent().then(
      (response) => {
        this.content = response.data;
      },
      (error) => {
        this.content =
          (error.response &&
            error.response.data &&
            error.response.data.message) ||
          error.message ||
          error.toString();
      }
    );
  },
};
</script>
<style>
.container {
  display: flex;
}

img {
  vertical-align: middle;
  border-style: none;
  margin-bottom: -1px;
  vertical-align: baseline;
  max-width: 100%;
}

.col-md-6 {
  width: 100%;
  min-height: 1px;
  padding-right: 15px;
  padding-left: 15px;

  flex: 0 0 50%;
  max-width: 50%;

  margin-bottom: 2rem;
}

.header-image {
  top: -3.5rem;
  right: 0rem;
}
</style>
