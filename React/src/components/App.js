import React from "react"
import SearchBar from "./SearchBar"
import HistoryList from "./HistoryList"
import RomanNumeral from "./RomanNumeral"
import "../css/custom.css"

class App extends React.Component {
  state = { error: "", numeral: "", latin: "", historyList: [] }

  onFormSubmit = numeral => {
    fetch("http://localhost:8080/convert/roman-numeral/" + numeral)
      .then(response => response.json())
      .then(data => this.updateState(data))
      .catch(() => {
        this.setState({ error: "Unable to reach API" })
      })
  }

  updateState = data => {
    this.setState({
      numeral: data.numeral,
      latin: data.latin,
      historyList: [
        {
          numeral: data.numeral,
          latin: data.latin,
        },
        ...this.state.historyList,
      ],
      error: "",
    })

    if (this.state.historyList.length > 4) {
      this.state.historyList.pop()
    }
  }

  render() {
    return (
      <div className="ui container mt-1">
        <div className="ui center-text error-message">{this.state.error}</div>
        <SearchBar onFormSubmit={this.onFormSubmit} />
        <div className="ui grid">
          <div className="ui row">
            <div className="five wide column">
              <HistoryList historyList={this.state.historyList} />
            </div>
            <div className="eleven wide column">
              <RomanNumeral numeral={this.state.numeral} />
            </div>
          </div>
        </div>
      </div>
    )
  }
}

export default App
