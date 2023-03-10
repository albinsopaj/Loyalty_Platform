import axios from 'axios';

const OWNER_API_REST_URL = "http://localhost:8080/loyaltyPlatform/user/";

class APIService {
    getUser (userId){
        return axios.get(OWNER_API_REST_URL + "get/" + userId)
    }
}

export default new APIService();