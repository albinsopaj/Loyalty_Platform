import axios from 'axios';

const COMPANY_API_REST_URL = "http://localhost:8080/loyaltyPlatform/company";

class APIService {
    getCompanies(){
        return axios.get(COMPANY_API_REST_URL+"/getAll");
    }
}

export default new APIService();