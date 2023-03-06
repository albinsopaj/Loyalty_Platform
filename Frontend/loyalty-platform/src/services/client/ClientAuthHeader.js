export default function ClientAuthHeader() {
    let client = JSON.parse(localStorage.getItem('client'));

    if (client && client.token) {
        return { Authorization: 'Bearer ' + client.token };
    } else {
        return {};
    }
}
