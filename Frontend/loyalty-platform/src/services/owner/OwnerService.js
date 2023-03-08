import axios from 'axios';

const OWNER_API_REST_URL = "http://localhost:8080/loyaltyPlatform/owner/";

class APIService {
    addCompany(ownerId, form){
        return axios.post(OWNER_API_REST_URL + "addCompany/" + ownerId, form);
    }

    modifyProfile(ownerId, form){
        return axios.put(OWNER_API_REST_URL + "update/profile/" + ownerId, form)
    }

    addPointsFidelityProgram(ownerId, companyId, form){
        return axios.post(OWNER_API_REST_URL + "addPointsFidelityProgram/" + ownerId +"/" + companyId, form)
    }
}

export default new APIService();