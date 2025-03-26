import React from 'react'

export default function Table() {
    const students = [
        {
            id: 1,
            studentCode: "SV001",
            studentName: "Nguyễn Văn A",
            age: 20,
            gender: "Nam",
        },
        {
            id: 2,
            studentCode: "SV002",
            studentName: "Nguyễn Văn B",
            age: 21,
            gender: "Nam",
        },
        {
            id: 3,
            studentCode: "SV003",
            studentName: "Nguyễn Văn C",
            age: 19,
            gender: "Nam",
        },

    ];

    return (
        <table className="table table-bordered">
            <thead>
                <tr>
                    <th>#</th>
                    <th>Mã sinh viên</th>
                    <th>Tên sinh viên</th>
                    <th>Tuổi</th>
                    <th>Giới tính</th>
                    <th>Hành động</th>
                </tr>
            </thead>
            <tbody>
                {students.map((student) => (
                    <tr key={student.id}>
                        <td>{student.id}</td>
                        <td>{student.studentCode}</td>
                        <td>{student.studentName}</td>
                        <td>{student.age}</td>
                        <td>{student.gender}</td>
                        <td>
                            <div className="template-demo">
                                <button
                                    type="button"
                                    className="btn btn-danger btn-icon-text"
                                >
                                    Xem
                                </button>
                                <button
                                    type="button"
                                    className="btn btn-warning btn-icon-text"
                                >
                                    Sửa
                                </button>
                                <button
                                    type="button"
                                    className="btn btn-success btn-icon-text"
                                >
                                    Xóa
                                </button>
                            </div>
                        </td>
                    </tr>))}

            </tbody>
        </table>
    )
}
