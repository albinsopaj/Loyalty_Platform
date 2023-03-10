<template>
  <!-- Footer -->
  <MDBFooter :text="['center', 'lg-start', 'muted']" bg="dark">
    <!-- Section: Social media -->
    <section class="justify-content-lg-between p-4">
      <MDBContainer class="">
        <!-- Grid row -->
        <MDBRow class="mt-0">
          <!-- Grid column -->
          <MDBCol
              class="mx-auto mb-4"
              lg="4"
              md="3"
              style="
              margin-top: 25px;
              justify-items: flex-end;
              vertical-align: text-bottom;
            "
              xl="3"
          >
            <!-- Content -->
            <h6 class="text-uppercase fw-bold mb-4">
              <i class="fas fa-gem me-3 link-secondary"></i>Loyalty Platform
            </h6>
            <p>
              Lorem ipsum dolor sit, amet consectetur adipisicing elit. Placeat
              pariatur molestiae doloremque tempora labore perspiciatis.
              Deleniti quas id odio explicabo fugiat quos consequuntur ipsa,
              dolor natus cum voluptas sequi eveniet.
            </p>
          </MDBCol>
          <!-- Grid column -->

          <!-- Grid column -->
          <MDBCol
              class="mx-auto mb-4"
              lg="2"
              md="2"
              style="margin-top: 25px"
              xl="2"
          >
            <!-- Links -->
            <h6 class="text-uppercase fw-bold mb-4">About</h6>
            <p>
              <a class="text-reset" href="#!">How it works</a>
            </p>
            <p>
              <a class="text-reset" href="#!">Our Programs</a>
            </p>
            <p>
              <a class="text-reset" href="#!">Promotions</a>
            </p>
            <p>
              <a class="text-reset" href="#!">Refer a friend</a>
            </p>
          </MDBCol>
          <!-- Grid column -->

          <!-- Grid column -->
          <MDBCol
              class="mx-auto mb-4"
              lg="2"
              md="3"
              style="margin-top: 25px"
              xl="2"
          >
            <!-- Links -->
            <h6 class="text-uppercase fw-bold mb-4">Useful links</h6>
            <p>
              <a class="text-reset" href="">Pricing</a>
            </p>
            <p>
              <a class="text-reset" href="#!">Settings</a>
            </p>
            <p>
              <a class="text-reset" href="#!">Orders</a>
            </p>
            <p>
              <a class="text-reset" href="#!">Help</a>
            </p>
          </MDBCol>
          <!-- Grid column -->

          <!-- Grid column -->
          <MDBCol
              class="mx-auto"
              lg="3"
              style="margin-top: 25px; margin-bottom: 25px"
              xl="3"
          >
            <!-- Links -->
            <h6 class="text-uppercase fw-bold mb-4">Contact</h6>
            <p>New York, NY 10012, US</p>
            <p>info@example.com</p>
            <p>+ 01 234 567 88</p>
            <p>+ 01 234 567 89</p>
          </MDBCol>
          <!-- Grid column -->
        </MDBRow>
        <!-- Grid row -->
        <div class="text-center p-4">
          © 2023 Copyright:
          <a class="text-reset" href="">Loyalty Program</a>
        </div>
      </MDBContainer>
    </section>
  </MDBFooter>
  <!-- Footer -->
</template>
<script>
import {MDBCol, MDBContainer, MDBFooter, MDBRow} from "mdb-vue-ui-kit";

export default {
  components: {
    MDBFooter,
    MDBRow,
    MDBCol,
    MDBContainer,
  },
};
</script>
