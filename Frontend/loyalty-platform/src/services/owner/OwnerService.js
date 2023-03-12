import axios from 'axios';
import OwnerAuthHeader from "@/services/owner/OwnerAuthHeader";

const OWNER_API_REST_URL = "http://localhost:8080/loyaltyPlatform/owner/";

class APIService {
    addCompany(ownerId, form){
        return axios.post(OWNER_API_REST_URL + "addCompany/" + ownerId, form, {headers: OwnerAuthHeader()});
    }

    modifyProfile(ownerId, form){
        return axios.put(OWNER_API_REST_URL + "update/profile/" + ownerId, form, {headers: OwnerAuthHeader()})
    }

    addPointsFidelityProgram(ownerId, companyId, form){
        return axios.post(OWNER_API_REST_URL + "addPointsFidelityProgram/" + ownerId + "/" + companyId, form, {headers: OwnerAuthHeader()})
    }

    addLevelFidelityProgram(ownerId, companyId, form){
        return axios.post(OWNER_API_REST_URL + "addLevelFidelityProgram/" + ownerId + "/" + companyId, form, {headers: OwnerAuthHeader()})
    }

    getCompany(ownerId, companyId){
        return axios.get(OWNER_API_REST_URL + "company/" + ownerId + "/" + companyId, {headers: OwnerAuthHeader()})
    }

    getOwner(ownerId){
        return axios.get(OWNER_API_REST_URL + "get/" + ownerId, {headers: OwnerAuthHeader()})
    }

    getCompanies(ownerId){
        return axios.get(OWNER_API_REST_URL + "companies/" + ownerId, {headers: OwnerAuthHeader()})
    }
}

export default new APIService();