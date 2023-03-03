import {createRouter, createWebHistory} from 'vue-router';
import PlatformHome from "@/components/PlatformHome.vue";
import PlatformLogin from "@/components/PlatformLogin.vue";

const routes = [
    {path:'/', component:PlatformHome},
    {path:'/login', component:PlatformLogin}
];

export const routeConfig = createRouter({
    history: createWebHistory(),
    routes:routes
})