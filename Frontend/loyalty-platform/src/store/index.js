import { createStore } from "vuex";
import {auth} from "@/store/AuthModule";


const store = createStore({
    modules: {
        auth,
    },
});

export default store;
