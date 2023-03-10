import {createRouter, createWebHistory} from "vue-router";
import PlatformHome from "@/components/test/PlatformHome.vue";
import PlatformClientLogin from "@/components/test/PlatformClientLogin.vue";
import PlatformClientRegister from "@/components/test/PlatformClientRegister.vue";
import PlatformOwnerLogin from "@/components/test/PlatformOwnerLogin.vue";
import PlatformOwnerRegister from "@/components/test/PlatformOwnerRegister.vue";
import AddCompany from "@/components/test/AddCompany.vue";
import ModifyProfile from "@/components/test/ModifyProfile.vue";
import OwnerCompanies from "@/components/test/OwnerCompanies.vue";
import AddFidelityProgram from "@/components/test/AddFidelityProgram.vue";
import CompanyFidelityPrograms from "@/components/test/CompanyFidelityPrograms.vue";

const ClientProfile = () => import("@/components/test/PlatformClientProfile.vue")
const OwnerProfile = () => import("@/components/test/PlatformOwnerProfile.vue")
const BoardClient = () => import("@/components/test/BoardClient.vue")
const BoardOwner = () => import("@/components/test/BoardOwner.vue")
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
    path: "/profile/modify/:userId",
    component: ModifyProfile,
    props: true
  },
  {
    path: "/owner/companies/:ownerId",
    component: OwnerCompanies,
    props: true
  },
  {
    path: "/owner/addFidelityProgram/:ownerId/:companyId",
    component: AddFidelityProgram,
    props: true
  },
  {
    path: "/owner/fidelityPrograms/:ownerId/:companyId",
    component: CompanyFidelityPrograms,
    props: true,
  },
  {
    path: "/client/profile/:clientId",
    name: "clientProfile",
    // lazy-loaded
    component: ClientProfile,
    props: true
  },
  {
    path: "/owner/profile/:ownerId",
    name: "ownerProfile",
    // lazy-loaded
    component: OwnerProfile,
    props: true
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