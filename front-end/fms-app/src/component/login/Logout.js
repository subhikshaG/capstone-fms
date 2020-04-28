import React, { Component } from 'react';

class Logout extends Component {
  componentWillMount() {
    this.props.logOutAction();
  }

  render() {
    return <div className="centered-container">
    <p>Logged out succesfully</p>
    </div>
  }
}

export default Logout;