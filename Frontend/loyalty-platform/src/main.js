import { createApp } from "vue";
import "bootstrap";
import "bootstrap/dist/css/bootstrap.min.css";
import store from "@/store";
import App from "@/App.vue";
import router from "../router/router";


createApp(App)
    .use(router)
    .use(store)
    .mount("#app");
