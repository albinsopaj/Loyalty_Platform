import { createWebHistory, createRouter } from "vue-router";
import PlatformHome from "@/components/test/PlatformHome.vue";
import PlatformLogin from "@/components/test/PlatformLogin.vue";
import PlatformRegister from "@/components/test/PlatformRegister.vue";

const Profile = () => import("@/components/test/PlatformProfile.vue")
const BoardClient = () => import("@/components/test/BoardClient.vue")

const routes = [
    {
        path: "/",
        name: "home",
        component: PlatformHome,
    },
    {
        path: "/home",
        component: PlatformHome,
    },
    {
        path: "/login",
        component: PlatformLogin,
    },
    {
        path: "/register",
        component: PlatformRegister,
    },
    {
        path: "/profile",
        name: "profile",
        // lazy-loaded
        component: Profile,
    },
    {
        path: "/client",
        name: "client",
        // lazy-loaded
        component: BoardClient,
    }
];

const router = createRouter({
    history: createWebHistory(),
    routes,
});

/*
router.beforeEach((to, from, next) => {
    const publicPages = ['/login', '/register', '/home'];
    const authRequired = !publicPages.includes(to.path);
    const loggedIn = localStorage.getItem('client');

    if (authRequired && !loggedIn) {
        next('/login');
    } else {
        next();
    }
});
*/
export default router;
