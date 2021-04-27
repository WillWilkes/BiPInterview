import React from "react"
import "../css/custom.css"

class SearchBar extends React.Component {
  state = { input: "", errorMessage: "" }

  onInputChange = event => {
    this.setState({ input: event.target.value })
  }

  onFormSubmit = event => {
    event.preventDefault()

    if (this.validateInput()) {
      this.setState({ errorMessage: "" })
      this.props.onFormSubmit(this.state.input)
    } else {
      this.setState({
        errorMessage:
          "Invalid input, you have not entered a number between 1 and 3999.",
      })
    }
  }

  //Confirms the input contains a value between 1-3999
  validateInput() {
    const regex = new RegExp("^[1-3]?[0-9]{1,3}$")

    return regex.test(this.state.input) && this.state.input !== "0"
  }

  render() {
    return (
      <div className="ui segment search-bar">
        <form className="ui form" onSubmit={this.onFormSubmit}>
          <div className="field">
            <h1 className="ui center aligned header">Roman Numerals</h1>
            <label className="ui center aligned header">
              Enter a number between 1-3999 to be converted
            </label>
            <input
              type="text"
              className="center-input center-text"
              id="search-bar"
              value={this.state.input}
              autocomplete="off"
              onChange={this.onInputChange}
            />
            <div className="center-text error-message mt-point5">
              {this.state.errorMessage}
            </div>
          </div>
        </form>
      </div>
    )
  }
}

export default SearchBar
