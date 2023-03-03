import { createStore } from "vuex";
import authentication from "@/storage/authentication";

const storage = createStore({
    modules:{
        auth: authentication
    }
});

export default  storage;