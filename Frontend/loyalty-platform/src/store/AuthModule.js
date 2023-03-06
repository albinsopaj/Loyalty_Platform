import ClientAuthService from "@/services/client/ClientAuthService";
import OwnerAuthService from "@/services/owner/OwnerAuthService";

const client = JSON.parse(localStorage.getItem('client'));
const owner = JSON.parse(localStorage.getItem('owner'));
const initialClientState = client
    ? { status: { loggedIn: true }, client }
    : { status: { loggedIn: false }, client: null };
const initialOwnerState = owner
    ? { status: { loggedIn: true }, owner }
    : { status: { loggedIn: false }, owner: null };

export const clientAuth = {
    namespaced: true,
    state: initialClientState,
    actions: {
        login({ commit }, client) {
            return ClientAuthService.login(client).then(
                client => {
                    commit('loginSuccess', client);
                    return Promise.resolve(client);
                },
                error => {
                    commit('loginFailure');
                    return Promise.reject(error);
                }
            );
        },
        logout({ commit }) {
            ClientAuthService.logout();
            commit('logout');
        },
        register({ commit }, client) {
            return ClientAuthService.register(client).then(
                response => {
                    commit('registerSuccess');
                    return Promise.resolve(response.data);
                },
                error => {
                    commit('registerFailure');
                    return Promise.reject(error);
                }
            );
        }
    },
    mutations: {
        loginSuccess(state, client) {
            state.status.loggedIn = true;
            state.client = client;
        },
        loginFailure(state) {
            state.status.loggedIn = false;
            state.client = null;
        },
        logout(state) {
            state.status.loggedIn = false;
            state.client = null;
        },
        registerSuccess(state) {
            state.status.loggedIn = false;
        },
        registerFailure(state) {
            state.status.loggedIn = false;
        }
    }
};

export const ownerAuth = {
    namespaced: true,
    state: initialOwnerState,
    actions: {
        login({ commit }, owner) {
            return OwnerAuthService.login(owner).then(
                owner => {
                    commit('loginSuccess', owner);
                    return Promise.resolve(owner);
                },
                error => {
                    commit('loginFailure');
                    return Promise.reject(error);
                }
            );
        },
        logout({ commit }) {
            OwnerAuthService.logout();
            commit('logout');
        },
        register({ commit }, owner) {
            return OwnerAuthService.register(owner).then(
                response => {
                    commit('registerSuccess');
                    return Promise.resolve(response.data);
                },
                error => {
                    commit('registerFailure');
                    return Promise.reject(error);
                }
            );
        }
    },
    mutations: {
        loginSuccess(state, owner) {
            state.status.loggedIn = true;
            state.owner = owner;
        },
        loginFailure(state) {
            state.status.loggedIn = false;
            state.owner = null;
        },
        logout(state) {
            state.status.loggedIn = false;
            state.owner = null;
        },
        registerSuccess(state) {
            state.status.loggedIn = false;
        },
        registerFailure(state) {
            state.status.loggedIn = false;
        }
    }
};
