import React from 'react';


class Login extends React.Component {
    constructor(props) {
        super(props);

        // reset login status
       // this.props.logout();

        this.state = {
            username: '',
            password: '',
            submitted: false,
            errors: ''
        };

        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleChange(e) {
        const { name, value } = e.target;
        console.log("my state is"+e.target);
        console.log("my name is"+name+"value"+value)
        this.setState({ [name]: value });
    }

    handleSubmit(e) {
        e.preventDefault();

        this.setState({ submitted: true });
        const { username, password } = this.state;
        if (username && password) {
            const LoginRequest = {
                username: this.state.username,
                password: this.state.password
              };
          
            this.props.login(LoginRequest,this.props.history);
           console.log("hi");
        }
    }

    componentDidMount() {
        console.log("mount - login");
       
    }

   

    render() {
        const { username, password, submitted } = this.state;
        return (
            <div className="col-md-6 col-md-offset-3">
                <h2>Login</h2>
                <form name="form" onSubmit={this.handleSubmit}>
                    <div className={'form-group' + (submitted && !username ? ' has-error' : '')}>
                        <label htmlFor="username">Username</label>
                        <input type="text" className="form-control" id="username" name="username" value={username} onChange={this.handleChange} />
                        {submitted && !username &&
                            <div className="help-block">Username is required</div>
                        }
                    </div>
                    <div className={'form-group' + (submitted && !password ? ' has-error' : '')}>
                        <label htmlFor="password">Password</label>
                        <input type="password" className="form-control" id="password" name="password" value={password} onChange={this.handleChange} />
                        {submitted && !password &&
                            <div className="help-block">Password is required</div>
                        }
                    </div>
                    <div className="form-group">
                        <button className="btn btn-primary">Login</button>
 
                    </div>
                </form>
            </div>
        );
    }
}

export default Login;