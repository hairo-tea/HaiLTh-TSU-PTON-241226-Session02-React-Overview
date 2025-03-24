import Calculation from './components/Calculation'
import ColorBox from './components/ColorBox'
import ListCourse from './components/ListCourse'
import UserInfo from './components/UserInfo'
import './components/ColorBox.css'
import FormatName from './components/FormatName'
import AdminIndex from './components/AdminIndex'
import './components/AdminIndex.css'

function App() {
  // color list of ColorBox
   const colors = [
    { color: 'red', colorName: 'Red' },
    { color: 'green', colorName: 'Green' },
   { color: 'blue', colorName: 'Blue' }
   ];

  return (
    <>
      <h1>Danh sách bài tập React </h1>
      <h2>Bài 1: Danh sách khóa học</h2>
      <ListCourse />
      <h2>Bài 2: Danh sách kết quả</h2>
      <Calculation />
      <h2>Bài 3:Thông tin cá nhân</h2>
      <UserInfo />
      <h2>Bài tập 4: Hiển thị màu sắc </h2>
      <div className='containerColor'>
        {colors.map((item, index) => (
          <ColorBox key ={index} color={item.color} colorName={item.colorName}/>         
      ))}
      </div>
      <FormatName /> 
        <h2> Bài 6: Xây dựng khung trang quản trị</h2>
      <AdminIndex /> 
    
    </>
  )
}

export default App
