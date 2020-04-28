import React, { Component } from 'react'
import axios from 'axios';


class EditFeedback extends Component {

    constructor(props) {
        super(props);
        this.state = {
            feedbackId: null,
            feedbackType: "",
            feedbackAnswerType: "",
            feedbackQuestion: "",
            feedbackAns: [],
            answer: [], //form array
            errors: {}
        }

    }


    componentWillReceiveProps(nextProps) {

        // if (nextProps.errors) {
        //     this.setState({ errors: nextProps.errors });
        // }
        console.log("here " + nextProps.feedback.feedbackAnswerType)

        const {
            feedbackId,
            feedbackType,
            feedbackAnswerType,
            feedbackQuestion,
            feedbackAns,
        } = nextProps.feedback;

        // const val = ["21a","324","2030"]
        if (nextProps.feedback.feedbackAns !== null) {
            nextProps.feedback.feedbackAns.map((value, indx) => {
                const newElement = { feedbackAnswer: value.feedbackAnswer }
                console.log("value" + value.feedbackAnswer)
                this.setState(prevState => ({
                    feedbackAns: [...prevState.feedbackAns, newElement]
                }))
            })
        }
        this.setState({
            feedbackId,
            feedbackType,
            feedbackAnswerType,
            feedbackQuestion
        });

    }


    componentDidMount() {
        console.log("id is" + this.props.match.params.feedbackId)
        if (this.props.match.params.feedbackId !== "null") {
            this.props.getFeedbackById(Number(this.props.match.params.feedbackId))
        }


    }

    onChange = (e) => {
        this.setState({ [e.target.name]: e.target.value });
        console.log("my name" + e.target.name + "value" + e.target.value)
    }

    onSubmit = (e) => {
        e.preventDefault();

        if (this.props.match.params.feedbackId !== "null") {
            const editedFeedback = {
                feedbackId: this.state.feedbackId,
                feedbackType: this.state.feedbackType,
                feedbackAnswerType: this.state.feedbackAnswerType,
                feedbackQuestion: this.state.feedbackQuestion,
                feedbackAns: this.state.feedbackAns,

            }

            if(this.state.feedbackAns!==null){
                this.state.feedbackAns.map((ans, idx) => {
                    console.log("my shareholder" + ans.feedbackAnswer)
                    this.state.answer[idx] = {feedbackId: this.state.feedbackId,feedbackAnswer:ans.feedbackAnswer}
                    console.log("answer" + this.state.answer[idx].feedbackAnswer +"id"+this.state.answer[idx].feedbackId)
                })
            }
            this.props.updateFeedback(editedFeedback, this.props.history);
            this.props.updateAnswerFeedback(this.state.answer,this.state.feedbackId);
        } else {
            const addFeedback = {

                feedbackType: this.state.feedbackType,
                feedbackAnswerType: this.state.feedbackAnswerType,
                feedbackQuestion: this.state.feedbackQuestion,
                feedbackAns: this.state.feedbackAns,

            }

            console.log("feedbackType -->"+this.state.feedbackType)


           this.props.addFeedback(addFeedback, this.props.history);
        }

    }

    handleFeedbackChange = idx => evt => {
        const newFeedbackAns = this.state.feedbackAns.map((feedback, sidx) => {
            if (idx !== sidx) return feedback;
            //  const feed = {feedbackId: this.state.feedbackId,feedbackAnswer: evt.target.value}
            return { ...feedback, feedbackAnswer: evt.target.value };
        });

        this.setState({ feedbackAns: newFeedbackAns });
    };

    handleAddAnswer = () => {
        this.setState({
            feedbackAns: this.state.feedbackAns.concat([{ feedbackAnswer: "" }])

        });
    };

    handleRemoveAnswer = idx => () => {
        this.setState({
            feedbackAns: this.state.feedbackAns.filter((s, sidx) => idx !== sidx)
        });
    };


    render() {
        return (
            <div className="project">
                <div className="container">
                    <div className="row">
                        <div className="col-md-8 m-auto">
                            <h5 className="display-4 text-center">Update Feedback</h5>
                            <hr style={{ marginBottom: '35px' }} />
                            <form onSubmit={this.onSubmit} noValidate>
                                <div className="form-group">
                                    <input
                                        type="text"
                                        id="feedbackQuestion"
                                        name="feedbackQuestion"
                                        className="form-control form-control-lg"
                                        value={this.state.feedbackQuestion}
                                        onChange={this.onChange}
                                        required
                                    />
                                    <label className="form-control-placeholder" htmlFor="feedbackQuestion">Feedback Question</label>

                                </div>

                                <div className="form-group">
                                    <label>
                                        Feedback Answer Type
                                        <select value={this.state.feedbackAnswerType} name="feedbackAnswerType" onChange={this.onChange}>
                                            <option value="Allow Multiple Answer">Allow Multiple Answer</option>
                                            <option value="Free text Answer">Free text Answer</option>
                                            <option value="Custom Question">Custom Question</option>

                                        </select>
                                    </label>

                                </div>

                                <div className="form-group">
                                    <label>
                                        Feedback Type
                                        <select value={this.state.feedbackType} name="feedbackType" onChange={this.onChange} selected>
                                            <option value="1">Participated</option>
                                            <option value="2">Not Participated</option>
                                            <option value="3">Unregistered</option>

                                        </select>
                                    </label>

                                </div>
                                <h4>Feedback Answer</h4>
                                {this.state.feedbackAns !== null ? <div> {this.state.feedbackAns.map((answer, idx) => (
                                    <div className="shareholder" key={idx}>
                                        <input
                                            type="text"
                                            placeholder={`feedbackAns #${idx + 1} name`}
                                            value={answer.feedbackAnswer}
                                            onChange={this.handleFeedbackChange(idx)}
                                        />
                                        <button
                                            type="button"
                                            onClick={this.handleRemoveAnswer(idx)}
                                            className="small"
                                        >
                                            Delete Answer
                                        </button>
                                    </div>
                                ))}</div> : <div></div>}

                                <button
                                    type="button"
                                    onClick={this.handleAddAnswer}
                                    className="small"
                                >
                                    Add Answer
                                </button>
                                <input
                                    type="submit"
                                    className="btn btn-primary btn-block mt-4"
                                    value="SUBMIT CHANGE" />
                            </form>


                        </div>
                    </div>
                </div>
            </div>
        )
    }
}



export default EditFeedback;
