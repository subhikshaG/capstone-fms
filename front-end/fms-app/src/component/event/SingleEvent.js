import React, { Component } from 'react'

class SingleEvent extends Component {


    componentDidMount() {
        this.props.getEvent(Number(this.props.match.params.eventId));
        this.props.getSummary(Number(this.props.match.params.eventId));
    }
    render() {

        const event = this.props.event
        const summary = this.props.summary
        console.log("my event" + summary.summaryId)
        return <React.Fragment>
            <div className="card">
                <div className="card-body">
                    <h5 className="card-title text-center">Event No - {event.eventNo}</h5>
                    <h6 className="card-subtitle mb-2 text-muted text-center">Event Name - {event.eventName}</h6>
                    <p className="card-text text-center">Event Description - {event.eventDescription} </p>
                    <table className="table table-striped">
                        <thead>
                            <tr className="bg-primary">
                                <th>Beneficiary Name</th>
                                <th>Location</th>
                                <th>Month</th>
                                <th>Address</th>
                                <th>Council Name</th>
                                <th>Project</th>
                                <th>Category</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>{event.beneficiaryName}</td>
                                <td>{event.location}</td>
                                <td>{event.month}</td>
                                <td>{event.address}</td>
                                <td>{event.councilName}</td>
                                <td>{event.project}</td>
                                <td>{event.category}</td>
                            </tr>
                        </tbody>


                    </table>

                </div>
            </div>

            <div className="card p-5">
                <div className="card-body">
                    <h5 className="card-title text-center">Event Summary</h5>
             
                    <table className="table table-striped">
                        <thead>
                            <tr className="bg-primary">
                                <th>Total Volunteer</th>
                                <th>No Of Hours</th>
                                <th>Travel Hours</th>                                
                                <th>Lives Impacted</th>
                                <th>Average Volunteer Hours</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>{summary.totalVolunteer}</td>
                                <td>{summary.noOfHrs}</td>
                                <td>{summary.travelHrs}</td>
                                <td>{summary.livesImpact}</td>
                                <td>{summary.avgVolunteer}</td>
     
                            </tr>
                        </tbody>


                    </table>

                </div>
            </div>
        </React.Fragment>

    }
}
export default SingleEvent