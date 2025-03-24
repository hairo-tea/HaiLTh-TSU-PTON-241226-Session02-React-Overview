import React from 'react'

export default function FormatName() {
    const user = {
        firstName: "Nguyễn Văn",
        lastName: "Nam",
    };
  return (
    <div>
          <h2>Bài 5: Format tên người dùng </h2>
          <div style={{fontSize:"20px"}}><b>Họ và tên:{user.firstName}{user.lastName} </b></div>
    </div>
  )
}
