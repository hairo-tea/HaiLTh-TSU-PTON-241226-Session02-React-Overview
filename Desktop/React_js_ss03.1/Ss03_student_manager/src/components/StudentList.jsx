import React from 'react'
import CardHeader from './CardHeader'
import CardBody from './CardBody'

export default function StudentList() {
    return (
        <div className="col-lg-7 grid-margin stretch-card">
            <div className="card">
                {/* START CONTROL */}
                <CardHeader />
                {/* END CONTROL */}
                {/* START LIST STUDENT */}
                <CardBody />
            </div>
        </div>

    )
}
