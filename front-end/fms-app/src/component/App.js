import Main from './Main'
import {connect} from 'react-redux'
import { bindActionCreators } from 'redux'
import * as actions from '../action/action'
import {withRouter} from 'react-router'
function mapStateToProps(state) {

    return {
        events: state.events,
        authentication: state.authentication.authentication,
        event: state.event.event,
        summary: state.summary.summary,
        role: state.role.role,
        feedbacks: state.feedbacks,
        feedback: state.feedback.feedback

    }
}

function mapDispatchToProps(dispatch){
    return bindActionCreators(actions,dispatch)
}

const App = withRouter(connect(mapStateToProps, mapDispatchToProps)(Main))

export default App;

