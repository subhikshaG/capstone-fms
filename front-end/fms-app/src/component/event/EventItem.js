import React, { Component } from "react";
import { Link } from "react-router-dom";

class EventItem extends Component {
    render() {
        const { event } = this.props;
        return (
            <div className="col-12">
                <div className="card card-body bg-light mb-3">
                    <div className="row">
                        <div className="col-2">
                            <span className="mx-auto">
                                <Link className="btn btn-primary" to={`/event/${event.eventId}`}>
                                    View
                                </Link>
                            </span>
                        </div>
                        <div className="col-lg-6 col-md-4 col-8">
                            <span className="mx-auto p-2 float-right">{event.eventNo}</span>
                            <span className="mx-auto p-2 float-right">{event.month}</span>
                            <span className="mx-auto p-2 float-right">{event.location}</span>
                        </div>

                    </div>
                    <div className="row mt-2">
                        <div className="col-6">
                            <span className="mx-auto ">Event Name</span>
                        </div>
                        <div className="col-6">
                            <span className="mx-auto text-right">{event.eventName}</span>
                        </div>

                    </div>
                    <div className="row">
                        <div className="col-6">
                            <span className="mx-auto ">Event Address</span>
                        </div>
                        <div className="col-6">
                            <span className="mx-auto text-right">{event.address}</span>
                        </div>

                    </div>
                    <div className="row">
                        <div className="col-6">
                            <span className="mx-auto">Event Category</span>
                        </div>
                        <div className="col-6">
                            <span className="mx-auto  text-right">{event.category}</span>
                        </div>

                    </div>
                </div>
            </div>
        );
    }
}

export default EventItem;