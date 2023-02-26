import axios from 'axios';

const CLIENT_API_REST_URL = "http://localhost:8080/loyaltyPlatform/client";

class APIService {
    addClient(){
        return axios.get(CLIENT_API_REST_URL+"/add")
    }
    getClient(){
        return axios.get(CLIENT_API_REST_URL+"/get/{clientId}");
    }
    registerToFidelityProgram(){
        return axios.get(CLIENT_API_REST_URL+"/getCompanies/{companyId}/getFidelityPrograms/{fidelityProgramId}/registerToFidelityProgram/{clientId}");
    }
    viewDigitalCard(){
        return axios.get(CLIENT_API_REST_URL+"/{clientId}/getDigitalWallet/{digitalWalletId}/getDigitalCard/{digitalCardId}")
    }
}

export default new APIService();

