import React from "react"
import "../css/custom.css"

const RomanNumeral = ({ numeral }) => {
  return (
    <div className="ui segment center-text light-grey-background">
      <h2 className="ui header">Result</h2>
      <p className="content roman-font font-size-2">{numeral}</p>
    </div>
  )
}

export default RomanNumeral
