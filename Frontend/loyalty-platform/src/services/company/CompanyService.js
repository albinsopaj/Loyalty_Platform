import axios from 'axios';
import OwnerAuthHeader from "@/services/owner/OwnerAuthHeader";

const COMPANY_API_REST_URL = "http://localhost:8080/loyaltyPlatform/company/";

class APIService {
    getCompanies(){
        return axios.get(COMPANY_API_REST_URL + "getAll", { headers: OwnerAuthHeader() });
    }
    getFidelityPrograms(companyId){
        return axios.get(COMPANY_API_REST_URL + "getFidelityPrograms/" + companyId, { headers: OwnerAuthHeader() });
    }
}

export default new APIService();