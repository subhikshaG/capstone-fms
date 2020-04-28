import React, { Component } from 'react'
import { NavLink, Link } from 'react-router-dom';
class Header extends Component {


    constructor(props) {
        super(props);
        console.log("my log constructor" + this.props.authentication)


    }
    render() {
        const isAuthenticated = this.props.authentication
        console.log("header");
        console.log("my log" + this.props.authentication)
        return (

            <div>
                <nav className="navbar navbar-expand-lg navbar-dark bg-primary ">
                    <a className="navbar-brand" href="#"><span className="font-weight-bold">Outreach FMS</span></a>
                    <button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
                        <span className="navbar-toggler-icon"></span>
                    </button>
                    <div className="collapse navbar-collapse" id="navbarNavDropdown">

                        {isAuthenticated
                            ?

                            <div>
                                <ul className="navbar-nav">
                                    <li className="nav-item">
                                        <NavLink className="nav-link" to="/dashboard" exact>Dashboard</NavLink>
                                    </li>
                                    <li className="nav-item">
                                        <NavLink className="nav-link" to="/events" exact>Events</NavLink>
                                    </li>
                                    <li className="nav-item dropdown">
                                        <NavLink className="nav-link dropdown-toggle" to="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                            Configuration
                                        </NavLink>
                                        <div className="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                                            <Link className="dropdown-item" to="/role">Role</Link>
                                            <Link className="dropdown-item" to="/feedback">Feedback</Link>
                                        </div>
                                    </li>
                                    <li className="nav-item">
                                        <NavLink className="nav-link" to="/logout" exact>Logout</NavLink>
                                    </li>
                                </ul>
                            </div> :
                            <div>
                                <ul className="navbar-nav">
                                    <li className="nav-item ">
                                        <NavLink className="nav-link" to="/login" exact>Login</NavLink>
                                    </li>

                                </ul>
                            </div>}

                    </div>
                </nav>

            </div>
        );
    }

}
export default Header;
