import axios from 'axios';

const API_URL = 'http://localhost:8081/trains';

export default {
    getTrains() {
        return axios.get(API_URL);
    },
    addTrain(train) {
        return axios.post(API_URL, train);
    },
    updateTrain(train) {
        return axios.put(API_URL, train);
    },
    deleteTrain(id) {
        return axios.delete(`${API_URL}/${id}`);
    },
};
