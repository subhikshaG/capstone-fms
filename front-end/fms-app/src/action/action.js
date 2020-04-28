import jwt_decode from 'jwt-decode'
import axios from "axios";
import setJwt from '../security/setJwt';

export const getEvents = () => async dispatch => {
    const tokenLocal = localStorage.getItem("jwtToken");
    console.log("my events token" + tokenLocal)

    const res = await axios.get("http://localhost:8083/events", {
        headers: {
            "Content-Type": "application/json",
            "Authorization": `Bearer ${tokenLocal}`
        }
    });
    dispatch({
        type: 'ALL_EVENTS',
        payload: res.data
    });
};


export const getEvent = (id) => async dispatch => {

    console.log("my events by id")

    const res = await axios.get(`http://localhost:8083/event/${id}`);
    dispatch({
        type: 'EVENT',
        payload: res.data
    });
};

export const getSummary = (id) => async dispatch => {

    console.log("my summary by id")

    const res = await axios.get(`http://localhost:8083/summary/${id}`);
    dispatch({
        type: 'SUMMARY',
        payload: res.data
    });
};
export const login = (LoginRequest, history) => async dispatch => {

    try {
        // post => Login Request
        const res = await axios.post("http://localhost:8082/auth/signin", LoginRequest);
        // extract token from res.data
        const token = res.data.token;
        // store the token in the localStorage
        localStorage.setItem("jwtToken", token);
        // set our token in header ***
        console.log("here" + res.data.token);
        //setJwt(token);
        // decode token on React
        const decoded = jwt_decode(token);

        console.log("my decoded is user" + decoded.sub)
        console.log("my decoded is role" + decoded.userAuthorities[0].authority)

        localStorage.setItem("user", decoded.sub)
        localStorage.setItem("role", decoded.userAuthorities[0].authority)

        dispatch({
            type: 'AUTHENTICATED'
        });

        history.push("/dashboard")
        // dispatch to our securityReducer

    } catch (err) {
        dispatch({
            type: 'GET_ERRORS',
            payload: err
        });
    }
};


export function logOutAction() {
    localStorage.clear();
    return { type: 'UNAUTHENTICATED' };

}

export const configureRole = (id, role) => async dispatch => {
    try {
        console.log("configue role")
        const tokenLocalUser = localStorage.getItem("jwtToken");

        const res = await axios.put(`http://localhost:8082/configure/${id}/${role}`, {
            headers: {
                "Content-Type": "application/json",
                "Authorization": `Bearer ${tokenLocalUser}`
            }
        });
        dispatch({
            type: 'ROLE',
            payload: res.status
        });
    } catch (err) {
        dispatch({
            type: 'UNROLE',
            payload: "500"
        });
    }

};

export const getFeedback = () => async dispatch => {

    const res = await axios.get("http://localhost:8084/event/feedback");
    dispatch({
        type: 'ALL_FEEDBACK',
        payload: res.data
    });
};

export const getFeedbackById = (feedbackId) => async dispatch => {

    const res = await axios.get(`http://localhost:8084/event/feedbackDashboard/${feedbackId}`);
    dispatch({
        type: 'FEEDBACK',
        payload: res.data
    });
};

export const updateFeedback = (editedFeedback, history) => async dispatch => {
    const res = await axios.put("http://localhost:8084/event/feedback", editedFeedback);
    history.push("/feedback")

};

export const addFeedback = (addFeedback, history) => async dispatch => {
    const res = await axios.post("http://localhost:8084/event/feedback", addFeedback);
    history.push("/feedback")

};

export const updateAnswerFeedback = (updateAnswer,feedbackId) => async dispatch => {
    const res = await axios.put(`http://localhost:8084/event/feedbackPreAnswer/${feedbackId}`, updateAnswer);


};