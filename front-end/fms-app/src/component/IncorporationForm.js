import React from "react";
import ReactDOM from "react-dom";

import "../App.css";

class IncorporationForm extends React.Component {
  constructor() {
    super();
    this.state = {
     feedbackId:0,
      feedbackAns: []
    };
  }

 

  handleFeedbackChange = idx => evt => {
    const newFeedbackAns = this.state.feedbackAns.map((feedback, sidx) => {
      if (idx !== sidx) return feedback;
    //  const feed = {feedbackId: this.state.feedbackId,feedbackAnswer: evt.target.value}
      return { ...feedback, feedbackAnswer: evt.target.value };
    });

    this.setState({ feedbackAns: newFeedbackAns });
  };

  handleSubmit = evt => {
    const { feedbackAns } = this.state;
  //  alert(`Incorporated: ${name} with ${feedbackAns.length} shareholders`);
  };

  handleAddAnswer = () => {
    this.setState({
      feedbackAns: this.state.feedbackAns.concat([{ feedbackAnswer:"" }])
    });
  };

  handleRemoveAnswer = idx => () => {
    this.setState({
        feedbackAns: this.state.feedbackAns.filter((s, sidx) => idx !== sidx)
    });
  };

  render() {
    return (
      <form onSubmit={this.handleSubmit}>
      

        <h4>Feedback Answer</h4>

        {this.state.feedbackAns.map((answer, idx) => (
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
        ))}
        <button
          type="button"
          onClick={this.handleAddAnswer}
          className="small"
        >
          Add Answer
        </button>
        <button>Incorporate</button>
      </form>
    );
  }
}

export default IncorporationForm;
