import {createApp} from 'vue'
import App from './App.vue'
import * as appRouter from './appRouter'
import storage from "./storage/index";

const app = createApp(App);
app.use(appRouter.routeConfig);
app.use(storage);
app.mount('#app')
