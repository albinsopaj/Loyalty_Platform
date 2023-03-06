import axios from "axios";

const API_URL = 'http://localhost:8080/api/auth/owner/'

class OwnerAuthService {
    login(owner) {
        return axios
            .post(API_URL + 'signin', {
                username: owner.username,
                password: owner.password
            })
            .then(response => {
                if (response.data.token) {
                    localStorage.setItem('owner', JSON.stringify(response.data));
                }

                return response.data;
            });
    }

    logout() {
        localStorage.removeItem('owner');
    }

    register(owner) {
        return axios.post(API_URL + 'signup', {
            firstName: owner.firstName,
            lastName: owner.lastName,
            email: owner.email,
            phoneNumber: owner.phoneNumber,
            biologicalGender: owner.biologicalGender,
            domicile: owner.domicile,
            username: owner.username,
            password: owner.password
        });
    }
}

export default new OwnerAuthService();