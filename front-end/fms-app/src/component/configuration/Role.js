import React from 'react';


class Role extends React.Component {
    constructor(props) {
        super(props);

        // reset login status
        // this.props.logout();

        this.state = {
            username: '',
            submitted: false

        };

        this.handleChange = this.handleChange.bind(this);
        this.handleAddPMO = this.handleAddPMO.bind(this);
        this.handleRemovePMO = this.handleRemovePMO.bind(this);
    }

    handleChange(e) {
        const { name, value } = e.target;
        console.log("my state is" + e.target);
        console.log("my name is" + name + "value" + value)
        this.setState({ [name]: value });
    }

    // handleSubmit(e) {
    //     e.preventDefault();

    //     this.setState({ submitted: true });
    //     const { username, password } = this.state;
    //     if (username && password) {
    //         const LoginRequest = {
    //             username: this.state.username,
    //             password: this.state.password
    //           };

    //         this.props.login(LoginRequest,this.props.history);
    //        console.log("hi");
    //     }
    // }

    handleAddPMO(e) {
        e.preventDefault();
        this.setState({ submitted: true });
        console.log("my user" + this.state.username)
        console.log('The link was clicked. add');
        if (this.state.username !== '') {
            this.props.configureRole(this.state.username, "PMO")
        }

    }

    handleRemovePMO(e) {
        e.preventDefault();
        this.setState({ submitted: true });
        console.log("my user" + this.state.username)
        console.log('The link was clicked. remove');
        if (this.state.username !== '') {
            this.props.configureRole(this.state.username, "USER")
        }

    }
    componentDidMount() {
        console.log("mount - role");

    }



    render() {
        // const { loggingIn } = this.props;
        const role = this.props.role
        const { username, submitted } = this.state;
        console.log("my role" + role)
        return (
            <React.Fragment>
                {role === '200' ? <div className="alert alert-success" >Successfully change role</div> : <div></div>}
                {role === '500' ? <div className="alert alert-danger" >User does not exist or it is the existing role</div> : <div></div>}
                <div className="col-md-6 col-md-offset-3">
                    <h2>Role Configuration</h2>
                    <form name="form">
                        <div className="form-group">
                            <label htmlFor="username">Employee ID</label>
                            <input type="text" className="form-control" id="username" name="username" value={username} onChange={this.handleChange} />
                            {submitted && !username &&
                                <div className="help-block">Employee id is required</div>
                            }
                        </div>

                        <div className="form-group">
                            <button className="btn btn-success" onClick={this.handleAddPMO}>Add PMO</button>
                            <button className="btn btn-danger" onClick={this.handleRemovePMO}>Remove PMO</button>

                        </div>
                    </form>
                </div>

            </React.Fragment>

        );
    }
}

export default Role;