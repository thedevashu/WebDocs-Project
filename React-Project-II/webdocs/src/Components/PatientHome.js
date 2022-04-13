import { useEffect, useState } from "react"
import { Link } from "react-router-dom"
import log from '../UI/assets/img/log.jpeg';
import logo from '../UI/assets/img/logo.png';
// import DoctorList from "./DoctorList";
import img1 from "../UI/assets/img/patients/patient.jpg"
import imgDoc from "../UI/assets/img/doctors/doctor-thumb-02.jpg"
import { useSelector } from "react-redux"
export default function PatientHome() {

	const patient = useSelector((state) => state.loggedPatient.patient)
	console.log(patient);
	const {
		patient_Id, patient_DOB, patient_Email, patient_Gender, patient_Mobile_number, patient_Name, appointments, feedbacks, patient_Username
	} = patient
	console.log(appointments);

	const renderList = appointments.map((appoinment) => {
		return (<><div></div></>)
	})
	return (
		<>

			<div className="breadcrumb-bar">
				<div className="container-fluid">
					<div className="row align-items-center">
						<div className="col-md-12 col-12">
							<nav aria-label="breadcrumb" className="page-breadcrumb">
								<ol className="breadcrumb">
									<li className="breadcrumb-item"><a href="index-2.html">Home</a></li>
									<li className="breadcrumb-item active" aria-current="page">Profile</li>
								</ol>
							</nav>
							<h2 className="breadcrumb-title">Profile</h2>
						</div>
					</div>
				</div>
			</div>

			<div className="content">
				<div className="container-fluid">

					<div className="row">
						<div className="col-md-5 col-lg-4 col-xl-3 theiaStickySidebar dct-dashbd-lft">


							<div className="card widget-profile pat-widget-profile">
								<div className="card-body">
									<div className="pro-widget-content">
										<div className="profile-info-widget">
											<a href="#" className="booking-doc-img">
												<img src={img1} alt="User Image" />
											</a>
											<div className="profile-det-info">
												<h3>{patient_Name}</h3>

												<div className="patient-details">
													<h5><b>Patient ID :</b> {patient_Id}</h5>
													<h5 className="mb-0"><i className="fas fa-map-marker-alt"></i> {patient_DOB}</h5>
												</div>
											</div>
										</div>
									</div>
									<div className="patient-info">
										<ul>
											<li>Phone <span>+91 {patient_Mobile_number}</span></li>
											<li>DOB <span>{patient_DOB}, {patient_Gender}</span></li>
											<li>Blood Group <span>AB+</span></li>
										</ul>
									</div>
								</div>
							</div>






						</div>

						<div className="col-md-7 col-lg-8 col-xl-9 dct-appoinment">
							<div className="card">
								<div className="card-body pt-0">
									<div className="user-tabs">
										<ul className="nav nav-tabs nav-tabs-bottom nav-justified flex-wrap">
											<li className="nav-item">
												<a className="nav-link active" href="#pat_appointments" data-toggle="tab">Appointments</a>
											</li>
											<li className="nav-item">
												<a className="nav-link" href="#pres" data-toggle="tab"><span>Prescription</span></a>
											</li>
											<li className="nav-item">
												<a className="nav-link" href="#medical" data-toggle="tab"><span className="med-records">Medical Records</span></a>
											</li>
											<li className="nav-item">
												<a className="nav-link" href="#billing" data-toggle="tab"><span>Billing</span></a>
											</li>
										</ul>
									</div>
									<div className="tab-content">


										<div id="pat_appointments" className="tab-pane fade show active">
											<div className="card card-table mb-0">
												<div className="card-body">
													<div className="table-responsive">
														<table className="table table-hover table-center mb-0">
															<thead>
																<tr>
																	<th>Doctor</th>
																	<th>Appt Date</th>
																	<th>Booking Date</th>
																	<th>Amount</th>
																	<th>Follow Up</th>
																	<th>Status</th>
																	<th></th>
																</tr>
															</thead>




														</table>
													</div>
												</div>
											</div>
										</div>








									</div>
								</div>
							</div>
						</div>
					</div>

				</div>

			</div>

		</>


	)

}