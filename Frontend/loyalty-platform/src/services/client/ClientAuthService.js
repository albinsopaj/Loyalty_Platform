import axios from "axios";

const API_URL = 'http://localhost:8080/api/auth/client/'

class ClientAuthService {
    login(client) {
        return axios
            .post(API_URL + 'signin', {
                username: client.username,
                password: client.password
            })
            .then(response => {
                if (response.data.token) {
                    localStorage.setItem('client', JSON.stringify(response.data));
                }

                return response.data;
            });
    }

    logout() {
        localStorage.removeItem('client');
    }

    register(client) {
        return axios.post(API_URL + 'signup', {
            firstName: client.firstName,
            lastName: client.lastName,
            email: client.email,
            phoneNumber: client.phoneNumber,
            biologicalGender: client.biologicalGender,
            domicile: client.domicile,
            username: client.username,
            password: client.password
        });
    }
}

export default new ClientAuthService();
