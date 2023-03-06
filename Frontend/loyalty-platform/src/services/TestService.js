import axios from "axios";
import ClientAuthHeader from "@/services/client/ClientAuthHeader";
import OwnerAuthHeader from "@/services/owner/OwnerAuthHeader";

const API_URL = 'http://localhost:8080/api/test/';

class TestService {
    getPublicContent() {
        return axios.get(API_URL + 'all');
    }

    getClientBoard() {
        return axios.get(API_URL + 'client', { headers: ClientAuthHeader() });
    }

    getOwnerBoard() {
        return axios.get(API_URL + 'owner', { headers: OwnerAuthHeader() });
    }
}

export default new TestService();
