import {jwtDecrypt} from "@/shared/jwtHelper";

const state = () =>({
    data:{
        token: '',
        refreshToken: '',
        email:'',
        userId: '',
        exp: ''
    },
    loginApiStatus: ''
});

const getters = {
    getLoginApiStatus(state){
        return state.loginApiStatus;
    }
};

const actions = {
    async login({commit}, payload){
        console.log(payload)
        const data = {
            access_token : "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c",
            refresh_token: ''
        };
        commit('setData', data);
        commit('setLoginApiStatus', 'success');
    }
};

const mutations = {
    setData(state, data){
        const decryptedAuth = jwtDecrypt(data.access_token);
        console.log(decryptedAuth);
        localStorage.setItem('access_token', data.access_token);
        localStorage.setItem('refresh_token', data.refresh_token);
        const newData ={
            token: data.access_token,
            refreshToken: data.refresh_token,
            email: decryptedAuth.email,
            userId: decryptedAuth.sub,
            exp: decryptedAuth.exp
        };
        state.data = newData;
    },
    setLoginApiStatus(state, data){
        state.loginApiStatus = data;
    }
};

export default{
    namespaced:true,
    state,
    getters,
    actions,
    mutations
}