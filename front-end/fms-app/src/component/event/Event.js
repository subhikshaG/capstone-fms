import React, { Component } from 'react'
import EventItem from './EventItem';

class Event extends Component {

    constructor(props) {
        super(props);
    }
    componentDidMount() {
        console.log("called so many times")
        this.props.getEvents();
    }

    render() {
        const { events } = this.props.events;
        return (

            <div className="container">
                <div className="row">
                    <div className="col-md-12">
                        <h1 className="display-4 text-center">Events</h1>
                    </div>
                    <hr />
                </div>
                <div className="row">

                    {events.map(event => (
                        <EventItem key={event.eventId} event={event} />
                    ))}

                </div>


            </div>
 
        );
    }

}
export default Event;
