import axios from 'axios';

const CASHIER_API_REST_URL = "http://localhost:8080/loyaltyPlatform/cashier";

class APIService {
    updatePointsDigitalCardStatus(){
        return axios.get(CASHIER_API_REST_URL+"/{cashierId}/updatePointsDigitalCardStatus/{digitalCardId}");
    }
    removeClient(){
        return axios.get(CASHIER_API_REST_URL+"/removeClientFromFidelityProgram/{managerId}/{clientId}/{fidelityProgramId}")
    }
    redeemReward(){
        return axios.get(CASHIER_API_REST_URL+"/redeemReward/{cashierId}/{pointsDigitalCardId}")
    }
}

export default new APIService();