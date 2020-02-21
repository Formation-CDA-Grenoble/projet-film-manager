import axios from 'axios';

const USER_API_BASE_URL = 'http://localhost:8080/';

class AuthService {

    state = {
        token: null,
      };

    login(credentials){
        return axios.post(USER_API_BASE_URL + "authenticate", credentials);
    }

    getUserInfo(){
        return JSON.parse(localStorage.getItem("userInfo"));
    }

    getAuthHeader() {
        this.state.token="ok"
        console.log(this.state.token)
       return {headers: {Authorization: 'Bearer ' + this.getUserInfo().token }};
    }

    logOut() {
        localStorage.removeItem("userInfo");
        return axios.post(USER_API_BASE_URL + 'logout', {}, this.getAuthHeader());
    }
}

export default new AuthService();