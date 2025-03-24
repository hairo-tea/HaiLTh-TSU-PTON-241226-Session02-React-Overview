import React from 'react'
import './ColorBox.css'

export default function ColorBox({color,colorName}) {
    return (
        <div className='box-container'>
            <div className='box' style={{ backgroundColor: color }}>Box</div>
            {/* chỉ hiển thị nếu colorName đó tồn tại*/}
            {colorName && <div className='colorName'>{colorName}</div>}
        </div>
    )
}
