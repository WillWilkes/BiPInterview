import React from "react"
import HistoryItem from "./HistoryItem"
import "../css/custom.css"

const HistoryList = ({ historyList }) => {
  const renderedList = historyList.map((history, index) => {
    return <HistoryItem history={history} key={history.latin * index} />
  })

  return (
    <div className="ui segment center-text" id="conversion-history">
      <h2 className="ui header">Conversion History</h2>
      <div className="ui relaxed divided list">{renderedList}</div>
    </div>
  )
}

export default HistoryList
