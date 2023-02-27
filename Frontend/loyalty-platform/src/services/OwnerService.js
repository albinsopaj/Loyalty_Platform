import axios from 'axios';

const OWNER_API_REST_URL = "http://localhost:8080/loyaltyPlatform/owner";

class APIService {
    addCompany(){
        return axios.get(OWNER_API_REST_URL+"/addCompany/{ownerId}")
    }
    addCampaign() {
        return axios.get(OWNER_API_REST_URL+"/addCampaign/{ownerId}/{companyId}")
    }
    addManager() {
    return axios.get(OWNER_API_REST_URL+"/addManager/{ownerId}/{companyId}")
    }
    addPointsFidelityProgram() {
    return axios.get(OWNER_API_REST_URL+"/addPointsFidelityProgram/{ownerId}/{companyId}")
    }
    addPointsReward() {
    return axios.get(OWNER_API_REST_URL+"/addPointsReward/{ownerId}/{companyId}/{pointsFidelityProgramId}")
    }
    addLevelFidelityProgram() {
    return axios.get(OWNER_API_REST_URL+"/addLevelFidelityProgram/{ownerId}/{companyId}")
    }
    addFidelityLevel() {
    return axios.get(OWNER_API_REST_URL+"/addFidelityLevel/{ownerId}/{companyId}/{levelFidelityProgramId}")
    }
    addCashier() {
    return axios.get(OWNER_API_REST_URL+"/addCashier/{ownerId}/{companyId}")
    }
}

export default new APIService();