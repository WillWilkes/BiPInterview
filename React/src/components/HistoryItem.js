import React from "react"

const HistoryItem = ({ history }) => {
  return (
    <div className="item">
      <div className="content roman-font font-size-1-point5">
        {history.latin} -> {history.numeral}
      </div>
    </div>
  )
}

export default HistoryItem
