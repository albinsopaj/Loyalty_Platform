import { createStore } from "vuex";
import {clientAuth, ownerAuth} from "@/store/AuthModule";


const store = createStore({
    modules: {
        clientAuth,
        ownerAuth
    },
});

export default store;
