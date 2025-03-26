import React from 'react'
import Table from './Table'

export default function CardBody() {
    return (
        <div className="card-body">
            <h3 className="card-title">Danh sách sinh viên</h3>
            <div className="table-responsive pt-3">
                <Table />
            </div>
        </div>

    )
}
