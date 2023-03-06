export default function OwnerAuthHeader() {
    let owner = JSON.parse(localStorage.getItem('owner'));

    if (owner && owner.token) {
        return { Authorization: 'Bearer ' + owner.token };
    } else {
        return {};
    }
}