import React from 'react'

export default function UserInfo() {
    const information = {
        username: "Nguyễn Văn A",
        gender: "Nam",
        birthday: "06 /03 / 2024",
        email: "nva@gmail.com",
        address: "Thanh Xuân, Hà Nội",
    
    };
  return (
    <div>
          <h2>Thông tin cá nhân </h2>
          <ul>
              <li>Họ và tên: <b>{information.username}</b></li>
              <li>Giới tính: <b>{information.gender}</b></li>
              <li>Ngày sinh: <b>{information.birthday}</b></li>
              <li>Email: <b>{information.email}</b></li>
              <li>Địa chỉ: <b>{information.address}</b></li>
          </ul>
    </div>
  )
}
