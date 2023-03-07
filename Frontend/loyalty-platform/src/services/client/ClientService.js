import axios from 'axios';

const OWNER_API_REST_URL = "http://localhost:8080/loyaltyPlatform/client/";

class APIService {

    modifyProfile(clientId, form){
        return axios.put(OWNER_API_REST_URL + "update/profile/" + clientId, form)
    }
}

export default new APIService();