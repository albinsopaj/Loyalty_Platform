import {createRouter, createWebHistory} from "vue-router";
// import PlatformHome from "@/components/test/PlatformHome.vue";
import PlatformClientLogin from "@/components/test/PlatformClientLogin.vue";
import PlatformClientRegister from "@/components/test/PlatformClientRegister.vue";
import PlatformOwnerLogin from "@/components/test/PlatformOwnerLogin.vue";
import PlatformOwnerRegister from "@/components/test/PlatformOwnerRegister.vue";
import AddCompany from "@/components/test/AddCompany.vue";
import ModifyProfile from "@/components/test/ModifyProfile.vue";
import OwnerCompanies from "@/components/test/OwnerCompanies.vue";
import AddFidelityProgram from "@/components/test/AddFidelityProgram.vue";
import PlatformHome from "@/components/test/PlatformHome.vue";

const ClientProfile = () =>
    import("@/components/test/PlatformClientProfile.vue");
const OwnerProfile = () => import("@/components/test/PlatformOwnerProfile.vue");
const BoardClient = () => import("@/components/test/BoardClient.vue");
const BoardOwner = () => import("@/components/test/BoardOwner.vue");
const routes = [
  {
    path: "/",
    name: "home",
    component: PlatformHome.vue,
  },
  {
    path: "/home",
    component: PlatformHome.vue,
  },
  {
    path: "/client/login",
    component: PlatformClientLogin,
  },
  {
    path: "/owner/login",
    component: PlatformOwnerLogin,
  },
  {
    path: "/client/register",
    component: PlatformClientRegister,
  },
  {
    path: "/owner/register",
    component: PlatformOwnerRegister,
  },
  {
    path: "/owner/addCompany",
    component: AddCompany,
  },
  {
    path: "/profile/modify",
    component: ModifyProfile,
  },
  {
    path: "/owner/companies",
    component: OwnerCompanies,
  },
  {
    path: "/owner/addFidelityProgram/:ownerId/:companyId",
    component: AddFidelityProgram,
    props: true,
  },
  {
    path: "/client/profile",
    name: "clientProfile",
    // lazy-loaded
    component: ClientProfile,
  },
  {
    path: "/owner/profile",
    name: "ownerProfile",
    // lazy-loaded
    component: OwnerProfile,
  },
  {
    path: "/client",
    name: "client",
    // lazy-loaded
    component: BoardClient,
  },
  {
    path: "/owner",
    name: "owner",
    // lazy-loaded
    component: BoardOwner,
  },
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
