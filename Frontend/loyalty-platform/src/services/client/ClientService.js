import axios from 'axios';

const CLIENT_API_REST_URL = "http://localhost:8080/loyaltyPlatform/client/";

class APIService {

    modifyProfile(clientId, form){
        return axios.put(CLIENT_API_REST_URL + "update/profile/" + clientId, form)
    }

    getClient(clientId){
        return axios.get(CLIENT_API_REST_URL + "get/" + clientId)
    }

    registerToFidelityProgram(clientId, fidelityProgramId){
        return axios.put(CLIENT_API_REST_URL + "registerToFidelityProgram/" + clientId + "/" + fidelityProgramId)
    }

    getDigitalCards(clientId){
        return axios.get(CLIENT_API_REST_URL + "getDigitalCards/" + clientId)
    }
}

export default new APIService();