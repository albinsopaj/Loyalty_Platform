import axios from "axios";
import ClientAuthHeader from "@/services/client/ClientAuthHeader";

const API_URL = 'http://localhost:8080/api/test/';

class TestService {
    getPublicContent() {
        return axios.get(API_URL + 'all');
    }

    getClientBoard() {
        return axios.get(API_URL + 'client', { headers: ClientAuthHeader() });
    }
}

export default new TestService();
