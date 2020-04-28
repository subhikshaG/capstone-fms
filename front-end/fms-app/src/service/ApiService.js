import axios from 'axios';

const USER_API_BASE_URL = 'http://localhost:8083/dashboard';

class ApiService {

    fetchEvents() {
        return axios.get(USER_API_BASE_URL);
    }


}

export default new ApiService();