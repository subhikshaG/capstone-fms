
import { combineReducers } from 'redux'

const initialState = {
    events: [],
    event: {},
    authentication: false,
    summary: {},
    role: null,
    feedbacks: [],
    feedback: {}
};

function events(state = initialState, action) {
    switch (action.type) {

        case 'ALL_EVENTS': return {
            ...state,
            events: action.payload
        };
        default: return state
    }
}

function authentication(state = initialState, action) {
    console.log("authentication call");
    switch (action.type) {
     
        case 'AUTHENTICATED':
            return {
                ...state,
                authentication: true
            };
        case 'UNAUTHENTICATED':
            return {
                ...state,
                authentication: false
            };
        case 'GET_ERRORS':
            return action.payload;

        default:
            return state;
    }
}

function event(state = initialState, action) {
    console.log("event call");
    switch (action.type) {
     
        case 'EVENT':
            return {
                ...state,
                event: action.payload
            };
       

        default:
            return state;
    }
}

function summary(state = initialState, action) {
    console.log("summary call");
    switch (action.type) {
     
        case 'SUMMARY':
            return {
                ...state,
                summary: action.payload
            };
       

        default:
            return state;
    }
}

function role(state = initialState, action) {
    console.log("role call");
    switch (action.type) {
     
        case 'ROLE':
            return {
                ...state,
                role: "200"
            };
        case 'UNROLE':
            return {
                ...state,
                role: "500"
            };
       

        default:
            return state;
    }
}

function feedbacks(state = initialState, action) {
    switch (action.type) {

        case 'ALL_FEEDBACK': return {
            ...state,
            feedbacks: action.payload
        };
        default: return state
    }
}

function feedback(state = initialState, action) {
    switch (action.type) {

        case 'FEEDBACK': return {
            ...state,
            feedback: action.payload
        };
        default: return state
    }
}


const rootReducer = combineReducers({ events, authentication, event, summary, role, feedbacks, feedback})
export default rootReducer