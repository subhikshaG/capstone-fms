import React, { Component } from 'react'
import ApiService from '../../service/ApiService'
import { Redirect } from "react-router-dom";
class EventDashboard extends Component {

    constructor(props) {
        super(props)
        this.state = {
            totalEvents: null,
            livesImpacted: null,
            totalVolunteers: null,
            totalParticipants: null,
            message: null
        }

        this.reloadEventList = this.reloadEventList.bind(this);
    }


    componentDidMount() {
        this.reloadEventList();
    }

    reloadEventList() {
        ApiService.fetchEvents()
            .then((res) => {
                console.log(res);
                this.setState({
                    totalEvents: res.data.totalEvents,
                    livesImpacted: res.data.livesImpacted,
                    totalVolunteers: res.data.totalVolunteers,
                    totalParticipants: res.data.totalParticipants
                })
            });
    }

    render() {

        return (
            <React.Fragment>
                {
                    this.props.authentication ? <div className="container">
                        <h2 className="text-center">User Details</h2>

                        <table className="table table-striped">
                            <thead>
                                <tr>

                                    <th>totalEvents</th>
                                    <th>livesImpacted</th>
                                    <th>totalVolunteers</th>
                                    <th>totalParticipants</th>

                                </tr>
                            </thead>
                            <tbody>

                                <tr >
                                    <td>{this.state.totalEvents}</td>
                                    <td>{this.state.livesImpacted}</td>
                                    <td>{this.state.totalVolunteers}</td>
                                    <td>{this.state.totalParticipants}</td>

                                </tr>

                            </tbody>
                        </table>

                    </div> : <Redirect to="/login" />
                }
            </React.Fragment>


        );
    }

}
export default EventDashboard;
