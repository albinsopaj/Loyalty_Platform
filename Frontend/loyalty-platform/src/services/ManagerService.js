import axios from 'axios';

const MANAGER_API_REST_URL = "http://localhost:8080/loyaltyPlatform/manager";

class APIService {
    registerClientToFidelityProgram(){
        return axios.get(MANAGER_API_REST_URL+"/{managerId}/getFidelityPrograms/addClientToFidelityProgram/{clientId}/{fidelityProgramId}");
    }
    removeClient(){
        return axios.get(MANAGER_API_REST_URL+"/removeClientFromFidelityProgram/{managerId}/{clientId}/{fidelityProgramId}")
    }
}

export default new APIService();