import React from 'react'

export default function Calculation() {
    const a = 10;
    const b = 10;

    const sum = a + b;
    const subtract = a-b;
    const multiply = a*b;
    const division = a/b;

  return (
      <>
          <h2>Danh sách kết quả </h2>
          <ul>
              <li>{a} + { b}={sum}</li>
            <li>{a} - { b}{subtract}</li>
            <li>{a} * { b}{multiply}</li>
            <li>{a} / { b}{division}</li>                                                                                                                                                            
          </ul>
      </>
  )
}
