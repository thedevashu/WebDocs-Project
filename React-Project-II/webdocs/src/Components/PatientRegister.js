import { Component } from 'react';
import login from '../UI/assets/img/login-banner.png';
import Navbar from './Navbar';
export default class PatientRegister extends Component{

    constructor()
    {
        super()
        this.state={patient_name:'',patient_DOB:'',patient_gender:'',patient_Mobile_Number:'',patient_Email:'',patient_Username:'',patient_Password:''}
       
    }

    sendPatient=(e)=>
    {
        fetch("http://localhost:8080/patient/add", {
            "method": "POST",
            "headers":{'Content-Type':'application/json'},
            "body": JSON.stringify({
			patient_Name: this.state.patient_name,
			patient_DOB: this.state.patient_DOB,
			patient_Gender: this.state.patient_gender,
			patient_Mobile_number:this.state.patient_Mobile_Number,
			patient_Email:this.state.patient_Email,
			patient_Username:this.state.patient_Username,
			patient_Password:this.state.patient_Password


           })
          })
         
    }

render(){
    return(
		<div>
		<Navbar></Navbar>
		
        <div className="content">
				<div className="container-fluid">
					
					<div className="row">
						<div className="col-md-8 offset-md-2">
								

							<div className="account-content">
								<div className="row align-items-center justify-content-center">
									<div className="col-md-7 col-lg-6 login-left">
										<img src={login} className="img-fluid" alt="Doccure Register"/>	
									</div>
									<div className="col-md-12 col-lg-6 login-right">
										<div className="login-header">
											<h3>Patient's Registration <a href="/patient/doctor">Are you a Doctor?</a></h3>
										</div>
										
										<form action="/patientlogin">
											<div className="form-group form-focus">
												<input type="text" className="form-control floating" name='patient_name' onBlur={(e)=>{this.setState({patient_name:e.target.value})}}/>
												<label className="focus-label">Name</label>
											</div>

											

											<div className="form-group form-focus">
												<input type="date" className="form-control floating" name='patient_DOB' onBlur={(e)=>{this.setState({patient_DOB:e.target.value})}}/>
												
											</div>
											
											<div>
												
												&nbsp;&nbsp;<label for="Gender">Gender&nbsp;:&nbsp;</label>
											<input type="radio" name="patient_gender" value="female" onBlur={(e)=>{this.setState({patient_gender:e.target.value})}}/>&nbsp;Female &nbsp; &nbsp;
											 <input type="radio" name="patient_gender" value="male" onBlur={(e)=>{this.setState({patient_gender:e.target.value})}}/>&nbsp;Male
											</div>

											<div className="form-group form-focus">
												<input type="text" className="form-control floating" name='patient_Mobile_number' onBlur={(e)=>{this.setState({patient_Mobile_Number:e.target.value})}}/>
												<label className="focus-label">Mobile Number</label>
											</div>

											<div className="form-group form-focus">
												<input type="email" className="form-control floating" name='patient_Email' onBlur={(e)=>{this.setState({patient_Email:e.target.value})}}/>
												<label className="focus-label">Email ID</label>
											</div>


											<div className="form-group form-focus">
												<input type="text" className="form-control floating" name='patient_Username' onBlur={(e)=>{this.setState({patient_Username:e.target.value})}}/>
												<label className="focus-label">Create Username</label>
											</div>

											<div className="form-group form-focus">
												<input type="password" className="form-control floating" name='patient_Password' onBlur={(e)=>{this.setState({patient_Password:e.target.value})}}/>
												<label className="focus-label">Create Password</label>
											</div>
											<div className="text-right">
												<a className="forgot-link" href="/patientlogin">Already have an account?</a>
											</div>
											<button className="btn btn-primary btn-block btn-lg login-btn" type="submit" onClick={this.sendPatient}>Register</button>
											
										</form>
									
										
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