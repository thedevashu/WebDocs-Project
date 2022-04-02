import React from "react"
import docpic from "../UI/assets/img/doctors/doctor-thumb-01.jpg"
import BookAppointment from "./BookAppointment"

export default class DoctorList extends React.Component {

    state = { doctor_Id: 0, doctor_DOB: new Date(), doctor_Name: '', doctor_Photo: null, doctor_Email: '', doctor_Gender: '', doctor_Mobile_number: '', doctor_Username: '', doctor_Password: '', doctor_Fees: 0, doctor_Experience: 0, doctors: [] }

    componentDidMount() {
        console.log("here")
        fetch("http://localhost:8080/doctor/getAll", {
            "method": "GET",
        }).then(response => {
            //   console.log(response.json()) 

            return response.json()
        }).then(jsondataarr => {
            this.setState({
                doctors: jsondataarr
            })
            // console.log(this.state.doctors);
        })

    }



    render() {

        return (
            <div>



                <div className="content">
                    <div className="container-fluid">

                        <div className="section-header text-center">
                            <div >

                                {/* <!-- Profile Widget --> */}

                                <div className="card widget-profile pat-widget-profile">
                                    <div className="card-body">
                                        <div className="pro-widget-content">
                                            {<div className="profile-info-widget">

                                                {this.state.doctors.map((e) => {
                                                    return (
                                                        <div>
                                                            <BookAppointment docId={e.doctor_Id}></BookAppointment>
                                                            <div className="profile-det-info">
                                                                <h3>{e.doctor_Name}</h3>

                                                                <div className="patient-details">


                                                                    <p>Date of Birth : <span>{e.doctor_DOB}</span></p>
                                                                    <p>Gender : <span>{e.doctor_Gender}</span></p>
                                                                    <p>Phone : <span>{e.doctor_Mobile_number}</span></p>
                                                                    <p>Experience : <span>{e.doctor_Experience}</span></p>
                                                                    <p>Fees : <span>{e.doctor_Fees}</span></p>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    )
                                                })}

                                            </div>}

                                        </div>
                                    </div>
                                </div>

                                {/* <!-- /Profile Widget --> */}
                            </div>
                        </div>
                    </div>
                </div>


            </div>
        )
    }

}