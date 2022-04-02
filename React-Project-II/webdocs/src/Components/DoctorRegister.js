import { Component } from 'react';
import login from '../UI/assets/img/login-banner.png';
import { Link } from 'react-router-dom';
import Navbar from './Navbar';
export default class DoctorRegister extends Component {

	constructor() {
		super()
		this.state = {
			doctor_Name: '', doctor_DOB: '', doctor_Gender: '', doctor_Mobile_number: '', doctor_Email: '', doctor_Username: '', doctor_Password: '', doctor_License_Number: '', doctor_Fees: '', doctor_Experience: '',
			hospital: 0, hospitals: []
		}

	}


	componentDidMount() {

		var promise = fetch("http://localhost:8080/hospital/getAll", {
			"method": "GET",
		})
		var anotherpromise = promise.then(response => {
			// console.log(response.json())
			return response.json()
		})
		anotherpromise.then(jsondataarr => {

			this.setState({
				hospitals: jsondataarr

			})
		})
		console.log(this.state.hospitals)


		promise.catch(err => {
			console.log(err);
		});


	}

	// selectHospital=(e)=>
	// {

	//  var opts = this.state.hospitals.map((obj)=>{ return <option key={obj.hospital_id}>{obj.hospital_Name} </option>})  

	//     return opts
	// }


	sendDoctor = (e) => {
		console.log("send doc");
		fetch(`http://localhost:8080/doctor/add/` + this.state.hospital, {
			"method": "POST",
			"headers": { 'Content-Type': 'application/json' },
			"body": JSON.stringify({
				doctor_Name: this.state.doctor_Name,
				doctor_DOB: this.state.doctor_DOB,
				doctor_Gender: this.state.doctor_Gender,
				doctor_Mobile_number: this.state.doctor_Mobile_number,
				doctor_Email: this.state.doctor_Email,
				doctor_Username: this.state.doctor_Username,
				doctor_Password: this.state.doctor_Password,
				doctor_License_Number: this.state.doctor_License_Number,
				doctor_Fees: this.state.doctor_Fees,
				doctor_Experience: this.state.doctor_Experience,



			})
		})

	}


	render() {
		return (
			<div>
				<Navbar></Navbar>
				<div className="content">
					<div className="container-fluid">
						<div className="row">
							<div className="col-md-8 offset-md-2">


								<div className="account-content">
									<div className="row align-items-center justify-content-center">
										<div className="col-md-7 col-lg-6 login-left">
											<img src={login} className="img-fluid" alt="Login Banner" />
										</div>
										<div className="col-md-12 col-lg-6 login-right">
											<div className="login-header">
												<h3>Doctor's Registration <a href="/doctor/patient">Not a Doctor?</a></h3>
											</div>


											<div className="form-group form-focus">
												<input type="text" className="form-control floating" name='doctor_Name' onBlur={(e) => { this.setState({ doctor_Name: e.target.value }) }} />
												<label className="focus-label">Name</label>
											</div>
											<div className="form-group form-focus">
												<input type="date" className="form-control floating" name='doctor_DOB' onChange={(e) => { this.setState({ doctor_DOB: e.target.value }) }} />

											</div>

											<div>

												&nbsp;&nbsp;<label for="Gender">Gender&nbsp;:&nbsp;</label>
												<input type="radio" name="doctor_Gender" value="female" onChange={(e) => { this.setState({ doctor_Gender: e.target.value }) }} />&nbsp;Female &nbsp; &nbsp;
												<input type="radio" name="doctor_Gender" value="male" onChange={(e) => { this.setState({ doctor_Gender: e.target.value }) }} />&nbsp;Male
											</div>



											<div className="form-group form-focus">
												<input type="text" className="form-control floating" name='doctor_Mobile_number' onBlur={(e) => { this.setState({ doctor_Mobile_number: e.target.value }) }} />
												<label className="focus-label">Mobile Number</label>
											</div>

											<div className="form-group form-focus">
												<input type="email" className="form-control floating" name='doctor_Email' onBlur={(e) => { this.setState({ doctor_Email: e.target.value }) }} />
												<label className="focus-label">Email ID</label>
											</div>


											<div className="form-group form-focus">
												<input type="text" className="form-control floating" name='doctor_License_Number' onBlur={(e) => { this.setState({ doctor_License_Number: e.target.value }) }} />
												<label className="focus-label">License Number</label>
											</div>





											<div className="form-group form-focus">
												<select name='hospitals' onChange={(e) => {

													this.setState({ hospital: e.target.value })
													console.log(this.state.hospital);
												}}>
													{this.state.hospitals.map((e) => <option value={e.hospital_id}>{e.hospital_Name}</option>)}
												</select>
											</div>

											<div className="form-group form-focus">
												<input type="number" className="form-control floating" name='doctor_Experience' onBlur={(e) => { this.setState({ doctor_Experience: e.target.value }) }} />
												<label className="focus-label">Experience(in years)</label>
											</div>

											<div className="form-group form-focus">
												<input type="number" className="form-control floating" name='doctor_Fees' onBlur={(e) => { this.setState({ doctor_Fees: e.target.value }) }} />
												<label className="focus-label">Fees</label>
											</div>


											<div className="form-group form-focus">
												<input type="text" className="form-control floating" name='doctor_Username' onBlur={(e) => { this.setState({ doctor_Username: e.target.value }) }} />
												<label className="focus-label">Create Username</label>
											</div>

											<div className="form-group form-focus">
												<input type="password" className="form-control floating" name='doctor_Password' onBlur={(e) => { this.setState({ doctor_Password: e.target.value }) }} />
												<label className="focus-label">Create Password</label>
											</div>
											<div className="text-right">
												<a className="forgot-link" href="/login">Already have an account?</a>
											</div>
											<Link className="btn btn-primary btn-block btn-lg login-btn" type="submit" to="/" onClick={this.sendDoctor}>Register</Link>




										</div>
									</div>
								</div>


							</div>
						</div>

					</div>
				</div>
			</div>
		)
	}
}