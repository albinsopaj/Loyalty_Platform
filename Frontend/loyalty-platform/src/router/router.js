import {createRouter, createWebHistory} from "vue-router";
import PlatformHome from "@/components/PlatformHome.vue";
import PlatformClientLogin from "@/components/PlatformClientLogin.vue";
import PlatformClientRegister from "@/components/PlatformClientRegister.vue";
import PlatformOwnerLogin from "@/components/PlatformOwnerLogin.vue";
import PlatformOwnerRegister from "@/components/PlatformOwnerRegister.vue";
import AddCompany from "@/components/AddCompany.vue";
import ModifyProfile from "@/components/ModifyProfile.vue";
import OwnerCompanies from "@/components/OwnerCompanies.vue";
import AddFidelityProgram from "@/components/AddFidelityProgram.vue";
import CompanyFidelityPrograms from "@/components/CompanyFidelityPrograms.vue";
import PlatformCompanies from "@/components/PlatformCompanies.vue";
import ClientDigitalWallet from "@/components/ClientDigitalWallet.vue";

const ClientProfile = () => import("@/components/PlatformClientProfile.vue")
const OwnerProfile = () => import("@/components/PlatformOwnerProfile.vue")
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
    path: "/digitalWallet/:clientId",
    component: ClientDigitalWallet,
    props: true
  },
  {
    path: "/companies",
    component: PlatformCompanies
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
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;