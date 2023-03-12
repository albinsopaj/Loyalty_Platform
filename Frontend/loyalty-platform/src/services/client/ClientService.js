import axios from 'axios';
import ClientAuthHeader from "@/services/client/ClientAuthHeader";

const CLIENT_API_REST_URL = "http://localhost:8080/loyaltyPlatform/client/";

class APIService {

    modifyProfile(clientId, form){
        return axios.put(CLIENT_API_REST_URL + "update/profile/" + clientId, form, { headers: ClientAuthHeader() })
    }

    getClient(clientId){
        return axios.get(CLIENT_API_REST_URL + "get/" + clientId, { headers: ClientAuthHeader() })
    }

    registerToFidelityProgram(clientId, fidelityProgramId){
        return axios.put(CLIENT_API_REST_URL + "registerToFidelityProgram/" + clientId + "/" + fidelityProgramId, "", { headers: ClientAuthHeader() })
    }

    getDigitalCards(clientId){
        return axios.get(CLIENT_API_REST_URL + "getDigitalCards/" + clientId, { headers: ClientAuthHeader() })
    }
}

export default new APIService();