import React, { Component } from 'react';
//import logo from './logo.svg';

import EventDashboard from './event/EventDashboard';
import Event from './event/Event'
import SingleEvent from './event/SingleEvent'
import { Route, Switch } from 'react-router-dom'
import Header from './global/Header';
import Footer from './global/Footer';
import Login from './login/Login';
import Logout from './login/Logout';
import Role from './configuration/Role';
import Feedback from './feedback/Feedback';
import EditFeedback from './feedback/EditFeedback';
import IncorporationForm from './IncorporationForm';

class Main extends Component {
  render() {
    return (


      <div>
        <Header {...this.props} />


        <Switch>
          <Route exact path="/" render={() => (<div>
            <Login {...this.props} /></div>)} />
          <Route path="/dashboard" exact component={() => <EventDashboard {...this.props}></EventDashboard>} />
          <Route path="/events" render={() => (<div>
            <Event {...this.props} /></div>)} />
          <Route path="/login" render={() => (<div>
            <Login {...this.props} /></div>)} />
          <Route path="/logout" render={() => (<div>
            <Logout {...this.props} /></div>)} />
          <Route path="/role" render={() => (<div>
            <Role {...this.props} /></div>)} />
          <Route path="/feedback" render={() => (<div>
            <Feedback {...this.props} /></div>)} />

          <Route path="/editfeedback/:feedbackId" render={(params) => (<div>
            <EditFeedback {...this.props} {...params} /></div>)} />

          <Route path="/event/:eventId" render={(params) => (
            <SingleEvent {...this.props} {...params} />
          )} />

          <Route path="/test" render={() => (
            <IncorporationForm  />
          )} />

        </Switch>


        <Footer />
      </div>
    );
  }
}
export default Main;