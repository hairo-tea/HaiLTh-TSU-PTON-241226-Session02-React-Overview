import CardBody from "./components/CardBody"
import CardHeader from "./components/CardHeader"
import StudentInfo from "./components/StudentInfo"
import StudentList from "./components/StudentList"
import Table from "./components/Table"
import "./main.css"
import "./app.css"
function App() {

  return (
    <>
      <div className="container">
        <StudentList />
        <StudentInfo />
      </div>
    </>
  )
}

export default App
