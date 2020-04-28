import React, { Component } from 'react'
import axios from 'axios';
import { Link } from "react-router-dom";
class Feedback extends Component {

    constructor(props) {
        super(props);
    }
    componentDidMount() {
        console.log("called so many times")
        this.props.getFeedback();
    }


    render() {
        const { feedbacks } = this.props.feedbacks;
        console.log("this feedback" + this.props.feedbacks)
        return (

            <div className="container">
                <h3 className="text-center">Feedback</h3>
                <Link className="btn btn-primary float-right mb-3" to={`/editfeedback/null`}>
                   + ADD FEEDBACK
                </Link>
                <table className="table table-striped table-dark">
                    <thead>
                        <tr>
                            <th>
                                Feedback ID
                             </th>
                            <th>
                                Feedback Question
                            </th>
                            <th>
                                Feedback Type
                            </th>
                            <th>
                                Actions
                            </th>
                        </tr>
                    </thead>

                    {feedbacks.map((feedback, index) => (

                        <tbody key={index}>
                            <tr>
                                <td>
                                    {feedback.body.feedbackId}
                                </td>
                                <td>
                                    {feedback.body.feedbackQuestion}
                                </td>
                                <td>
                                    {feedback.body.feedbackType === 2 ? "Not Participated" : feedback.body.feedbackType === 3 ? "Unregistered" : "Participated"}
                                </td>
                                <td>
                                    <Link className="btn btn-primary" to={`/editfeedback/${feedback.body.feedbackId}`}>
                                        EDIT
                                     </Link>
                                </td>
                            </tr>
                        </tbody>))}



                </table>



            </div>

        );
    }

}
export default Feedback;
