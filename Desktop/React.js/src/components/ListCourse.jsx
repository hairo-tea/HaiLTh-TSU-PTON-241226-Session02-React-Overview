import React from 'react'

export default function ListCourse() {
    const courses= ["HTML", "CSS", "JavaScript", "ReactJS"];
    return (
    <>
            <h2>Danh sách khóa học </h2>
            <ol>
              {courses.map((course, index) => (
              <li key={index}>{course}</li>
        ))}
            </ol>
    </>
  )
}
